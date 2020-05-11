package org.springframework.samples.petclinic.steps.pet;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.samples.petclinic.pages.AllOwnersPage;
import org.springframework.samples.petclinic.pages.HomePage;
import org.springframework.samples.petclinic.pages.OwnerInformationPage;
import org.springframework.samples.petclinic.pages.pet.AddPetPage;

import static org.junit.Assert.assertTrue;


public class AddPetSteps {

    private HomePage homePage = new HomePage();
    private AllOwnersPage allOwnersPage;
    private OwnerInformationPage ownerInformationPage;
    private AddPetPage addPetPage;
    private String name = "Test";
    private String birthDate = "2020/04/13";
    private int index = 2;
     
    @Given("I am on the add-pet form")
    public void iAmOnTheAddPetForm() {
        allOwnersPage = homePage.goToOwnersList();
        ownerInformationPage = allOwnersPage.getFirstOwner();
        addPetPage = ownerInformationPage.addNewPet();
        assertTrue(addPetPage.isCurrent());
    }

    @And("I enter valid pet data")
    public void iEnterValidPetData() {
        addPetPage.fillInForm(name, birthDate, index);
        ownerInformationPage = addPetPage.submit();
    }

    @Then("The new pet will be displayed at the owner information page")
    public void theNewPetWillBeDisplayedAtTheOwnerInformationPage() {
        assertTrue(ownerInformationPage.petNames().contains(name));
        ownerInformationPage.closeBrowser();
    }

    @And("I leave all the fields empty")
    public void iLeaveAllTheFieldsEmpty() {
        ownerInformationPage = addPetPage.submit();
    }

    @And("I enter a non-date formatted value into the birth date field")
    public void iEnterANonDateFormattedValueIntoTheBirthDateField() {
        addPetPage.fillInForm(name, "abc", index);
        ownerInformationPage = addPetPage.submit();
    }

    @And("I enter symbols and numbers rather than words in the name field")
    public void iEnterSymbolsAndNumbersRatherThanWordsInTheNameField() {
        name = "^5$%^";
        addPetPage.fillInForm(name, birthDate, index);
        ownerInformationPage = addPetPage.submit();
    }

    @Then("I remain in the add pet page")
    public void iRemainInTheAddPetPage() {
        assertTrue(addPetPage.isCurrent());
        addPetPage.closeBrowser();
    }

}
