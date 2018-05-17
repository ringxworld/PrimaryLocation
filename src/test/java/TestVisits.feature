Feature: Test Visits

  @SameLocation
  Scenario: Any latitude/longitude coordinates that have the same coordinates to 3 decimal places are considered the same location.
    Given I GeoLocations at a close distance
    Then I recognize that they are the same point

  @AddUpTimeAtLocation
  Scenario: Visited location several times and stayed there for a period of time, is the total time correct
    Given I visit a location multiple times
    Then I correctly add up all the cumulative time spent there

  @HandleNightTime
  Scenario: Keep track of times after 8pm and before 8am
    Given I have a night time value
    Then Identify that it is valid

  @HandleMultipleNightLocations
  Scenario: Find the most visited night time location
    Given I visit multiple locations at night
    Then The most visited one is my home