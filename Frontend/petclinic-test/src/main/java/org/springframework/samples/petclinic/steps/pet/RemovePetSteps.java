package org.springframework.samples.petclinic.steps.pet;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.samples.petclinic.pages.OwnerInformationPage;

import static org.junit.Assert.*;


public class RemovePetSteps {

    private OwnerInformationPage ownerInformationPage = new OwnerInformationPage();
    private int lengthDifference;

    @Given("I am on the owner information page")
    public void iAmOnTheOwnerInformationPage() {
        ownerInformationPage.goToOwnerInformationPage();
        assertTrue(ownerInformationPage.isCurrent());
    }

    @When("I delete a pet")
    public void iDeleteAPet() {
        lengthDifference = ownerInformationPage.removeFirstPet();
    }

    @Then("The pet disappear from the pets table")
    public void thePetDisappearFromThePetsTable() {
        assertEquals(1, lengthDifference);
    }
}
