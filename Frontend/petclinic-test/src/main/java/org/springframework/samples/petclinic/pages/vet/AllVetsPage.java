package org.springframework.samples.petclinic.pages.vet;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.samples.petclinic.pages.Page;

import java.util.List;
import java.util.stream.Collectors;

public class AllVetsPage extends Page {


    private String url = "http://localhost:8081/petclinic/vets";
    private String deleteBtn = "#vets > tbody > tr:nth-child(1) > td:nth-child(3) > button:nth-child(2)";
    private String editBtn = "#vets > tbody > tr:nth-child(1) > td:nth-child(3) > button:nth-child(1)";
    private String allVetsTable = "/html/body/app-root/app-vet-list/div/div/table/tbody/tr/td[1]";
    private String allVetsTableID = "vets";
    private int allRowsCount = 0;
    private int remainingRowsCount = 0;
    public AllVetsPage(WebDriver driver) {
        super("Veterinarians",driver);
    }


    public boolean exists(String str) {
        List<WebElement> table_elements = getElements(allVetsTable);
        List<String> names = table_elements.stream()
                .map(name -> name.getText())
                .collect(Collectors.toList());
        return names.contains(str);
    }

    public void getCurrentRowsCount()
    {
        allRowsCount = getElements(allVetsTable).size();
    }




    public void deleteFirst()  {
        cssClick(deleteBtn);
        refresh();
        remainingRowsCount = getElements(allVetsTable).size();
    }

    public EditVetPage editFirst() {
        cssClick(editBtn);
        return new EditVetPage(driver);
    }

    public boolean isDeleted()
    {
        return (remainingRowsCount < allRowsCount );
    }









}
