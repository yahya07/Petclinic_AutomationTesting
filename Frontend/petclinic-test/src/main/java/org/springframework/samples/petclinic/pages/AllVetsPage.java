package org.springframework.samples.petclinic.pages;


import org.openqa.selenium.json.JsonOutput;

public class AllVetsPage extends Page{


    private static final String URL = "http://localhost:8081/petclinic/vets";
    private static final String HEADER_XPATH = "/html/body/app-root/app-vet-list/div/div/h2";
    private static final String TITLE = "Veterinarians";
    private static final String DELETE_BUTTON = "#vets > tbody > tr:nth-child(1) > td:nth-child(3) > button:nth-child(2)";
    private static final String ALL_VETS_TABLET = "/html/body/app-root/app-vet-list/div/div/table/tbody/tr/td[1]";
    private int allRowsCount = 0;
    private int remainingRowsCount = 0;
    public AllVetsPage() {
        super(TITLE, HEADER_XPATH);
    }

    public void navigateToAllPets() {
        goTo(URL);
        allRowsCount =allTableElements(ALL_VETS_TABLET).size();
    }


    public void deleteFirst()
    {
        cssClick(DELETE_BUTTON);
        goTo(URL);
        remainingRowsCount = allTableElements(ALL_VETS_TABLET).size();
    }

    public boolean isDeleted()
    {
        return (remainingRowsCount < allRowsCount );
    }









}
