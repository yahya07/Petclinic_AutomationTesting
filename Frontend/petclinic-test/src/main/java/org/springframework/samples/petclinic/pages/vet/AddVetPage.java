package org.springframework.samples.petclinic.pages.vet;


import org.openqa.selenium.WebDriver;
import org.springframework.samples.petclinic.pages.Page;


public class AddVetPage extends Page {
    private String url = "http://localhost:8081/petclinic/vets/add";
    private String saveBtn = "#vet > div:nth-child(5) > div > button:nth-child(3)";
    private String errClass = "help-block";
    private String twoCharErr = "First name must be at least 2 characters long";



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

        cssClick(saveBtn);
        return new AllVetsPage(driver);
    }

    public void clickSave()
    {
        cssClick(saveBtn);
    }


    public boolean isTwoCharErrorShowing()
    {
        return isErrorShowing(errClass, twoCharErr);
    }

    public boolean pageNotRedirected(){

        return isCurrentUrl(url);
}

}
