Feature: View All Pet Types
  As an   As a employee
  I want to see all existing Pet Types in our pet clinic
  So that i can delete or update them.

  Scenario: Successfully view all Pet Types
    Given I am on the homepage
    When  I click on Pet Types tab
    Then  page is redirected and im on Pet types page