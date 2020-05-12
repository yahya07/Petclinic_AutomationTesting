package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.samples.petclinic.pages.pet.AddPetPage;
import org.springframework.samples.petclinic.pages.pet.EditPetPage;

import java.util.List;
import java.util.stream.Collectors;

public class OwnerInformationPage extends Page {


    private static final String URL = "http://localhost:8081/petclinic/owners/1";

    public OwnerInformationPage(WebDriver driver) {

        super("Owner Information" , driver );
    }

    public void goToOwnerInformationPage() {
        goTo(URL);
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


}