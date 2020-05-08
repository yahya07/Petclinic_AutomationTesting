package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class OwnerInformationPage extends Page {


    protected OwnerInformationPage(String title) {
        super("Owner Information");
    }


    public String lastAddedPetName(){
        implicitlyWait(1);
        List<WebElement> pets = getElements("/html/body/app-root/app-owner-detail/div/div/table[2]/tr/app-pet-list/table/tr/td[1]/dl/dd[1]");
        return pets.get(pets.size()-1).getText();
    }

}
