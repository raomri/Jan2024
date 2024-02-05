Feature: Title of your feature

  Background: 
    Given I login into the application


  Scenario: Calculating to add two numbers
    Given User has two integer numbers 10 and 20
    When User adds the two numbers
    Then User verifies the number is 30


  Scenario Outline: Calculating to add two numbers
    Given User has two integer numbers <first> and <second>
    When User adds the two numbers
    Then User verifies the number is <result>

    Examples: 
      | first | second | result |
      |    20 |     30 |     50 |
      |     5 |      5 |     10 |
      |    10 |     12 |     22 |
      |    55 |     65 |    120 |
