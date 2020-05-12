package org.springframework.samples.petclinic.steps.owner;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

public class AddOwnerSteps {
    static {
        System.setProperty("webdriver.chrome.driver", "/chromedriver.exe");
        System.setProperty("webdriver.chrome.silentOutput", "true");
        getLogger("org.openqa.selenium").setLevel(Level.SEVERE);
    }
    public String shortInputErrorMsg="First name must be at least 2 characters long";
    public String numericInputErrorMsg="Phone number only accept digits";

    public static final String FIRST_NAME= "first name tester";
    //+ new Random();
    public static final String LAST_NAME = "lastName tester";
    private  AddOwnerPage addOwnerPage;
    //= new AddOwnerPage();
    private HomePage homePage=new HomePage();
    private AllOwnersPage allOwnersPage;
@Before
public void setup(){
    homePage.clickOwners();
    addOwnerPage=homePage.ClickAddOwner();
}
    @Given("I am on the add-owner form")
    public void iAmOnTheAddOwnerForm() {

        System.out.println("wibble iAmOnTheAddOwnerForm");
        assertTrue(addOwnerPage.isCurrent());
    }

    @When("I enter valid owner data")
    public void iEnterValidData() {

        System.out.println("wibble iEnterValidData");
        addOwnerPage.enterValidData();


    }

    @Then("The submit button is enabled")
    public void eachFieldWillHaveATickOnTheRight() {
      //  assertTrue(addOwnerPage.checkTick());
        assertFalse(addOwnerPage.checkButtonDisability());

        System.out.println("wibble eachFieldWillHaveATickOnTheRight");

    }

    @When("I submit the form")
    public void iSubmitTheForm() {
       allOwnersPage= addOwnerPage.submit();

        // assertTrue(allOwnersPage.isCurrentByHeader());
    }
    @Then("The new owner will be displayed at the end of the owner's list")
    public void theNewOwnerWillBeDisplayedAtTheEndOfTheOwnerSList() {
        //FIRST_NAME,LAST_NAME
        assertTrue(allOwnersPage.isAdded(FIRST_NAME,LAST_NAME));
       // addOwnerPage.closeBrowser();
    }

    @When("I enter invalid data")
    public void iEnterInvalidData() {
    addOwnerPage.enterInvalidData();
    }

    @Then("The submit button is disabled")
    public void theSubmitButtonIsDisabled() {
    assertTrue(addOwnerPage.checkButtonDisability());
    }

    @Then("I see a specific message for each field specifying that the field must be at least chars long")
    public void iSeeASpecificMessageForEachFieldSpecifyingThatTheFieldMustBeAtLeastCharsLong() {
    assertTrue(addOwnerPage.checkErrorMsg(shortInputErrorMsg));
    }

    @And("I enter a non-numeric value into the phone field")
    public void iEnterANonNumericValueIntoThePhoneField() {
        addOwnerPage.enterInvalidData();

    }

    @And("I see an error message specifying that the phone number only accepts digits")
    public void iSeeAnErrorMessageSpecifyingThatThePhoneNumberOnlyAcceptsDigits() {
        assertTrue(addOwnerPage.checkErrorMsg(numericInputErrorMsg));
    }

    @And("I enter duplicate owner's details")
    public void iEnterDuplicateOwnerSDetails() {
    addOwnerPage.enterValidData();
    }

    @And("I enter symbols and numbers rather than words")
    public void iEnterSymbolsAndNumbersRatherThanWords() {
    addOwnerPage.enterSymbolsAndNumbers();
    }


    @Then("The new owner {string} will be displayed at the end of the owner's list")
    public void theNewOwnerWillBeDisplayedAtTheEndOfTheOwnerSList(String arg0) {
        assertTrue(allOwnersPage.isAdded(arg0,arg0));
}



//    @And("The field has an x at the end")
//    public void theFieldHasAnXAtTheEnd() {
//        //assertTrue(addOwnerPage.checkErrorMsg("numericInputErrorMsg"));
//
//        assertFalse(addOwnerPage.checkTick());
//
//    }


//    @Given("I am on all owner page")
//    public void iAmOnAllOwnerPage() {
//    }


//
//    @When("I try to enter a single character into the name fields")
//    public void iTryToEnterASingleCharacterIntoTheNameFields() {
//    }
//
//    @Then("I see a specific message for each field specifying that the field must be at least 2 chars long")
//    public void validateMinLengthErrorMessage() {
//    }
//
//    @And("Each field has an x at the end")
//    public void validateIncorrectInputErrorSymbol() {
//    }
//
//    @And("The field has an x at the end")
//    public void validateIncorrectInputErrorSymbols() {
//    }
//
//    @And("I enter then remove values from each field")
//    public void iEnterThenRemoveValuesFromEachField() {
//    }
//
//    @And("I see a specific message for each field specifying that it is required")
//    public void iSeeASpecificMessageForEachFieldSpecifyingThatItIsRequired() {
//    }
//
//    @And("I enter a non-numeric value into the phone field")
//    public void iEnterANonNumericValueIntoThePhoneField() {
//    }
//
//    @And("I see an error message specifying that the phone number only accepts digits")
//    public void iSeeAnErrorMessageSpecifyingThatThePhoneNumberOnlyAcceptsDigits() {
//    }
//
//    @And("I enter symbols and numbers rather than words")
//    public void iEnterSymbolsAndNumbersRatherThanWords() {
//    }
//
//    @And("I enter duplicate owner's details")
//    public void iEnterDuplicateOwnerSDetails() {
//    }
}
