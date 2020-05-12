package org.springframework.samples.petclinic.pages.owner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.samples.petclinic.pages.Page;
import org.springframework.samples.petclinic.pages.owner.EditOwnerPage;

public class OwnerInformationPage extends Page {


    public OwnerInformationPage(WebDriver driver) {
        super("Owner Information", driver);

    }


    public EditOwnerPage clickEditOwner() {

        cssClick("body > app-root > app-owner-detail > div > div > button:nth-child(4)");

        return new EditOwnerPage(driver);
    }

    public boolean isUpdated(String FIRST_NAME, String LAST_NAME) {
        String fullName = FIRST_NAME + " " + LAST_NAME;
        System.out.println(fullName + getText("/html/body/app-root/app-owner-detail/div/div/table[1]/tr[1]/td/b"));
        return fullName.equals(getText("/html/body/app-root/app-owner-detail/div/div/table[1]/tr[1]/td/b"));
    }

}
