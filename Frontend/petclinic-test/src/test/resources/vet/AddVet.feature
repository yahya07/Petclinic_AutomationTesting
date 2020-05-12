Feature: Add Vet
  As an admin
  I want to add new vets in our pet clinic
  So that customers can book them for visits

  Scenario: Successfully add a Vet choosing type
    Given I am on the New Veterinarian form
    When   I enter valid vet data with choosing type
    Then  The new vet will be displayed at the end of the vets's list

  Scenario: Successfully add a Vet without choosing type
    Given I am on the New Veterinarian form
    When   I enter valid vet data without choosing type
    Then  The new vet will be displayed at the end of the vets's list

  Scenario: Unsuccessfully add a Vet
    Given I am on the New Veterinarian form
    When  I click Save Vet Button
    Then  page is not redirected

  Scenario: Short data
    Given I am on the New Veterinarian form
    When  I enter a single character in both fields
    Then  I see error message specifying at least two chars long


  Scenario: Submit Short data
    Given I am on the New Veterinarian form
    When  I enter one character in both fields
    Then  The new short vet will be displayed at the end of the vets's list

  Scenario: Create Vet with symbols and numbers in fields
    Given I am on the New Veterinarian form
    When   I enter symbols and numbers rather in fields
    Then  The new numeric vet will be displayed at the end of the vets's list

