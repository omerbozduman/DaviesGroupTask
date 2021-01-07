@daviesgroup
Feature: Social Media Links

  Background:
    Given I open the DaviesGroup webpage


  @homepage
  Scenario: verify social media links
    When I click the social media links
    Then I should be navigate to respective social media webpages
    |Twitter|
    |LinkedIn|





