package org.springframework.samples.petclinic.pages;

public class HomePage extends Page {
    private static final String URL = "http://localhost:8081/petclinic/";
    private static final String PetTypeTabCSS = "body > app-root > div.container-fluid > nav > div > ul > li:nth-child(4) > a > span:nth-child(2)";

    public HomePage() {
        super("Welcome");
    }

    public void navigateHomePage()
    {
        goTo(URL);
    }

    public void clickPetTypeTab()
    {
        cssClick(PetTypeTabCSS);
    }
}
