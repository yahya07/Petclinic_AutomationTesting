package org.springframework.samples.petclinic.pages.petTypesPage;

import org.openqa.selenium.WebDriver;
import org.springframework.samples.petclinic.pages.Page;

public class EditPetTypePage extends Page {

    private static final String URL = "http://localhost:8081/petclinic/pettypes";
    private static final String UpdateButton = "#pettype > div.form-group.has-feedback > div > button:nth-child(3)";
    private final String NameFiled = "name";
    private final String CancelButton= "#pettype > div.form-group.has-feedback > div > button:nth-child(4)";



    protected EditPetTypePage(WebDriver driver) { super("Edit Pet Type",driver); }


    public void gotoPetTypesPage() {
        goTo(URL);

    }

    public void NameFiled(String EditFiled) {
       fill(NameFiled, EditFiled);

    }


    public PetTypesPage UpdateButton() {
       cssClick(UpdateButton);
       implicitlyWait(5);
       return  new PetTypesPage(driver);
    }

    public void removeText() {
        clearField("#name");
    }

    public PetTypesPage ClickCancel(){
        cssClick(CancelButton);
        return  new PetTypesPage(driver);
    }
}
