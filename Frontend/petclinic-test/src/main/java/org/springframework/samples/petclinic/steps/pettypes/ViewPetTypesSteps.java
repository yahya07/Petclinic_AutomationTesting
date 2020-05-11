package org.springframework.samples.petclinic.steps.pettypes;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.samples.petclinic.pages.HomePage;

public class ViewPetTypesSteps {
    private HomePage homePage = new HomePage();

    @Given("I am on the homepage")
    public void iAmOnTheHomepage() {
        homePage.navigateHomePage();
    }

    @When("I click on Pet Types tab")
    public void iClickOnPetTypesTab() {
        homePage.clickPetTypeTab();
    }

    @Then("page is redirected and im on Pet types page")
    public void pageIsRedirectedAndImOnPetTypesPage() {
        homePage.isCurrent();
    }
}
