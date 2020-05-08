Feature: Add Vet
  As an admin
  I want to add new vets in our pet clinic
  So that customers can book them for visits

#  Scenario: Successfully enter a new vet's details
#    Given I am on the New Veterinarian form
#    When  I enter valid vet data
#    Then  Each field will have a tick on the right

  Scenario: Successfully add a Vet
    Given I am on the New Veterinarian form
    And   I enter valid vet data
    When  I click Save Vet Button
    Then  The new vet will be displayed at the end of the vets's list
#
#  Scenario: Successfully add a Vet
#    Given I am on the New Veterinarian form
#    And   I enter valid vet data
#    But   I don't choose Type
#    When  I click Save Vet Button
#    Then  The new vet will be displayed at the end of the vets's list
#
#  Scenario: Unsuccessfully add a Vet
#    Given I am on the New Veterinarian form
#    And  I leave all fields blank
#    When  I click Save Vet Button
#    Then  nothing is saved
#    And page is not redirected
#
#  Scenario: Short data
#    Given I am on the New Veterinarian form
#    When  I try to enter a single character into the name fields
#    Then  I see a specific message for each field specifying that the field must be at least 2 chars long
#    And   Each field has an x at the end
#
#  Scenario: Submit Short data
#    Given I am on the New Veterinarian form
#    And  I try to enter a single character into the name fields
#    And  I see a specific message for each field specifying that the field must be at least 2 chars long
#    When  I click Save Vet Button
#    Then  The new vet will be displayed at the end of the vets's list
#
#
#  Scenario: Create Vet with symbols and numbers in fields
#    Given I am on the New Veterinarian form
#    And   I enter symbols and numbers rather than words
#    When I cick Save Vet Button
#    Then  The new vet will be displayed at the end of the vets's list
#
#  Scenario: Duplicate a vet
#    Given I am on the New Veterinarian form
#    And   I enter duplicate vet's details
#    When I cick Save Vet Button
#    Then  The new vet will be displayed at the end of the vets's list
