package org.springframework.samples.petclinic.steps.visit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.samples.petclinic.pages.AllOwnersPage;
import org.springframework.samples.petclinic.pages.HomePage;
import org.springframework.samples.petclinic.pages.OwnerInformationPage;

import static org.junit.Assert.assertFalse;

public class RemoveVisitSteps {


    private HomePage homePage = new HomePage();
    private AllOwnersPage allOwnersPage;
    private OwnerInformationPage ownerInformationPage;

    @And("I click delete-visit button")
    public void iClickDeleteVisitButton() {
        ownerInformationPage = ownerInformationPage.removeVisit();
    }

    @Then("the selected visit will be deleted from the visits list")
    public void theSelectedVisitWillBeDeletedFromTheVisitsList() {
        assertFalse(ownerInformationPage.checkDeleted());

    }

    @Given("I am on the owner page")
    public void iAmOnTheOwnerPage() {
        allOwnersPage = homePage.goToOwnersList();
        ownerInformationPage = allOwnersPage.getSixthOwner();
    }


}
