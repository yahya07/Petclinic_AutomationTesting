package org.springframework.samples.petclinic.steps.pettypes;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.samples.petclinic.pages.HomePage;
import org.springframework.samples.petclinic.pages.petTypesPage.PetTypesPage;

import static org.junit.Assert.assertTrue;

public class DeletePetTypesSteps {
    private HomePage homePage = new HomePage();
    private PetTypesPage petTypesPage;

    @Given("I am on the Pet Type page")
    public void iAmOnThePetTypePage() {
        petTypesPage = homePage.goToPetTypes();
        assertTrue(petTypesPage.isCurrent());
    }

    @When("I Click Delete button")
    public void iClickDeleteButton() {
        petTypesPage.deleteButton();
    }

    @Then("The specific PetType will be disappear from the end of the Pet Type's list")
    public void theSpecificPetTypeWillBeDisappearFromTheEndOfThePetTypeSList() {
        assertTrue(petTypesPage.isDeleted());
        petTypesPage.closeBrowser();
    }


}
