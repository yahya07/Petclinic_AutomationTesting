package org.springframework.samples.petclinic.pages.petTypesPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.samples.petclinic.pages.Page;

import java.util.List;

public class PetTypesPage extends Page {
    private static final String URL = "http://localhost:8081/petclinic/pettypes";
    private static final String AddButtnPath = "body > app-root > app-pettype-list > div > div > div > button:nth-child(2)";
    private static final String DeleteButton = "#pettypes > tbody > tr:nth-child(1) > td:nth-child(2) > button:nth-child(2)";
    private static final String EditButton = "#pettypes > tbody > tr:nth-child(1) > td:nth-child(2) > button:nth-child(1)";
    private int before;
    private int after;
    public PetTypesPage(WebDriver driver) {
        super("Pet Types",driver);
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
    public EditPetTypePage EditButton()
    {
        cssClick(EditButton);
        return new EditPetTypePage(driver);

    }

    public void deleteButton()
    {
        before = getPetTypesLength();
        cssClick(DeleteButton);

    }

    public void removeText() {
        clearField("#name");
    }


    public boolean isDeleted()
    {
        refresh();
        after =getPetTypesLength();
        return (after < before );
    }

    /*public  boolean isEdited()
    {
      //  List<WebElement> petTypes = getElements("/html/body/app-root/app-pettype-list/div/div/table/tbody/tr/td[1]/input");
    }*/
}
