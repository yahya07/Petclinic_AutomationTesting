package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.samples.petclinic.pages.owner.AddOwnerPage;
import org.springframework.samples.petclinic.pages.owner.AllOwnersPage;

public class HomePage extends Page {

    private static final String URL = "http://localhost:8081/petclinic/";

    private static final String OWNER_TAB_SELECTOR="OWNERS";
    private static final String ALL_OWNERS_TAB_SELECTOR="ALL";
    private static final String ADD_OWNER_TAB_SELECTOR="body > app-root > div.container-fluid > nav > div > ul > li.dropdown.open > ul > li:nth-child(2) > a > span:nth-child(2)";
    private String pathOwnersDropdown = "body > app-root > div.container-fluid > nav > div > ul > li:nth-child(2) > a";
    private String pathOwners = "body > app-root > div.container-fluid > nav > div > ul > li.dropdown.open > ul > li:nth-child(1) > a";
    private String pathAddOwner = "body > app-root > div.container-fluid > nav > div > ul > li.dropdown.open > ul > li:nth-child(2) > a";

    public HomePage(){
super("Welcome", new ChromeDriver());
goToHome();
    }

    public void goToHome() {
        super.goTo(URL);
    }
//    public void clickOwners()
//    {
//
//        linkTextClick(OWNER_TAB_SELECTOR);
//    }

    public AllOwnersPage goToOwnersList()
    {
//        linkTextClick(OWNER_TAB_SELECTOR);
//        linkTextClick(ALL_OWNERS_TAB_SELECTOR);
//        return new AllOwnersPage(super.driver);
        cssClick(pathOwnersDropdown);
        cssClick(pathOwners);
        return new AllOwnersPage(driver);
    }

    public AddOwnerPage goToAddOwner() {
//        linkTextClick(OWNER_TAB_SELECTOR);
//        cssClick(ADD_OWNER_TAB_SELECTOR);
//        return new AddOwnerPage(super.driver);
        cssClick(pathOwnersDropdown);
        cssClick(pathAddOwner);
        return new AddOwnerPage(driver);
    }
}
