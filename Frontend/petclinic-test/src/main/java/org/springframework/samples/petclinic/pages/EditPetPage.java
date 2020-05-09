package org.springframework.samples.petclinic.pages;

public class EditPetPage extends Page {


    protected EditPetPage() {
        super("Pet");
    }

    public void fillInForm(String name, String birthDate, int index){

        fill("name" , name);
        clearField("body > app-root > app-pet-edit > div > div > form > div:nth-child(5) > input");
        cssFill("body > app-root > app-pet-edit > div > div > form > div:nth-child(5) > input", birthDate);
        select("type", index);
    }

    public OwnerInformationPage submit(){
        cssClick("body > app-root > app-pet-edit > div > div > form > div:nth-child(7) > div > button:nth-child(3)");
        return new OwnerInformationPage();
    }


}
