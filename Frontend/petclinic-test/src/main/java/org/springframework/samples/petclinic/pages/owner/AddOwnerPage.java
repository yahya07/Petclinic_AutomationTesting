package org.springframework.samples.petclinic.pages.owner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.samples.petclinic.pages.Page;


public class AddOwnerPage extends Page {

    private final String FIRST_NAME = "first name tester";

    private final String LAST_NAME = "lastName tester";

    private final String ADDRESS = "address";

    private final String CITY = "city";

    private final String TELEPHONE = "1123";
    private final String FIRST_NAME_SELECTOR = "firstName";
    private final String LAST_NAME_SELECTOR = "lastName";
    private final String ADDRESS_SELECTOR = "address";
    private final String CITY_SELECTOR = "city";
    private final String TELEPHONE_SELECTOR = "telephone";
    private final String ONE_CHAR_VARIABLE = "A";
    private final String SYMBOLS_AND_CHARACTERS = "1223##$";
    private final String CLICK_BUTTON = "body > app-root > app-owner-add > div > div > form > div:nth-child(7) > div > button:nth-child(2)";


    public AddOwnerPage(WebDriver driver) {
        super("New Owner", driver);

    }

    public void enterValidData() {
        fill(FIRST_NAME_SELECTOR, FIRST_NAME);

        fill(LAST_NAME_SELECTOR, LAST_NAME);
        fill(ADDRESS_SELECTOR, ADDRESS);
        fill(CITY_SELECTOR, CITY);
        fill(TELEPHONE_SELECTOR, TELEPHONE);

    }

    public void enterInvalidData() {
        fill(FIRST_NAME_SELECTOR, ONE_CHAR_VARIABLE);

        fill(LAST_NAME_SELECTOR, ONE_CHAR_VARIABLE);
        fill(ADDRESS_SELECTOR, ONE_CHAR_VARIABLE);
        fill(CITY_SELECTOR, ONE_CHAR_VARIABLE);
        fill(TELEPHONE_SELECTOR, ONE_CHAR_VARIABLE);
    }

    public void enterSymbolsAndNumbers() {
        fill(FIRST_NAME_SELECTOR, SYMBOLS_AND_CHARACTERS);

        fill(LAST_NAME_SELECTOR, SYMBOLS_AND_CHARACTERS);
        fill(ADDRESS_SELECTOR, SYMBOLS_AND_CHARACTERS);
        fill(CITY_SELECTOR, SYMBOLS_AND_CHARACTERS);
        fill(TELEPHONE_SELECTOR, TELEPHONE);
    }

    public boolean checkButtonDisability() {

        return !isElementEnabled(CLICK_BUTTON);
    }

    public AllOwnersPage submit() {
        System.out.println("in the submit method");
        cssClick(CLICK_BUTTON);
        return new AllOwnersPage(driver);
    }

    public boolean checkErrorMsg(String errorMsg) {

        return checkPresentOfErrorMsg(errorMsg);
    }


}

