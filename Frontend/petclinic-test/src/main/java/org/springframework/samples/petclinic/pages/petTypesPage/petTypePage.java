package org.springframework.samples.petclinic.pages.petTypesPage;

import org.openqa.selenium.WebElement;
import org.springframework.samples.petclinic.pages.Page;

import java.util.List;

public class petTypePage extends Page {
    private static final String URL = "http://localhost:8081/petclinic/pettypes";
    private static final String AddButtnPath = "body > app-root > app-pettype-list > div > div > div > button:nth-child(2)";
    private int before;
    private int after;
    public petTypePage() {
        super("Pet Types");
    }

    public void gotoPetTypesPage() {
        goTo(URL);

    }

    public void clickAddButton() {
        cssClick(AddButtnPath);
    }

    public void fillAddFiled(String PetType) {
        fill("name", PetType);

    }

    public void clickSaveButton() {
        before = getPetTypesLength();
        cssClick("#pettype > div.form-group.has-feedback > div > button");

    }

    public int getPetTypesLength() {
        implicitlyWait(3);
        List<WebElement> petTypes = getElements("/html/body/app-root/app-pettype-list/div/div/table/tbody/tr/td[1]/input");
        return petTypes.size();

    }

    public boolean chickAdd() {
        refresh();
        after = getPetTypesLength();
        return (after - before) == 1;
    }

    public void removeText() {
        clearField("#name");
    }

}
