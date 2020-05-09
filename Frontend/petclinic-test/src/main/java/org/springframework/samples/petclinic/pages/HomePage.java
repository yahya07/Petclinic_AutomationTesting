package org.springframework.samples.petclinic.pages;

public class HomePage extends Page {

    private static final String URL = "http://localhost:8081/petclinic/welcome";
    private static final String VETERINARIANS_TAB_SELECTOR = "body > app-root > div.container-fluid > nav > div > ul > li:nth-child(3) > a";
    private static final String ALLVETS_TAB_SELECTOR = "body > app-root > div.container-fluid > nav > div > ul > li.dropdown.open > ul > li:nth-child(1) > a > span:nth-child(2)";

    public HomePage() {
        super("Welcome");
    }

    public void navigateToHome()
    {
        goTo(URL);
    }

    public void clickVeterinarians()
    {
        cssClick(VETERINARIANS_TAB_SELECTOR);
    }

    public void clickAllVets()
    {
        cssClick(ALLVETS_TAB_SELECTOR);
    }
    public boolean isRedirected()
    {
        return !isNotRedirected(URL);
    }









}
