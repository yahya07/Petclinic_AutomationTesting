package org.springframework.samples.petclinic.steps.vet;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.samples.petclinic.pages.HomePage;
import org.springframework.samples.petclinic.pages.vet.AddVetPage;
import org.springframework.samples.petclinic.pages.vet.AllVetsPage;

import static org.junit.Assert.assertTrue;


public class AddVetSteps {
    private HomePage homePage = new HomePage();
    private AddVetPage addVet;
    private AllVetsPage allVets;
    //testing data
    private String fname = "Foo";
    private String lname = "Bar";
    private String fullName = fname + " " + lname;
    private String char1 = "X";
    private String char2 = "Y";
    private String shortComb = char1 + " " + char2;
    private String numsym1 = "8347769245()?";
    private String numsym2 = "&%^$#$%%6357";
    private String numsymComb = numsym1 + " " + numsym2;


    //Scenario: Successfully add a Vet choosing type
    @Given("I am on the New Veterinarian form")
    public void iAmOnTheNewVeterinarianForm() {
        addVet = homePage.goToAddVet();
        assertTrue(addVet.isCurrent());
    }

    @When("I enter valid vet data with choosing type")
    public void iEnterValidVetDataWithChoosingType() {
        addVet.fillData(fname, lname);
        addVet.chooseType();
    }

    @Then("The new vet will be displayed at the end of the vets's list")
    public void theNewVetWillBeDisplayedAtTheEndOfTheVetsSList() {
        allVets = addVet.saveAndRedirect();
        assertTrue(allVets.exists(fullName));
        allVets.closeBrowser();
    }


    //Scenario: Successfully add a Vet without choosing type
    @When("I enter valid vet data without choosing type")
    public void iEnterValidVetDataWithoutChoosingType() {
        addVet.fillData(fname,lname);
    }

    //   Scenario: Unsuccessfully add a Vet
    @When("I click Save Vet Button")
    public void iClickSaveVetButton() {
        addVet.clickSave();

    }
    @Then("page is not redirected")
    public void pageIsNotRedirected() {
        assertTrue(addVet.pageNotRedirected());
        addVet.closeBrowser();
    }


    //  Scenario: Short data
    @When("I enter a single character in both fields")
    public void iEnterASingleCharacterInBothFields() {
        addVet.fillData(char1,char2);
    }
    @Then("I see error message specifying at least two chars long")
    public void iSeeErrorMessageSpecifyingAtLeastTwoCharsLong() {
        assertTrue(addVet.isTwoCharErrorShowing());
        addVet.closeBrowser();

    }

    // Scenario: Submit Short data
    @When("I enter one character in both fields")
    public void iEnterOneCharacterInBothFields() {
        addVet.fillData(char1,char2);
    }

    @Then("The new short vet will be displayed at the end of the vets's list")
    public void theNewShortVetWillBeDisplayedAtTheEndOfTheVetsSList() {
        allVets = addVet.saveAndRedirect();
        assertTrue(allVets.exists(shortComb));
        allVets.closeBrowser();
    }

    //   Scenario: Create Vet with symbols and numbers in fields
    @When("I enter symbols and numbers rather in fields")
    public void iEnterSymbolsAndNumbersRatherInFields() {
        addVet.fillData(numsym1,numsym2);
    }
    @Then("The new numeric vet will be displayed at the end of the vets's list")
    public void theNewNumericVetWillBeDisplayedAtTheEndOfTheVetsSList() {
        allVets = addVet.saveAndRedirect();
        assertTrue(allVets.exists(numsymComb));
        allVets.closeBrowser();
    }
}
