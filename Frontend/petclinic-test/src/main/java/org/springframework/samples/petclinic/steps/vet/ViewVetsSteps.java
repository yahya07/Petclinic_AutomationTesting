//package org.springframework.samples.petclinic.steps.vet;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.springframework.samples.petclinic.pages.vet.AllVetsPage;
//import org.springframework.samples.petclinic.pages.HomePage;
//
//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.assertFalse;
//
//
//public class ViewVetsSteps {
//    private final AllVetsPage allVets = new AllVetsPage();
//    private final HomePage homepage = new HomePage();
//
//    @Given("I am on the homepage")
//    public void iAmOnTheHomepage() {
//        homepage.navigateToHome();
//        assertTrue(homepage.isCurrent());
//    }
//
//    @When("I click on Veterinarians tab")
//    public void iClickOnVeterinariansTab() {
//        homepage.clickVeterinarians();
//    }
//
//    @And("I click on all")
//    public void iClickOnAll() {
//        homepage.clickAllVets();
//    }
//
//    @Then("page is redirected and im on all vets page")
//    public void pageIsRedirectedAndImOnAllVetsPage() {
//        assertTrue(homepage.isRedirected());
//        homepage.closeBrowser();
//        allVets.closeBrowser();
//
//    }
//}
