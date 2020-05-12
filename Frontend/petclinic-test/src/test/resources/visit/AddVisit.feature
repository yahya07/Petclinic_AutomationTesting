Feature: Add a new visit
  As an employee I want to save and register every owner visits
  so that I can keep track and see how many time an owner visit his/her pet

  Scenario: Add new visit successfully
    Given I am on the add-visit form
    When I enter valid visit data
    And I submit the visit form
    Then A new visit should be added to the owner page

  Scenario: Add new visit with empty fields
    Given I am on the add-visit form
    And I submit the visit form without filling any field
    Then I will remain on the same page


  Scenario: Add new visit with invalid data
    Given I am on the add-visit form
    And I enter invalid data
    And I submit the visit form
    Then I will remain on the same page
