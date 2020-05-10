package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllOwnersPage extends Page{
 public static final String URL="http://localhost:8081/petclinic/owners";
    public static final String TITLE="Owners";
    public static final String HEADERXPATH="body > app-root > app-owner-list > div > div > h2";
    public static final String HOME_PAGE_NAVIGATOR_PATH="body > app-root > div.container-fluid > nav > div > ul > li.dropdown.open > ul > li:nth-child(1) > a";
            //"/html/body/app-root/app-owner-list/div/div/h2";
            public static final String ALL_OWNERS_TABLE="/html/body/app-root/app-owner-list/div/div/div/table/tbody/tr/td[1]";

    public AllOwnersPage(WebDriver driver){

      super(driver,TITLE);
    }
    public boolean isAdded(String FIRST_NAME,String LAST_NAME) {
        String fullName=FIRST_NAME+" "+LAST_NAME;
        return fullName.equals(allTableElements(ALL_OWNERS_TABLE).get(allTableElements(ALL_OWNERS_TABLE).size()-1).getText());
    }


}
