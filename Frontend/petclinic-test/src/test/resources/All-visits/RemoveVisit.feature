Feature: Remove a visit
  As an employee
  I want to delete a visit
  So that I can delete incorrect visit records

  Scenario: Remove a visit successfully
    Given I am on the owner page
    And I click delete-visit button
    Then the selected visit will be deleted from the visits list