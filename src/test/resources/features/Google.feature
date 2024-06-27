Feature: Google Search feature

  @passed
  Scenario: Example of a passed scenario
    Given I open Google Search page
    When I enter search term as "xoilactv"
    And I hit enter key
    Then I should see Google Search results

