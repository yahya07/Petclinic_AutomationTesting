package org.springframework.samples.petclinic.steps.pet;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.samples.petclinic.pages.owner.AllOwnersPage;
import org.springframework.samples.petclinic.pages.HomePage;
import org.springframework.samples.petclinic.pages.owner.OwnerInformationPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class RemovePetSteps {

    private HomePage homePage = new HomePage();
    private AllOwnersPage allOwnersPage;
    private OwnerInformationPage ownerInformationPage;
    private int lengthDifference;

    @Given("I am on the owner information page")
    public void iAmOnTheOwnerInformationPage() {
        allOwnersPage = homePage.goToOwnersList();
        ownerInformationPage = allOwnersPage.getFirstOwner();
        assertTrue(ownerInformationPage.isCurrent());
    }

    @When("I delete a pet")
    public void iDeleteAPet() {
        lengthDifference = ownerInformationPage.removeFirstPet();
    }

    @Then("The pet disappear from the pets table")
    public void thePetDisappearFromThePetsTable() {
        assertEquals(1, lengthDifference);
        ownerInformationPage.closeBrowser();
    }
}
