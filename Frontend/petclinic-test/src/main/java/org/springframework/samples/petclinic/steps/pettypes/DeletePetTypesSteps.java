package org.springframework.samples.petclinic.steps.pettypes;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.samples.petclinic.pages.HomePage;
import org.springframework.samples.petclinic.pages.petTypesPage.DeletePetTypePage;

import static org.junit.Assert.assertTrue;

public class DeletePetTypesSteps {
    private HomePage homePage = new HomePage();
    private DeletePetTypePage deletePetTypePage = new DeletePetTypePage();

    @When("I Click Delete button")
    public void iClickDeleteButton() {
        deletePetTypePage.deleteButton();
    }

   /* @Then("The specific PetType will be disappear from the end of the Pet Type's list")
    public void theSpecificPetTypeWillBeDisappearFromTheEndOfThePetTypeSList() {
        assertTrue(deletePetTypePage.isDeleted());
    }*/
}
