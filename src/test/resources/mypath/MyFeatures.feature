Feature: Title of your feature
  I want to use this template for my feature file

  Scenario: Is it Friday
    Given Hello! Today is Tuesday 10/30
    Given an orange
    Given a banana
    Given she does not own a car
    Given she doesn't own a car

  Scenario Outline: Do many things
    Given <condition>

    Examples: 
      | condition             |
      | an orange             |
      | she doesn't own a car |

  Scenario: 
    Given I have some things
      | name   | count |
      | Fred   |     1 |
      | Jim    |     5 |
      | Shiela |     7 |

  Scenario: Cross object injection
    Given A message of good morning
    Then I should see the data good morning
