package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.WebDriver;

public class OwnerPage extends Page{
    public static final String URL= "first name tester";

    public OwnerPage(WebDriver driver) {
        super(driver,"New Owner");
       // goTo(URL);
    }

}
