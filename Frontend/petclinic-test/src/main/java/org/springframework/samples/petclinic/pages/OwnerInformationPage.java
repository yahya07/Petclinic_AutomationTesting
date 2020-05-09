package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class OwnerInformationPage extends Page {


    public OwnerInformationPage() {
        super("Owner Information");
    }

    private static final String URL = "http://localhost:8081/petclinic/owners/1";


    public void goToOwnerInformationPage(){
        goTo(URL);
    }

    public EditPetPage editFirstPet(){

        cssClick("body > app-root > app-owner-detail > div > div > table:nth-child(10) > tr > app-pet-list:nth-child(1) > table > tr > td:nth-child(1) > dl > button:nth-child(7)");
        return new EditPetPage();
    }

    public int removeFirstPet(){

        int before = petNames().size();
        cssClick("body > app-root > app-owner-detail > div > div > table:nth-child(10) > tr > app-pet-list:nth-child(1) > table > tr > td:nth-child(1) > dl > button:nth-child(8)");
        refresh();
        int after = petNames().size();
        return before - after;
    }

    public List<String> petNames(){
        implicitlyWait(1);
        List<WebElement> pets = getElements("/html/body/app-root/app-owner-detail/div/div/table[2]/tr/app-pet-list/table/tr/td[1]/dl/dd[1]");
        return pets.stream()
                .map(pet -> pet.getText())
                .collect(Collectors.toList());
    }



}
