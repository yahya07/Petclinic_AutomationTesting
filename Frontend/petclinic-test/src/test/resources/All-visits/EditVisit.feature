Feature: Edit a visit data
  As an employee I want to update a visit details
  so that I can edit the details if they are needed to be corrected or changed

  Scenario: Edit a visit successfully
    Given I am on the Edit-visit form
    When I re-enter the visit-form data
    And I click submit update button
    Then The updated visit will be displayed in the owner's page list

  Scenario: Edit a visit with invalid data
    Given I am on the Edit-visit form
    When I re-enter the visit-form data with invalid data
    And I click submit update button
    Then I will stay on the same page

  Scenario: Remove all data from fields
    Given I am on the Edit-visit form
    And I remove all values from all fields
    Then I will stay on the same page