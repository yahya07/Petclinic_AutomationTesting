package org.springframework.samples.petclinic.pages.vet;

import org.openqa.selenium.WebDriver;
import org.springframework.samples.petclinic.pages.Page;

public class EditVetPage extends Page {

    private static final String SAVE_BUTTON = "#vet_form > div:nth-child(5) > div > button:nth-child(3)";
    private static final String BACK_BUTTON = "#vet_form > div:nth-child(5) > div > button:nth-child(2)";
    private static final String ERROR_CLASS = "help-block";
    private static final String FIRST_NAME_BLANK_ERROR = "First name must be at least 2 characters long";
    private static final String LAST_NAME_BLANK_ERROR = "First name must be at least 2 characters long";



    public EditVetPage(WebDriver driver) {

        super("Edit Veterinarian",driver);
    }

    public void fillData(String fname, String lname) {
        fill("firstName", fname);
        fill("lastName", lname);
    }

    public AllVetsPage saveAndRedirect() {

        cssClick(SAVE_BUTTON);
        return new AllVetsPage(driver);
    }

    public AllVetsPage backAndRedirect() {

        cssClick(BACK_BUTTON);
        return new AllVetsPage(driver);
    }

    public boolean isFieldsBlankErrorShowing()
    {

        return isErrorShowing(ERROR_CLASS,FIRST_NAME_BLANK_ERROR) && isErrorShowing(ERROR_CLASS,LAST_NAME_BLANK_ERROR);
    }

    public boolean saveButtonDisabled()
    {
        return isElementEnabled(SAVE_BUTTON);
    }








}
