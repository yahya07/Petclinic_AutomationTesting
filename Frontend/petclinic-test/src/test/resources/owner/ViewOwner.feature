Feature: View Owner
  As an admin
  I want to view the information of an owner
  So that I can have a complete collection of
  our owner information.

  Scenario: Successfully view owner information page
    Given I am on all owners page
    When I click on OWNER linked name
    Then  I will be directed to the owner information page