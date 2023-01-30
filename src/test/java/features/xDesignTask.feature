Feature: xDesign Home Task

  @TestRunner
  Scenario: Data should load on the page
    Given The page loads
    Then A screen will appear with a list of SpaceX API results

  @TestRunner
  Scenario: Filter by year
    Given Selecting filter
    When Setting filter by year to "2015"
    Then Return a list of only launches in "2015"

  @TestRunner
  Scenario: Order should be done alphabetically
    Given No year filter is on
    When Ordering is done "Descending"
    Then Items should be ordered alphabetically