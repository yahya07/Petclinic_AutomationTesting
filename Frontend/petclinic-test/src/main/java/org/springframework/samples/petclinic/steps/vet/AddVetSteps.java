package org.springframework.samples.petclinic.steps.vet;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.samples.petclinic.pages.AddVetPage;

import static org.junit.Assert.assertTrue;


public class AddVetSteps {
    private final AddVetPage addVet = new AddVetPage();

    @Given("I am on the New Veterinarian form")
    public void iAmOnTheNewVeterinarianForm() {
        addVet.navigateToAddVet();
        assertTrue(addVet.isCurrent());
    }

    @And("I enter valid vet data")
    public void iEnterValidVetData() {
        addVet.fillValid();

    }

    @When("I click Save Vet Button")
    public void iClickSaveVetButton() {
        addVet.clickSave();
    }

    @Then("The new vet will be displayed at the end of the vets's list")
    public void theNewVetWillBeDisplayedAtTheEndOfTheVetsSList() {
        assertTrue(addVet.isAdded());
        addVet.closeBrowser();

    }



}
