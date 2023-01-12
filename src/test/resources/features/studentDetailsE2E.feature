Feature: Student Details E2E Test
  Scenario: Create, edit and delete student
    Given Send POST to register new student
    When Send GET to check if student exists
    And Send PUT to update student data
    And Send GET to check if student data updated
    And Send DELETE to remove student
    Then Send GET to check if student does not exist anymore

