package org.springframework.samples.petclinic.steps.pettypes;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.samples.petclinic.pages.HomePage;
import org.springframework.samples.petclinic.pages.petTypesPage.PetTypesPage;

import static org.junit.Assert.assertTrue;

public class ViewPetTypesSteps {
    private HomePage homePage = new HomePage();
    private PetTypesPage petTypesPage;

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        assertTrue(homePage.isCurrent());
    }

    @When("I click on Pet Types tab")
    public void iClickOnPetTypesTab() {

     petTypesPage =  homePage.goToPetTypes();
    }

    @Then("page is redirected and im on Pet types page")
    public void pageIsRedirectedAndImOnPetTypesPage() {
        petTypesPage.isCurrent();
        petTypesPage.closeBrowser();
    }
}
