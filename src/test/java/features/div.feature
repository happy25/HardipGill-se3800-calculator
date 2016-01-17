Feature: Division

  As a user,
  I want to be able to divide two numbers
  So that I don't have to do it manually and risk having an incorrect result

  Scenario: Divide Positives
    Given I enter the integer 6
    And I enter the integer 3
    When I preform the "divide" operation
    Then the result should be 2.0

  Scenario: Divide Negatives
    Given I enter the integer -6
    And I enter the integer -3
    When I preform the "divide" operation
    Then the result should be 2.0

  Scenario: Divide Both Positive and Negative
    Given I enter the integer -1
    And I enter the integer 2
    When I preform the "divide" operation
    Then the result should be -0.5

  Scenario: Divide Empty List
    Given I enter no numbers
    When I preform the "divide" operation
    Then I should get an error message saying "Number list must contain at least one number";