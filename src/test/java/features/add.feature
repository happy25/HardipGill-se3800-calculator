Feature: Addition

  As a user,
  I want to be able to add two numbers
  So that I don't have to do it manually and risk having an incorrect result

  Scenario: Add Positives
    Given I enter the integer 1
    And I enter the integer 2
    When I preform the "add" operation
    Then the result should be 3.0

  Scenario: Add Negatives
    Given I enter the integer -1
    And I enter the integer -2
    When I preform the "add" operation
    Then the result should be -3.0

  Scenario: Add Both Positive and Negative
    Given I enter the integer -1
    And I enter the integer 2
    When I preform the "add" operation
    Then the result should be 1.0

  Scenario: Add Empty List
    Given I enter no numbers
    When I preform the "add" operation
    Then I should get an error message saying "Number list must contain at least one number";