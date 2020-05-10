package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.chrome.ChromeDriver;

public class HomePage extends Page {
    private static final String OWNER_TAB_SELECTOR="OWNERS";
    private static final String ALL_OWNERS_TAB_SELECTOR="ALL";
    private static final String ADD_OWNER_TAB_SELECTOR="body > app-root > div.container-fluid > nav > div > ul > li.dropdown.open > ul > li:nth-child(2) > a > span:nth-child(2)";

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

    public AddOwnerPage ClickAddOwner() {
        cssClick(ADD_OWNER_TAB_SELECTOR);
        return new AddOwnerPage(super.driver);
    }
}
