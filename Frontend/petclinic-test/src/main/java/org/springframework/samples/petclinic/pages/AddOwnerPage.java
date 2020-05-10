package org.springframework.samples.petclinic.pages;
import com.google.common.hash.HashCode;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.Random;

public class AddOwnerPage extends Page {
    //  body > app-root > app-owner-add > div > div > h2
    ///html/body/app-root/app-vet-list/div/div/table/tbody/tr/td[1]
    public static final String FIRST_NAME= "first name tester";
    //+ new Random();
    public static final String LAST_NAME = "lastName tester";
    //+ new Random();
    public static final String ADDRESS="address";
    //+new Random();
    public static final String CITY="city";
    //+new Random();
    public static final String TELEPHONE="1123";
    public static final String FIRST_NAME_SELECTOR="firstName";
    public static final String LAST_NAME_SELECTOR="lastName";
    public static final String ADDRESS_SELECTOR="address";
    public static final String CITY_SELECTOR="city";
    public static final String TELEPHONE_SELECTOR="telephone";
    public static final String CLICK_BUTTON="body > app-root > app-owner-add > div > div > form > div:nth-child(7) > div > button:nth-child(2)";

    public static final String TICK_CLASSNAME="glyphicon form-control-feedback glyphicon-ok";
    public static final String URL="http://localhost:8081/petclinic/owners/add";
    public static final String ALL_OWNERS_TABLE="/html/body/app-root/app-owner-list/div/div/div/table/tbody/tr/td[1]";

    public AddOwnerPage() {
        super("New Owner");
        goTo(URL);
    }

    public void enterValidData(){
        fill(FIRST_NAME_SELECTOR,FIRST_NAME);

        fill(LAST_NAME_SELECTOR,LAST_NAME);
        fill(ADDRESS_SELECTOR,ADDRESS);
        fill(CITY_SELECTOR,CITY);
        fill(TELEPHONE_SELECTOR,TELEPHONE);

    }
    public boolean checkTick(){
        boolean firstNameTick= checkTick(FIRST_NAME_SELECTOR,TICK_CLASSNAME);
        boolean lastNameTick=  checkTick(LAST_NAME_SELECTOR,TICK_CLASSNAME);
        boolean addressTick=  checkTick(ADDRESS_SELECTOR,TICK_CLASSNAME);
        boolean cityTick= checkTick(CITY_SELECTOR,TICK_CLASSNAME);
        boolean telephoneTick= checkTick(TELEPHONE_SELECTOR,TICK_CLASSNAME);
        return (firstNameTick&lastNameTick&addressTick&cityTick&telephoneTick);
    }
    //todo: it's not stay on the list page
    public void submit() {
        System.out.println("in the submit method");
        cssClick(CLICK_BUTTON);
        // driver.get(driver.getCurrentUrl());
    }
    public boolean isAdded() {
        String fullName=FIRST_NAME+" "+LAST_NAME;
        return fullName.equals(allTableElements(ALL_OWNERS_TABLE).get(allTableElements(ALL_OWNERS_TABLE).size()-1).getText());
    }
    public boolean pageNotRedirected(){

        return isNotRedirected(URL);
    }


}
