package org.springframework.samples.petclinic.pages.pet;

import org.openqa.selenium.WebDriver;
import org.springframework.samples.petclinic.pages.OwnerInformationPage;
import org.springframework.samples.petclinic.pages.Page;

public class AddPetPage extends Page {


    public AddPetPage(WebDriver driver) {
        super("Add Pet",driver);
    }


    public void fillInForm(String name, String birthDate, int index) {

        fill("name", name);
        cssFill("body > app-root > app-pet-add > div > div > form > div:nth-child(5) > div > input", birthDate);
        select("type", index);

    }

    public OwnerInformationPage submit() {
        cssClick("body > app-root > app-pet-add > div > div > form > div:nth-child(7) > div > button:nth-child(3)");
        return new OwnerInformationPage(driver);
    }

}
