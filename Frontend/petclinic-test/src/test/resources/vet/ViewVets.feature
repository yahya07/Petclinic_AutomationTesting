Feature: View All Vets
  As an admin
  I want to see all existing vets in our pet clinic
  So that i can delete or update them.

  Scenario: Successfully view all Vets
    Given I am starting from the homepage
    When  I click on All Veterinarians tab
    Then  page is redirected and im on all vets page