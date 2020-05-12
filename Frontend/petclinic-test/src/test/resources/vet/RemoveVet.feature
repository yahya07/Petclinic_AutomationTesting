Feature: Remove Vet
  As an admin
  I want to remove an existing vet from our pet clinic
  So that customers can book only available vets.

  Scenario: Successfully delete a Vet
    Given I am on the All Veterinarian page
    When  I click on delete button next to any vet
    Then  that vet will be removed from the table