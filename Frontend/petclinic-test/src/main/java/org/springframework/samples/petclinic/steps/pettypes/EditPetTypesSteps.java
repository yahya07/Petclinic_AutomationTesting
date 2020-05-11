package org.springframework.samples.petclinic.steps.pettypes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.samples.petclinic.pages.HomePage;
import org.springframework.samples.petclinic.pages.petTypesPage.EditPetTypePage;
import org.springframework.samples.petclinic.pages.petTypesPage.PetTypesPage;

import static org.junit.Assert.assertTrue;

public class EditPetTypesSteps {
    private HomePage homePage = new HomePage();
    private PetTypesPage petTypesPage;
    private EditPetTypePage editPetTypePage;


    @Given("I am on the Pet Types page")
    public void iAmOnThePetTypesPage() {
        petTypesPage = homePage.goToPetTypes();
        assertTrue(petTypesPage.isCurrent());
    }


    @And("I Click Edit button")
    public void iClickEditButton() {

        editPetTypePage = petTypesPage.EditButton();

    }

    @And("I Edit the Pet Type name")
    public void iEditThePetTypeName() {
        editPetTypePage.NameFiled("NewPetTypeName");
    }

    @When("I Click Update button")
    public void iClickUpdateButton() {
       petTypesPage = editPetTypePage.UpdateButton();
    }

    @Then("The new pet Type name will be displayed at the end of the Pet type's list")
    public void theNewPetTypeNameWillBeDisplayedAtTheEndOfThePetTypeSList() {
        assertTrue(petTypesPage.isCurrent());
        petTypesPage.closeBrowser();
    }

    @When("I Click Cancel button")
    public void iClickCancelButton() {
       petTypesPage =  editPetTypePage.ClickCancel();
    }

    @Then("The you well go back to Pet Types form")
    public void theYouWellGoBackToPetTypesForm() {
        assertTrue(petTypesPage.isCurrent());
        petTypesPage.closeBrowser();
    }

    @And("I remove value from the field")
    public void iRemoveValueFromTheField() {
        editPetTypePage.removeText();

    }

    @Then("The Update button give no action")
    public void theUpdateButtonGiveNoAction() {
        assertTrue(editPetTypePage.isCurrent());
        editPetTypePage.closeBrowser();

    }


}
