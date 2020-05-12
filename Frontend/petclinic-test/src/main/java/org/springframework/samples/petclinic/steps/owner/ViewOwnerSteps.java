package org.springframework.samples.petclinic.steps.owner;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.samples.petclinic.pages.owner.AllOwnersPage;
import org.springframework.samples.petclinic.pages.HomePage;
import org.springframework.samples.petclinic.pages.owner.OwnerInformationPage;

import java.util.logging.Level;

import static java.util.logging.Logger.getLogger;
import static org.junit.Assert.assertTrue;

public class ViewOwnerSteps {


    private HomePage homePage = new HomePage();
    private AllOwnersPage allOwnersPage;
    private OwnerInformationPage ownerInformationPage;



    @Given("I am on all owners page where it contains at least an owner")
    public void iAmOnTheAllOwnerPage() {

        allOwnersPage = homePage.goToOwnersList();
        System.out.println("wibble im in allOwnersPage");
        assertTrue(allOwnersPage.isCurrent());
        assertTrue(allOwnersPage.tableSize() > 0);
    }


    @When("I click on OWNER linked name")
    public void iClickOnOWNERLinkedName() {

        ownerInformationPage = allOwnersPage.clickOnAnOwner();

    }

    @Then("I will be directed to the owner information page")
    public void iWillBeDirectedToTheOwnerInformationPage() {

        assertTrue(ownerInformationPage.isCurrent());
        ownerInformationPage.closeBrowser();
    }
}
