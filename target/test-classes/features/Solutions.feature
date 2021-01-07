@daviesgroup
Feature: Solutions Module

  Background:
    Given I open the DaviesGroup webpage

  @solutions
  Scenario: verify Solutions module
    When I click the "Solutions" module
    Then I scroll down and click on "View All" button
    Then I search the "Fire investigation" and click on it
    Then I verify that it's navigated to "Fire investigation - Davies" page
    And I capture results section on Fire investigation case study

