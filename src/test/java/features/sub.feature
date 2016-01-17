Feature: Subtraction

  As a user,
  I want to be able to subtract two numbers
  So that I don't have to do it manually and risk having an incorrect result

  Scenario: Subtract Positives
    Given I enter the integer 1
    And I enter the integer 2
    When I preform the "subtract" operation
    Then the result should be -1.0

  Scenario: Subtract Negatives
    Given I enter the integer -1
    And I enter the integer -2
    When I preform the "subtract" operation
    Then the result should be 1.0

  Scenario: Subtract Both Positive and Negative
    Given I enter the integer -1
    And I enter the integer 2
    When I preform the "subtract" operation
    Then the result should be -3.0

  Scenario: Subtract Empty List
    Given I enter no numbers
    When I preform the "subtract" operation
    Then I should get an error message saying "Number list must contain at least one number";