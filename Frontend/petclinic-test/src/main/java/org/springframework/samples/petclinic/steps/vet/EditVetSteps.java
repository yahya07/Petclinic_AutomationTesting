package org.springframework.samples.petclinic.steps.vet;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.samples.petclinic.pages.HomePage;
import org.springframework.samples.petclinic.pages.vet.AllVetsPage;
import org.springframework.samples.petclinic.pages.vet.EditVetPage;
import static org.junit.Assert.assertTrue;

public class EditVetSteps {

    private HomePage homePage = new HomePage();
    private AllVetsPage allVets;
    private EditVetPage editVet;
    private String fname = "Edited Foo";
    private String lname = "Edited Bar";
    private String validEdited = fname+" "+lname;

    @Given("I am navigated to the All Veterinarian page")
    public void iAmNavigatedToTheAllVeterinarianPage() {
        allVets = homePage.goToVetsList();
        assertTrue(allVets.isCurrent());
    }

    @And("I click edit button the for the first vet")
    public void iClickEditButtonTheForTheFirstVet() {
       editVet = allVets.editFirst();
    }

    @When("I am on the edit vet form")
    public void iAmOnTheEditVetForm() {
        assertTrue(editVet.isCurrent());
    }

    @And("I enter valid data")
    public void iEnterValidData() {
        editVet.fillValid(fname,lname);
        allVets = editVet.saveAndRedirect();
    }

    @Then("The edited vet will be displayed at the end of the vets's list")
    public void theEditedVetWillBeDisplayedAtTheEndOfTheVetsSList() {
        assertTrue(allVets.isEdited(validEdited));
        allVets.closeBrowser();
    }


}
