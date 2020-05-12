package org.springframework.samples.petclinic.pages.owner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.samples.petclinic.pages.Page;

public class EditOwnerPage extends Page {
    private final String FIRST_NAME_SELECTOR="firstName";
    private final String LAST_NAME_SELECTOR="lastName";
    private final String ADDRESS_SELECTOR="address";
    private final String CITY_SELECTOR="city";
    private final String TELEPHONE_SELECTOR="telephone";
    private final String UPDATED_TEXT="Updated";
    private final String UPDATED_PHONE_NUM="11111";
    private final String UPDATE_BUTTON="body > app-root > app-owner-edit > div > div > form > div:nth-child(7) > div > button:nth-child(2)";

    public EditOwnerPage(WebDriver driver){
        super("Edit Owner", driver);
    }
    public void clearField(){
        clearField("#firstName");
        clearField("#lastName");
        clearField("#address");
        clearField("#city");
        clearField("#telephone");
    }
    public void enterValidUpdatedData(){
        fill(FIRST_NAME_SELECTOR,UPDATED_TEXT);
        fill(LAST_NAME_SELECTOR,UPDATED_TEXT);
        fill(ADDRESS_SELECTOR,UPDATED_TEXT);
        fill(CITY_SELECTOR,UPDATED_TEXT);
        fill(TELEPHONE_SELECTOR,UPDATED_PHONE_NUM);


    }
    public boolean checkRetrieval(){
        boolean firstName= getText("//*[@id=\"firstName\"]")!=null;
        boolean lastName= getText("//*[@id=\"lastName\"]")!=null;
        boolean address= getText("//*[@id=\"address\"]")!=null;
        boolean city= getText("//*[@id=\"city\"]")!=null;
        boolean telephone=getText("//*[@id=\"telephone\"]")!=null;
        return (firstName&lastName&address&city&telephone);

    }
    public void enterInvalidTelephone(){
        fill(TELEPHONE_SELECTOR,"aaa");

    }
    public OwnerInformationPage submit() {
        System.out.println("in the submit method");
        cssClick("body > app-root > app-owner-edit > div > div > form > div:nth-child(7) > div > button:nth-child(2)");
        return new OwnerInformationPage(driver);
        // driver.get(driver.getCurrentUrl());
    }
    public boolean checkButtonDisability(){

        return !isElementEnabled(UPDATE_BUTTON);
    }


}