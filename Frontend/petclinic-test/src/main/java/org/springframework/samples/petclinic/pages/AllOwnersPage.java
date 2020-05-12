package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.WebDriver;

public class AllOwnersPage extends Page {

    public AllOwnersPage(WebDriver driver) {
        super("Owners", driver);
    }

    public OwnerInformationPage getFirstOwner(){
        implicitlyWait(1);
        cssClick("body > app-root > app-owner-list > div > div > div > table > tbody > tr:nth-child(1) > td.ownerFullName > a");
        return new OwnerInformationPage(driver);
    }

    public OwnerInformationPage getSixthOwner(){
        implicitlyWait(1);
        cssClick("body > app-root > app-owner-list > div > div > div > table > tbody > tr:nth-child(6) > td.ownerFullName > a");
        return new OwnerInformationPage(driver);
    }

}
