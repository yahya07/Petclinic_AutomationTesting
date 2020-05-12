package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.WebDriver;

public class AllOwnersPage extends Page{

    public static final String TITLE="Owners";
    private final String HEADERXPATH="body > app-root > app-owner-list > div > div > h2";
    private final String HOME_PAGE_NAVIGATOR_PATH="body > app-root > div.container-fluid > nav > div > ul > li.dropdown.open > ul > li:nth-child(1) > a";
    private final String ALL_OWNERS_TABLE="/html/body/app-root/app-owner-list/div/div/div/table/tbody/tr/td[1]";

    public AllOwnersPage(WebDriver driver){

      super(TITLE, driver);
    }

    public boolean isAdded(String FIRST_NAME,String LAST_NAME) {
        String fullName=FIRST_NAME+" "+LAST_NAME;
        return fullName.equals(getElements(ALL_OWNERS_TABLE).get(getElements(ALL_OWNERS_TABLE).size()-1).getText());
    }

public int tableSize(){
        return sizeOfTable(ALL_OWNERS_TABLE);
}

    public OwnerPage clickOnAnOwner() {
        linkTextClick(getElements(ALL_OWNERS_TABLE).get(getElements(ALL_OWNERS_TABLE).size() - 1).getText());
        return new OwnerPage(driver);

    }

}
