package org.springframework.samples.petclinic.steps.visit;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.samples.petclinic.pages.AddVisitPage;
import org.springframework.samples.petclinic.pages.OwnerInformationPage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AddVisitSteps {

    AddVisitPage addVisitPage = new AddVisitPage();
    OwnerInformationPage ownerInformationPage = new OwnerInformationPage();

    @Given("I am on the add-visit form")
    public void iAmOnTheAddVisitForm() {
        addVisitPage.goToAddVisitForm();
        addVisitPage.isCurrent();
    }

    @When("I enter valid visit data")
    public void iEnterValidVisitData() {
        addVisitPage.fillValidVisitForm();
    }

    @And("I submit the visit form")
    public void iSubmitTheVisitForm() {
        addVisitPage.submitVisitForm();
    }

    @Then("A new visit should be added to the owner page")
    public void aNewVisitShouldBeAddedToTheOwnerPage() {
        assertTrue(addVisitPage.visitAddedSuccessfully());
    }

    @And("I enter invalid visit data")
    public void iEnterInvalidData() {
        addVisitPage.fillInValidVisitForm();
    }

    @Given("I am on the owner page")
    public void iAmOnTheOwnerPage() {
        ownerInformationPage.goTOwnerPage();
    }

    @Then("The add visit button is disabled")
    public void theAddVisitButtonIsDisabled() {
        assertFalse(ownerInformationPage.checkVisitButton());
    }

    @Then("I will remain on the same page")
    public void iWillRemainOnTheSamePage() {
        assertTrue(addVisitPage.isOnSamePage());
    }


    @And("I submit the visit form without filling any field")
    public void iSubmitTheVisitFormWithoutFillingAnyField() {
        addVisitPage.submitVisitForm();
    }
}
