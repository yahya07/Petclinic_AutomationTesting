Feature: Edit an existing Vet
  As an admin
  I want to edit existing vets in our pet clinic
  So that I can reslove any error made in their data

  Scenario: Successfully editing a Vet
    Given I am navigated to the All Veterinarian page
    And   I click edit button the for the first vet
    When  I am on the edit vet form
    And   I enter valid data
    Then  The edited vet will be displayed at the end of the vets's list

#  Scenario: Successfully add a Vet without choosing type
#    Given I am on the New Veterinarian form
#    When   I enter valid vet data without choosing type
#    Then  The new vet will be displayed at the end of the vets's list
#
#  Scenario: Unsuccessfully add a Vet
#    Given I am on the New Veterinarian form
#    When  I click Save Vet Button
#    Then  page is not redirected
#
#  Scenario: Short data
#    Given I am on the New Veterinarian form
#    When  I enter a single character in both fields
#    Then  I see error message specifying at least two chars long
#
#
#  Scenario: Submit Short data
#    Given I am on the New Veterinarian form
#    When  I enter one character in both fields
#    Then  The new short vet will be displayed at the end of the vets's list
#
#  Scenario: Create Vet with symbols and numbers in fields
#    Given I am on the New Veterinarian form
#    When   I enter symbols and numbers rather in fields
#    Then  The new numeric vet will be displayed at the end of the vets's list
#
