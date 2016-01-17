Feature: Square

  As a user,
  I want to be able to square a number
  So that I don't have to do it manually and risk having an incorrect result

  Scenario: Square a Positive
    Given I enter the integer 6
    When I preform the "square" operation
    Then the result should be 36.0

  Scenario: Square a Negative
    Given I enter the integer -2
    When I preform the "square" operation
    Then the result should be 4.0

  Scenario: Add Empty List
    Given I enter no numbers
    When I preform the "square" operation
    Then I should get an error message saying "Number list has invalid number of numbers.  Can only have one number";