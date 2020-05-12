package org.springframework.samples.petclinic.steps.vet;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.samples.petclinic.pages.vet.AllVetsPage;
import org.springframework.samples.petclinic.pages.HomePage;

import static org.junit.Assert.assertTrue;


public class ViewVetsSteps {
    private HomePage homePage = new HomePage();
    private AllVetsPage allVets;


    @Given("I am starting from the homepage")
    public void iAmStartingFromTheHomepage() {
        assertTrue(homePage.isCurrent());
    }

    @When("I click on All Veterinarians tab")
    public void iClickOnAllVeterinariansTab() {
        allVets = homePage.goToVetsList();
    }


    @Then("page is redirected and im on all vets page")
    public void pageIsRedirectedAndImOnAllVetsPage() {
        assertTrue(allVets.isCurrent());
        allVets.closeBrowser();
    }


}