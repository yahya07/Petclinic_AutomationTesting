package org.springframework.samples.petclinic.pages.vet;

import org.openqa.selenium.WebDriver;
import org.springframework.samples.petclinic.pages.Page;

public class EditVetPage extends Page {

    private String saveBtn = "#vet_form > div:nth-child(5) > div > button:nth-child(3)";
    private String backBtn = "#vet_form > div:nth-child(5) > div > button:nth-child(2)";
    private String errClass = "help-block";
    private String fnameBlankError = "First name must be at least 2 characters long";
    private String lnameBlankError = "First name must be at least 2 characters long";



    public EditVetPage(WebDriver driver) {

        super("Edit Veterinarian",driver);
    }

    public void fillData(String fname, String lname) {
        fill("firstName", fname);
        fill("lastName", lname);
    }

    public AllVetsPage saveAndRedirect() {

        cssClick(saveBtn);
        return new AllVetsPage(driver);
    }

    public AllVetsPage backAndRedirect() {

        implicitlyWait(5);
        cssClick(backBtn);
        return new AllVetsPage(driver);
    }

    public boolean isFieldsBlankErrorShowing()
    {

        return isErrorShowing(errClass, fnameBlankError) && isErrorShowing(errClass, lnameBlankError);
    }

    public boolean saveButtonDisabled()
    {
        return isElementEnabled(saveBtn);
    }








}
