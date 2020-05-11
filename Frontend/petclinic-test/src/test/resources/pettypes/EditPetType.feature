Feature: Edit PetTypes
  As a employee
  I want to Delete  PetType
  So that we can  Edit our PetTypes List

  Scenario: Successfully Edit an Pet Type
    Given I am on the Pet Types page
    And   I Click Edit button
    And   I Edit the Pet Type name
    When  I Click Update button
    Then  The new pet Type name will be displayed at the end of the Pet type's list

  Scenario: Cancel  Edit an PteType
    Given I am on the Pet Types page
    And   I Click Edit button
    When  I Click Cancel button
    Then  The you well go back to Pet Types form

  Scenario: Unsuccessfully Edit an PteType
    Given I am on the Pet Types page
    And   I Click Edit button
    And   I remove value from the field
    When  I Click Update button
    Then  The Update button give no action