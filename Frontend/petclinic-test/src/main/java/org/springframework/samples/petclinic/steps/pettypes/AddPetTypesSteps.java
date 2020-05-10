package org.springframework.samples.petclinic.steps.pettypes;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.samples.petclinic.pages.petTypesPage.petTypePage;
import static org.junit.Assert.assertTrue;

public class AddPetTypesSteps {

        private petTypePage petTypePage = new petTypePage();


        @Given("I am on the Pet Type form")
        public void iAmOnThePetTypeForm() {
            petTypePage.gotoPetTypesPage();
            assertTrue(petTypePage.isCurrent());

        }

        @When("I Clinic add button")
        public void iClinicAddButton() {
            petTypePage.clickAddButton();
        }

        @And("I Enter Valid Pet Type name")
        public void iEnterValidPetTypeName() {
            petTypePage.fillAddFiled("Dog");
            petTypePage.clickSaveButton();
        }

        @Then("The new Pet Type will be displayed at the end of the Pet Type's list")
        public void theNewPetTypeWillBeDisplayedAtTheEndOfThePetTypeSList() {
            assertTrue(petTypePage.chickAdd());

        }


        @And("I enter symbols and numbers rather than words data")
        public void iEnterSymbolsAndNumbersRatherThanWordsData() {
            petTypePage.fillAddFiled("@#$568");
            petTypePage.clickSaveButton();

        }

        @And("I enter then remove value from the field")
        public void iEnterThenRemoveValueFromTheField() {
            petTypePage.fillAddFiled("Cat");
            petTypePage.removeText();
            petTypePage.clickSaveButton();

        }

        @Then("The add button is give no action")
        public void theAddButtonIsGiveNoAction() {

        }
}
