package org.springframework.samples.petclinic.pages.petTypesPage;

import org.springframework.samples.petclinic.pages.Page;

public class DeletePetTypePage extends Page {
    private static final String URL = "http://localhost:8081/petclinic/pettypes";
    private static final String DeleteButton = "#pettypes > tbody > tr:nth-child(1) > td:nth-child(2) > button:nth-child(2)";
    private static final String PetTypesTable = "/html/body/app-root/app-vet-list/div/div/table/tbody/tr/td[1]";
    private int CheckRowsCount = 0;
    private int CheckRemainRows = 0;
    public DeletePetTypePage() {
        super("Veterinarians");
    }

    public void navigatePetTypes() {
        goTo(URL);
        CheckRowsCount = allTableElements(PetTypesTable).size();
    }


    public void deleteButton()
    {
        cssClick(DeleteButton);
        CheckRemainRows = allTableElements(PetTypesTable).size();
    }

    public boolean isDeleted()
    {
        return (CheckRemainRows < CheckRowsCount );
    }
}
