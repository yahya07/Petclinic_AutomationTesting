package org.springframework.samples.petclinic.pages.vet;

import org.openqa.selenium.WebDriver;
import org.springframework.samples.petclinic.pages.Page;

public class EditVetPage extends Page {

    private static final String SAVE_BUTTON = "#vet_form > div:nth-child(5) > div > button:nth-child(3)";
    private static final String FIRST_NAME_INPUT = "#firstName";
    private static final String LAST_NAME_INPUT = "#lastName";



    public EditVetPage(WebDriver driver) {
        super("Edit Veterinarian",driver);
    }

    public void fillValid(String fname, String lname) {
        fill("firstName", fname);
        fill("lastName", lname);
    }


    public AllVetsPage saveAndRedirect() {

        cssClick(SAVE_BUTTON);
        return new AllVetsPage(driver);
    }




}
