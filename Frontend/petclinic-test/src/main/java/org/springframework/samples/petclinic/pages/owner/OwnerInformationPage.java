package org.springframework.samples.petclinic.pages.owner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.samples.petclinic.pages.Page;
import org.springframework.samples.petclinic.pages.owner.EditOwnerPage;
import org.springframework.samples.petclinic.pages.pet.AddPetPage;
import org.springframework.samples.petclinic.pages.pet.EditPetPage;

import java.util.List;
import java.util.stream.Collectors;

public class OwnerInformationPage extends Page {


    public OwnerInformationPage(WebDriver driver) {
        super("Owner Information", driver);

    }

    public AddPetPage addNewPet(){
        cssClick("body > app-root > app-owner-detail > div > div > button:nth-child(5)");
        return new AddPetPage(driver);
    }

    public EditPetPage editFirstPet() {

        cssClick("body > app-root > app-owner-detail > div > div > table:nth-child(10) > tr > app-pet-list:nth-child(1) > table > tr > td:nth-child(1) > dl > button:nth-child(7)");
        return new EditPetPage(driver);
    }

    public int removeFirstPet() {

        int before = petNames().size();
        cssClick("body > app-root > app-owner-detail > div > div > table:nth-child(10) > tr > app-pet-list:nth-child(1) > table > tr > td:nth-child(1) > dl > button:nth-child(8)");
        refresh();
        int after = petNames().size();
        return before - after;
    }

    public List<String> petNames() {
        implicitlyWait(1);
        List<WebElement> pets = getElements("/html/body/app-root/app-owner-detail/div/div/table[2]/tr/app-pet-list/table/tr/td[1]/dl/dd[1]");
        return pets.stream()
                .map(pet -> pet.getText())
                .collect(Collectors.toList());
    }
    public EditOwnerPage clickEditOwner() {

        cssClick("body > app-root > app-owner-detail > div > div > button:nth-child(4)");

        return new EditOwnerPage(driver);
    }

    public boolean isUpdated(String FIRST_NAME, String LAST_NAME) {
        String fullName = FIRST_NAME + " " + LAST_NAME;
        System.out.println(fullName + getText("/html/body/app-root/app-owner-detail/div/div/table[1]/tr[1]/td/b"));
        return fullName.equals(getText("/html/body/app-root/app-owner-detail/div/div/table[1]/tr[1]/td/b"));
    }
}
