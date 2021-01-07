@daviesgroup
Feature: About Module

  Background:
    Given I open the DaviesGroup webpage

  @about
  Scenario: verify About module
    When I click the "Locations" submodule under "About" Us module
    Then I capture the "Birmingham" office address