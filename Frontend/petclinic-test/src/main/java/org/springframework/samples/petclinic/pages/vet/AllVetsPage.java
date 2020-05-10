package org.springframework.samples.petclinic.pages.vet;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.json.JsonOutput;
import org.springframework.samples.petclinic.pages.Page;

public class AllVetsPage extends Page {


    private static final String URL = "http://localhost:8081/petclinic/vets";
    private static final String DELETE_BUTTON = "#vets > tbody > tr:nth-child(1) > td:nth-child(3) > button:nth-child(2)";
    private static final String ALL_VETS_TABLET = "/html/body/app-root/app-vet-list/div/div/table/tbody/tr/td[1]";
    private int allRowsCount = 0;
    private int remainingRowsCount = 0;
    public AllVetsPage(WebDriver driver) {
        super("Veterinarians",driver);
    }

    public void navigateToAllPets() {
        goTo(URL);
        allRowsCount =getElements(ALL_VETS_TABLET).size();
    }


    public void deleteFirst()
    {
        cssClick(DELETE_BUTTON);
        refresh();
        remainingRowsCount = getElements(ALL_VETS_TABLET).size();
    }

    public boolean isDeleted()
    {
        return (remainingRowsCount < allRowsCount );
    }









}
