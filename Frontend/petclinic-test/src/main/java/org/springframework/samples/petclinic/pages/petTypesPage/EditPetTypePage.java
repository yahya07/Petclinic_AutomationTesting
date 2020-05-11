package org.springframework.samples.petclinic.pages.petTypesPage;

import org.springframework.samples.petclinic.pages.Page;

public class EditPetTypePage extends Page {

    private static final String URL = "http://localhost:8081/petclinic/pettypes";
    private static final String EditButton = "http://localhost:8081/petclinic/pettypes/133/edit";
    private static final String UpdateButton = "#pettype > div.form-group.has-feedback > div > button:nth-child(3)";



    protected EditPetTypePage(String title) { super(title); }


    public void gotoPetTypesPage() {
        goTo(URL);

    }

    public void EditButton()
    {
        cssClick(EditButton);

    }
    public void UpdateButton() {
        goTo(URL);

    }
}
