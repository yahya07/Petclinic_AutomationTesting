Feature: Edit Pet
  As an employee
  I want to edit pets information
  So that we can trust that their information is correct

  Scenario: Successfully edit a pet
    Given I am on the edit-pet form
    And   I enter valid pet data
    When  I submit the form
    Then  The pet information will be updated and displayed at the owner information page


  Scenario: Submit with empty fields
    Given I am on the edit-pet form
    And   I leave all the fields empty
    When  I submit the form
    Then  I remain in the same page

  Scenario: Birth data must be in a date format
    Given I am on the edit-pet form
    And   I enter a non-date formatted value into the birth date field
    When  I submit the form
    Then  I remain in the same page


  Scenario: Edit pet with symbols and numbers in the name field
    Given I am on the edit-pet form
    And   I enter symbols and numbers rather than words in the name field
    When  I submit the form
    Then  The pet information will be updated and displayed at the owner information page

