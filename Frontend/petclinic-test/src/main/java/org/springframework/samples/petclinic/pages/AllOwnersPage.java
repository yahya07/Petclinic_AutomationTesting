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
    private boolean checkTableSize(){
       // int zero=allTableElements(ALL_OWNERS_TABLE).size();
        System.out.println(allTableElements(ALL_OWNERS_TABLE).size());
        return allTableElements(ALL_OWNERS_TABLE).size()!=0;
    }
    public OwnerPage clickOnAnOwner(){
       linkTextClick(allTableElements(ALL_OWNERS_TABLE).get(allTableElements(ALL_OWNERS_TABLE).size()-1).getText());
       System.out.println("size"+checkTableSize());
        //cssClick("body > app-root > app-owner-list > div > div > div > table > tbody > tr:nth-child(1) > td.ownerFullName > a");
       // driver.findElement(By.xpath("/html/body/app-root/app-owner-list/div/div/div/table/tbody/tr[1]/td[1]/a"));
        //if(checkTableSize())
       return new OwnerPage(driver);
//        else{
//            return null;
//        }
    }
//    public OwnerInformationPage getFirstOwner(){
//        implicitlyWait(1);
//        cssClick("body > app-root > app-owner-list > div > div > div > table > tbody > tr:nth-child(1) > td.ownerFullName > a");
//        return new OwnerInformationPage(driver);
//    }


}
