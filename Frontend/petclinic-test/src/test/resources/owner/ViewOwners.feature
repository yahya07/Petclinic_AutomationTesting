Feature: View Owners
  As a employee
  I want to view the petclinic customers (owners)
  So that we can have a complete collection of
  our customers information.

  Scenario: Successfully view owners via home page menu
    Given I am on the home page
    When I click on ALL from the OWNERS tab

    Then  I will be directed to AllOwners page

