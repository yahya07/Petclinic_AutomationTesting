package org.springframework.samples.petclinic.pages;

public class HomePage extends Page {

    private static final String URL = "http://localhost:8081/petclinic/";

    private static final String PATH_OWNERS_DROPDOWN = "body > app-root > div.container-fluid > nav > div > ul > li:nth-child(2) > a";
    private static final String PATH_OWNERS = "body > app-root > div.container-fluid > nav > div > ul > li.dropdown.open > ul > li:nth-child(1) > a";
    private static final String PATH_ADD_OWNER = "body > app-root > div.container-fluid > nav > div > ul > li.dropdown.open > ul > li:nth-child(2) > a";
    private static final String PATH_VETS_DROPDOWN = "body > app-root > div.container-fluid > nav > div > ul > li:nth-child(3) > a";
    private static final String PATH_VETS = "body > app-root > div.container-fluid > nav > div > ul > li.dropdown.open > ul > li:nth-child(1) > a";
    private static final String PATH_ADD_VET = "body > app-root > div.container-fluid > nav > div > ul > li.dropdown.open > ul > li:nth-child(2) > a";
    private static final String PATH_PET_TYPES = "body > app-root > div.container-fluid > nav > div > ul > li:nth-child(4) > a";
    private static final String PATH_SPECIALTIES = "body > app-root > div.container-fluid > nav > div > ul > li:nth-child(5) > a";


    public HomePage() {
        super("Welcome");
    }

    public void goToHome() {
        super.goTo(URL);
    }

    public AddOwnerPage goToAddOwner(){
        cssClick(PATH_OWNERS_DROPDOWN);
        cssClick(PATH_ADD_OWNER);
        return new AddOwnerPage();
    }

    /*
    public AllOwnersPage goToOwnersList(){
        cssClick(PATH_OWNERS_DROPDOWN);
        cssClick(PATH_OWNERS);
        return new AllOwnersPage();
    }

    public AddVetPage goToAddVet(){
        cssClick(PATH_VETS_DROPDOWN);
        cssClick(PATH_ADD_VET);
        return new AddVetPage();
    }

    public AllVetsPage goToVetsList(){
        cssClick(PATH_VETS_DROPDOWN);
        cssClick(PATH_VETS);
        return new AllVetsPage();
    }

    public PetTypesPage goToPetTypes(){
        cssClick(PATH_PET_TYPES);
        return new PetTypesPage();
    }

    public Specialties goToSpecialties(){
        cssClick(PATH_SPECIALTIES);
        return new Specialties();
    }
*/




}
