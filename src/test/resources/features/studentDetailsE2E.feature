Feature: Student Details E2E Test
  Scenario: Create, edit and delete student
    Given The new student has been registered
    When The Students details are saved
    And The Students middle name has been updated
    And Updates are saved
    And The Student has been deleted
    Then The Student does not exist anymore

