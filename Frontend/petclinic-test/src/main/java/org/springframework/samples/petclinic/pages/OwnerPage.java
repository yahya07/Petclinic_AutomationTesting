package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OwnerPage extends Page{

    public OwnerPage(WebDriver driver) {
        super(driver,"Owner Information");
       // goTo(URL);
    }
    public EditOwnerPage clickEditOwner(){
//        cssClick("body > app-root > app-owner-detail > div > div > table:nth-child(10) > tr > app-pet-list:nth-child(1) > table > tr > td:nth-child(1) > dl > button:nth-child(7)");

        cssClick("body > app-root > app-owner-detail > div > div > button:nth-child(4)");
      //  driver.findElement(By.partialLinkText("Edit Owner")).click();0.0.0
      //driver.findElement(By.xpath("/html/body/app-root/app-owner-detail/div/div/button[2]")).click();
       // driver.findElement(By.linkText("Edit Owner")).click();
//        try {
//            wait(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        /html/body/app-root/app-owner-detail/div/div/button[2]
//        body > app-root > app-owner-detail > div > div > button:nth-child(4)
//        driver.findElement(By.partialLinkText("Edit Owner")).click();
   return new EditOwnerPage(driver);
    }
    public EditOwnerPage editFirstPet() {

        cssClick("body > app-root > app-owner-detail > div > div > button:nth-child(4)");
        return new EditOwnerPage(driver);
    }
    public boolean isUpdated(String FIRST_NAME,String LAST_NAME) {
        String fullName=FIRST_NAME+" "+LAST_NAME;
        System.out.println(fullName+getText("/html/body/app-root/app-owner-detail/div/div/table[1]/tr[1]/td/b"));
        return fullName.equals(getText("/html/body/app-root/app-owner-detail/div/div/table[1]/tr[1]/td/b"));
    }
}
