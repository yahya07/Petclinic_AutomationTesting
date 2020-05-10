//package org.springframework.samples.petclinic.steps.vet;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.springframework.samples.petclinic.pages.vet.AddVetPage;
//import static org.junit.Assert.assertTrue;
//
//
//public class AddVetSteps {
//    private final AddVetPage addVet = new AddVetPage(new ChromeDriver());
//
//    //Scenario: Successfully add a Vet choosing type
//    @Given("I am on the New Veterinarian form")
//    public void iAmOnTheNewVeterinarianForm() {
//        addVet.navigateToAddVet();
//        assertTrue(addVet.isCurrent());
//    }
//    @And("I enter valid vet data with choosing type")
//    public void iEnterValidVetDataWithChoosingType() {
//        addVet.fillValid();
//        addVet.chooseType();
//    }
//    @When("I click Save Vet Button")
//    public void iClickSaveVetButton() {
//        addVet.clickSave();
//    }
//    @Then("The new vet will be displayed at the end of the vets's list")
//    public void theNewVetWillBeDisplayedAtTheEndOfTheVetsSList() {
//        assertTrue(addVet.isAdded());
//        addVet.closeBrowser();
//
//    }
//
//    //Scenario: Successfully add a Vet without choosing type
//    @And("I enter valid vet data without choosing type")
//    public void iEnterValidVetDataWithoutChoosingType() {
//        addVet.fillValid();
//    }
//    @Then("page is not redirected")
//    public void pageIsNotRedirected() {
//        assertTrue(addVet.pageNotRedirected());
//        addVet.closeBrowser();
//    }
//
//
//    //  Scenario: Short data
//    @When("I enter a single character in both fields")
//    public void iEnterASingleCharacterInBothFields() {
//        addVet.fillOneChar();
//    }
//    @Then("I see error message specifying at least two chars long")
//    public void iSeeErrorMessageSpecifyingAtLeastTwoCharsLong() {
//        assertTrue(addVet.isTwoCharErrorShowing());
//        addVet.closeBrowser();
//
//    }
//
//    // Scenario: Submit Short data
//    @And("I enter one character in both fields")
//    public void iEnterOneCharacterInBothFields() {
//        addVet.fillOneChar();
//    }
//    @Then("The new short vet will be displayed at the end of the vets's list")
//    public void theNewShortVetWillBeDisplayedAtTheEndOfTheVetsSList() {
//        assertTrue(addVet.isShortAdded());
//        addVet.closeBrowser();
//    }
//
//    //   Scenario: Create Vet with symbols and numbers in fields
//    @And("I enter symbols and numbers rather in fields")
//    public void iEnterSymbolsAndNumbersRatherInFields() {
//        addVet.fillNumericAndSymbols();
//    }
//    @Then("The new numeric vet will be displayed at the end of the vets's list")
//    public void theNewNumericVetWillBeDisplayedAtTheEndOfTheVetsSList() {
//        assertTrue(addVet.isNumericSymbolsAdded());
//        addVet.closeBrowser();
//    }
//}
