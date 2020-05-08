package org.springframework.samples.petclinic.pages;

import org.openqa.selenium.WebElement;

import java.util.List;

public class AddPetPage extends Page {

    private static final String URL = "http://localhost:8081/petclinic/owners/1/pets/add";


    public AddPetPage() {
        super("Add Pet");
        goTo(URL);
    }


    public OwnerInformationPage fillInForm(String name, String birthDate, int index){

        fill("name" , name);
        cssFill("body > app-root > app-pet-add > div > div > form > div:nth-child(5) > div > input", birthDate);
        select("type", index);
        cssClick("body > app-root > app-pet-add > div > div > form > div:nth-child(7) > div > button:nth-child(3)");
        return new OwnerInformationPage("Owner Information");
    }

//    public String lastAddedPetName(){
//        implicitlyWait(1);
//        List<WebElement> pets = getElements("/html/body/app-root/app-owner-detail/div/div/table[2]/tr/app-pet-list/table/tr/td[1]/dl/dd[1]");
//        return pets.get(pets.size()-1).getText();
//    }



}
