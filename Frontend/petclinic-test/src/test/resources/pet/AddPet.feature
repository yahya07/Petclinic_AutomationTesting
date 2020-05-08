Feature: Add Pet
  As an employee
  I want to add new pets to a specific customer (owner)
  So that we can track their visits

  Scenario: Successfully add a pet
    Given I am on the add-pet form
    And   I enter valid pet data
    When  I submit the form
    Then  The new pet will be displayed at the owner information page


  Scenario: Submit with empty fields
    Given I am on the add-pet form
    And   I leave all the fields empty
    When  I submit the form
    Then  I remain in the same page

  Scenario: Birth data must be in a date format
    Given I am on the add-pet form
    And   I enter a non-date formatted value into the birth date field
    When  I submit the form
    Then  I remain in the same page

