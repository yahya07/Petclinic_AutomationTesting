package org.springframework.samples.petclinic.steps.owner;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.samples.petclinic.pages.AddOwnerPage;
import org.springframework.samples.petclinic.pages.AllOwnersPage;
import org.springframework.samples.petclinic.pages.HomePage;
//import pages.AddOwnerPage;
//import pages.HomePage;
//import pages.MyAccountPage;
//import pages.RegistrationPage;

import java.util.logging.Level;

import static java.util.logging.Logger.getLogger;
import static org.junit.Assert.*;

public class ViewOwnersSteps {
    static {
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }
    private HomePage homePage = new HomePage();
private AllOwnersPage allOwnersPage= new AllOwnersPage();
    @Given("I am on the home page")
    public void iAmOnTheHomePage() {

        System.out.println("wibble iAmOnTheHomePage");
        assertTrue(homePage.isCurrent());
    }
    @When("I click on Owners tab")
    public void iClickOnOwnersTab() {
        homePage.clickOwners();
        //.navigateFromHomePage();

        // assertTrue(allOwnersPage.isCurrentByHeader());
    }
    @And("I click on all")
    public void iClickOnAll() {
        homePage.clickAllOwners();
    }
    @Then("I will be directed to AllOwners page")
    public void iWillBeDirectedToAllOwnersPage() {
     assertTrue(allOwnersPage.isCurrent());
    }





}
