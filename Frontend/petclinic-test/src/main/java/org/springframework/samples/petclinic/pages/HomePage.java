package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage extends Page {
    private static final String OWNER_TAB_SELECTOR="OWNERS";
    private static final String ALL_OWNERS_TAB_SELECTOR="ALL";

    public HomePage(){
super(new ChromeDriver(),"Welcome");
goTo("http://localhost:8081/petclinic/");
    }
    public void clickOwners()
    {
        linkTextClick(OWNER_TAB_SELECTOR);
    }

    public AllOwnersPage clickAllOwners()
    {
        linkTextClick(ALL_OWNERS_TAB_SELECTOR);
        return new AllOwnersPage(super.driver);
    }
    
}
