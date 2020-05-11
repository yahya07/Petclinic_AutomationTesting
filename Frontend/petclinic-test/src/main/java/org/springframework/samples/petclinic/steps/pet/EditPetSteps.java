package org.springframework.samples.petclinic.steps.pet;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.samples.petclinic.pages.AllOwnersPage;
import org.springframework.samples.petclinic.pages.HomePage;
import org.springframework.samples.petclinic.pages.pet.EditPetPage;
import org.springframework.samples.petclinic.pages.OwnerInformationPage;

import static org.junit.Assert.assertTrue;


public class EditPetSteps {

    private HomePage homePage = new HomePage();
    private AllOwnersPage allOwnersPage;
    private OwnerInformationPage ownerInformationPage;
    private EditPetPage editPetPage;
    private String name = "Updated";
    private final String birthDate = "2019/01/01";
    private final int index = 1;

    @Given("I am on the edit-pet form")
    public void iAmOnTheEditPetForm() {
        allOwnersPage = homePage.goToOwnersList();
        ownerInformationPage = allOwnersPage.getFirstOwner();
        editPetPage = ownerInformationPage.editFirstPet();
        assertTrue(editPetPage.isCurrent());
    }


    @And("I update with valid pet data")
    public void iUpdateWithValidPetData() {
        editPetPage.fillInForm(name, birthDate, index);
        ownerInformationPage = editPetPage.submit();
    }


    @And("I update the birth date field with a non-date formatted value")
    public void iUpdateTheBirthDateFieldWithANonDateFormattedValue() {
        editPetPage.fillInForm(name, "abc", index);
        ownerInformationPage = editPetPage.submit();
    }

    @And("I update the name field with symbols and numbers rather than words")
    public void iUpdateTheNameFieldWithSymbolsAndNumbersRatherThanWords() {
        name = "%45$^";
        editPetPage.fillInForm(name, birthDate, index);
        ownerInformationPage = editPetPage.submit();
    }

    @Then("The pet information will be updated and displayed at the owner information page")
    public void thePetInformationWillBeUpdatedAndDisplayedAtTheOwnerInformationPage() {
        assertTrue(ownerInformationPage.petNames().contains(name));
        ownerInformationPage.closeBrowser();
    }

    @Then("I remain in the edit pet page")
    public void iRemainInTheEditPetPage() {
        assertTrue(editPetPage.isCurrent());
        editPetPage.closeBrowser();
    }
}
