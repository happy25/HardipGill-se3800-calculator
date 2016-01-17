Feature: Multiplication

  As a user,
  I want to be able to multiply two numbers
  So that I don't have to do it manually and risk having an incorrect result

  Scenario: Multiply Positives
    Given I enter the integer 2
    And I enter the integer 3
    When I preform the "multiply" operation
    Then the result should be 6.0

  Scenario: Multiply Negatives
    Given I enter the integer -1
    And I enter the integer -2
    When I preform the "multiply" operation
    Then the result should be 2.0

  Scenario: Multiply Both Positive and Negative
    Given I enter the integer -1
    And I enter the integer 2
    When I preform the "multiply" operation
    Then the result should be -2.0

  Scenario: Multiply Empty List
    Given I enter no numbers
    When I preform the "multiply" operation
    Then I should get an error message saying "Number list must contain at least one number";