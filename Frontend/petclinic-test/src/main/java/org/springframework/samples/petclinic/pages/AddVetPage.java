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
    private static final String ERROR_CLASS = "help-block";
    private static final String TWO_CHARS_ERROR = "First name must be at least 2 characters long";
    private static final String CHAR_1 = "X";
    private static final String CHAR_2 = "Y";
    private static final String SHORTCOMB = CHAR_1 + " "+ CHAR_2;
    private static final String NUM_SYM_1 = "8347769245()?";
    private static final String NUM_SYM_2 = "&%^$#$%%6357";
    private static final String NUMSYMCOMB = NUM_SYM_1 + " "+ NUM_SYM_2;


    public AddVetPage() {
        super(TITLE, HEADER_XPATH);
    }

    public void navigateToAddVet() {
        goTo(URL);
    }

    public void fillValid() {
        fill("firstName", FIRST_NAME);
        fill("lastName", LAST_NAME);
    }
    public void fillNumericAndSymbols() {
        fill("firstName", NUM_SYM_1);
        fill("lastName", NUM_SYM_2);
    }

    public void fillOneChar() {
        fill("firstName",CHAR_1);
        fill("lastName", CHAR_2);
    }
    public void chooseType()
    {
        selectFirst("specialties");
    }

    public void clickSave() {
        cssClick(SAVE_BUTTON);
    }

    public boolean isAdded() {
       return FULL_NAME.equals(allTableElements(ALL_VETS_TABLET).get(allTableElements(ALL_VETS_TABLET).size()-1).getText());
}
    public boolean isShortAdded() {
        return SHORTCOMB.equals(allTableElements(ALL_VETS_TABLET).get(allTableElements(ALL_VETS_TABLET).size()-1).getText());
    }

    public boolean isNumericSymbolsAdded() {
        return NUMSYMCOMB.equals(allTableElements(ALL_VETS_TABLET).get(allTableElements(ALL_VETS_TABLET).size()-1).getText());
    }
    public boolean isTwoCharErrorShowing()
    {
        return isErrorShowing(ERROR_CLASS,TWO_CHARS_ERROR);
    }
public boolean pageNotRedirected(){

        return isNotRedirected(URL);
}

}
