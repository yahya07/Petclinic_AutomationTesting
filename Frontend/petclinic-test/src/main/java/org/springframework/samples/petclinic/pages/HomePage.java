package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.samples.petclinic.pages.petTypesPage.PetTypesPage;

public class HomePage extends Page {
    private static final String URL = "http://localhost:8081/petclinic/";
    private static final String PATH_PET_TYPES = "body > app-root > div.container-fluid > nav > div > ul > li:nth-child(4) > a > span:nth-child(2)";

    public HomePage() { super("Welcome", new ChromeDriver());
        goToHome();
    }

    public void goToHome() {
        super.goTo(URL);
    }


    public PetTypesPage goToPetTypes(){
        cssClick(PATH_PET_TYPES);
        return new PetTypesPage(driver);
    }

}
