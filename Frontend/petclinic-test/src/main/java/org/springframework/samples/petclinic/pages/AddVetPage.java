package org.springframework.samples.petclinic.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddVetPage extends Page {
    private static final String URL = "http://localhost:8081/petclinic/vets/add";
    private static final String HEADER_XPATH = "/html/body/app-root/app-vet-add/div/div/h2";
    private static final String TITLE = "New Veterinarian";
    private static final String SAVE_BUTTON = "#vet > div:nth-child(5) > div > button:nth-child(3)";
    private static final String FIRST_NAME = "Foo";
    private static final String LAST_NAME = "Bar";
    private static final String ALL_VETS_TABLET = "/html/body/app-root/app-vet-list/div/div/table/tbody/tr/td[1]";
    private static final String FULL_NAME = FIRST_NAME + " " + LAST_NAME;

    public AddVetPage() {
        super(TITLE, HEADER_XPATH);
    }

    public void navigateToAddVet() {
        goTo(URL);
    }

    public void fillValid() {
        fill("firstName", FIRST_NAME);
        fill("lastName", LAST_NAME);
        selectFirst("specialties");

    }

    public void clickSave() {
        cssClick(SAVE_BUTTON);
    }

    public boolean isAdded() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       List<WebElement> tableElements = driver.findElements(By.xpath(ALL_VETS_TABLET));
       return FULL_NAME.equals(tableElements.get(tableElements.size()-1).getText());

}

}
