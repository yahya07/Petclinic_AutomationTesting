package org.springframework.samples.petclinic.steps.pet;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.samples.petclinic.pages.AddPetPage;
import org.springframework.samples.petclinic.pages.OwnerInformationPage;

import static org.junit.Assert.*;


public class AddPetSteps {

    private AddPetPage addPetPage = new AddPetPage();
    private OwnerInformationPage ownerInformationPage;
    private String name = "Test";
    private String birthDate = "2020/04/13";
    private int index = 2;


    @Given("I am on the add-pet form")
    public void iAmOnTheAddPetForm() {
        assertTrue(addPetPage.isCurrent());
    }

    @And("I enter valid pet data")
    public void iEnterValidPetData() {
        ownerInformationPage = addPetPage.fillInForm(name,birthDate, index);
    }

    @Then("The new pet will be displayed at the owner information page")
    public void theNewPetWillBeDisplayedAtTheOwnerInformationPage() {
        assertTrue(ownerInformationPage.lastAddedPetName().contains(name));
    }

    @And("I leave all the fields empty")
    public void iLeaveAllTheFieldsEmpty() {
        ownerInformationPage = addPetPage.fillInForm("","", 1);
    }

    @And("I enter a non-date formatted value into the birth date field")
    public void iEnterANonDateFormattedValueIntoTheBirthDateField() {
        ownerInformationPage = addPetPage.fillInForm(name,"abc", index);
    }

    @And("I enter symbols and numbers rather than words in the name field")
    public void iEnterSymbolsAndNumbersRatherThanWordsInTheNameField() {
        ownerInformationPage = addPetPage.fillInForm("^5$%^",birthDate, index);
    }

    @Then("I remain in the same page")
    public void iRemainInTheSamePage() {
        assertTrue(addPetPage.isCurrent());
    }



}
