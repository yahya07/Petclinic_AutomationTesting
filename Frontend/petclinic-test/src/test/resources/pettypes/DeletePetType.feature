Feature: Delete PetTypes
  As a employee
  I want to Delete  PetType
  So that we can  delete from our  PetTypes List

  Scenario: Successfully Delete Pet Type
    Given I am on the Pet Type page
    When  I Click Delete button
    Then  The specific PetType will be disappear from the end of the Pet Type's list