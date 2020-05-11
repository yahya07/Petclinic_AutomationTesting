Feature: Edit an existing Vet
  As an admin
  I want to edit existing vets in our pet clinic
  So that I can resolve any error made in their data

  Scenario: Successfully editing a Vet
    Given I am navigated to the All Veterinarian page
    When  I click edit button the for the first vet
    And   I enter valid data
    Then  The edited vet will be displayed at the end of the vets's list

  Scenario: Successfully editing a Vet to have numbers as names
    Given I am navigated to the All Veterinarian page
    When  I click edit button the for the first vet
    And   I fill fields with numbers
    Then  The edited vet will be displayed at the end of the vets's list

  Scenario: Successfully editing a Vet with two spaces as names
    Given I am navigated to the All Veterinarian page
    When  I click edit button the for the first vet
    And   I fill fields with two spaces
    Then  The edited vet will be displayed at the end of the vets's list


  Scenario: Unsuccessfully edit a Vet to be blank
    Given I am navigated to the All Veterinarian page
    When  I click edit button the for the first vet
    And   I clear all data
    But   two errors show up
    Then  save button is disabled


