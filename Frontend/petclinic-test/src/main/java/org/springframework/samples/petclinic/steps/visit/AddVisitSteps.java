package org.springframework.samples.petclinic.steps.visit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.samples.petclinic.pages.visit.AddVisitPage;
import org.springframework.samples.petclinic.pages.AllOwnersPage;
import org.springframework.samples.petclinic.pages.HomePage;
import org.springframework.samples.petclinic.pages.OwnerInformationPage;

import static org.junit.Assert.*;

public class AddVisitSteps {

    private HomePage homePage = new HomePage();
    private AllOwnersPage allOwnersPage;
    private OwnerInformationPage ownerInformationPage;
    private AddVisitPage addVisitPage;

    @Given("I am on the add-visit form")
    public void iAmOnTheAddVisitForm() {
        allOwnersPage = homePage.goToOwnersList();
        ownerInformationPage = allOwnersPage.getSixthOwner();
        addVisitPage = ownerInformationPage.addNewVisit();
        addVisitPage.isCurrent();
    }

    @When("I enter valid visit data")
    public void iEnterValidVisitData() {
        addVisitPage.fillValidVisitForm();
    }

    @And("I submit the visit form")
    public void iSubmitTheVisitForm() {
        ownerInformationPage = addVisitPage.submitVisitForm();
    }

    @Then("A new visit should be added to the owner page")
    public void aNewVisitShouldBeAddedToTheOwnerPage() {
        assertTrue(addVisitPage.visitAddedSuccessfully());
        ownerInformationPage.closeBrowser();
    }

    @And("I enter invalid data")
    public void iEnterInvalidData() {
        addVisitPage.fillInValidVisitForm();
    }

    @Then("I will remain on the same page")
    public void iWillRemainOnTheSamePage() {
        assertTrue(addVisitPage.isOnSamePage());
        addVisitPage.closeBrowser();
    }


    @And("I submit the visit form without filling any field")
    public void iSubmitTheVisitFormWithoutFillingAnyField() {
        ownerInformationPage = addVisitPage.submitVisitForm();
    }
}
