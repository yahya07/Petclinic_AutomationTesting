package org.springframework.samples.petclinic.steps.owner;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.samples.petclinic.pages.*;

import java.util.logging.Level;

import static java.util.logging.Logger.getLogger;
import static org.junit.Assert.assertTrue;

public class EditOwnerSteps {
    static {
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }
    private HomePage homePage;
    private AllOwnersPage allOwnersPage;
    private OwnerPage ownerPage;
    private EditOwnerPage editOwnerPage;
    @Before
    public void setup(){
        homePage=new HomePage();
        homePage.clickOwners();
        allOwnersPage=homePage.clickAllOwners();
        ownerPage= allOwnersPage.clickOnAnOwner();
        editOwnerPage= ownerPage.clickEditOwner();
    }
    @Given("I am on the edit owner information form")
    public void iAmOnTheEditOwnerInformationForm(){
        assertTrue(editOwnerPage.isCurrent());
    }

    @And("I clear all fields")
    public void iClearAllFields() {
editOwnerPage.clearField();
    }

    @And("I Enter updated valid data")
    public void iEnterUpdatedValidData() {
        editOwnerPage.enterValidUpdatedData();
    }
    @When("I submit the edit form")
    public void iSubmitTheEditForm() {
        ownerPage= editOwnerPage.submit();
    }
    @Then("The updated owner will be displayed in the Owner page with updated information")
    public void theUpdatedOwnerWillBeDisplayedInTheOwnerPageWithUpdatedInformation() {
        assertTrue(ownerPage.isUpdated("Updated","Updated"));
    }


    @Then("The current owner data are pre-set in the fields")
    public void theCurrentOwnerDataArePreSetInTheFields() {
        assertTrue(editOwnerPage.checkRetrieval());
    }

    @And("I enter non numeric telephone data")
    public void iEnterNonNumericTelephoneData() {
        editOwnerPage.enterInvalidTelephone();
    }

    @Then("The edit submit button is disabled")
    public void theEditSubmitButtonIsDisabled() {
        assertTrue(editOwnerPage.checkButtonDisability());
    }
}
