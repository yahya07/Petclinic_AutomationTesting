package org.springframework.samples.petclinic.pages.vet;


import org.openqa.selenium.WebDriver;
import org.springframework.samples.petclinic.pages.Page;


public class AddVetPage extends Page {
    private static final String URL = "http://localhost:8081/petclinic/vets/add";
    private static final String SAVE_BUTTON = "#vet > div:nth-child(5) > div > button:nth-child(3)";
    private static final String ERROR_CLASS = "help-block";
    private static final String TWO_CHARS_ERROR = "First name must be at least 2 characters long";



    public AddVetPage(WebDriver driver) {
        super("New Veterinarian",driver);
    }


    public void fillData(String fname, String lname) {
        fill("firstName", fname);
        fill("lastName", lname);
    }

    public void chooseType()
    {
        selectFirst("specialties");
    }

    public AllVetsPage saveAndRedirect() {

        cssClick(SAVE_BUTTON);
        return new AllVetsPage(driver);
    }

    public void clickSave()
    {
        cssClick(SAVE_BUTTON);
    }


    public boolean isTwoCharErrorShowing()
    {
        return isErrorShowing(ERROR_CLASS,TWO_CHARS_ERROR);
    }

    public boolean pageNotRedirected(){

        return isCurrentUrl(URL);
}

}
