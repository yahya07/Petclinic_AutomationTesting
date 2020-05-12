Feature: Remove Pet
  As an employee
  I want to remove pets
  So that we can keep the pets table up to date

  Scenario: Successfully delete a pet
    Given I am on the owner information page
    When  I delete a pet
    Then  The pet disappear from the pets table