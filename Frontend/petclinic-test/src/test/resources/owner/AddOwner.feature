Feature: Add Owner
  As a employee
  I want to add new customers (owners)
  So that we can track their pets and visits

  Scenario: Successfully enter a new owner's details
    Given I am on the add-owner form
    When  I enter valid owner data
    Then  Each field will have a tick on the right

  Scenario: Successfully add an owner
    Given I am on the add-owner form
    And   I enter valid owner data
    When  I submit the form
    Then  The new owner will be displayed at the end of the owner's list

  Scenario: Unsuccessfully add an owner
    Given I am on the add-owner form
    When  I enter invalid data
    Then  The submit button is disabled

  Scenario: Short data
    Given I am on the add-owner form
    When  I try to enter a single character into the name fields
    Then  I see a specific message for each field specifying that the field must be at least 2 chars long
    And   Each field has an x at the end

  Scenario: Remove values from all the fields
    Given I am on the add-owner form
    And   I enter then remove values from each field
    Then  The submit button is disabled
    And   I see a specific message for each field specifying that it is required
    And   Each field has an x at the end

  Scenario: Phone number must be numeric
    Given I am on the add-owner form
    And   I enter a non-numeric value into the phone field
    Then  The submit button is disabled
    And   I see an error message specifying that the phone number only accepts digits
    And   The field has an x at the end

  Scenario: Create owner with symbols and numbers in key fields
    Given I am on the add-owner form
    And   I enter symbols and numbers rather than words
    When  I submit the form
    Then  The new owner will be displayed at the end of the owner's list

  Scenario: Duplicate an owner
    Given I am on the add-owner form
    And   I enter duplicate owner's details
    When  I submit the form
    Then  The new owner will be displayed at the end of the owner's list
