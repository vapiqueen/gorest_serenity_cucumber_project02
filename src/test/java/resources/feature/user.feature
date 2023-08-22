Feature: Gorest Application
  As a user i want to test gorest Application

  Scenario Outline: CRUD Test
    Given Gorest application is running
    When I create a new user by providing the information name "<name>" gender "<gender>" email "<email>" status "<status>"
    Then I verify that user is created
    And I update a newly created user and verify user created successfully
    And I delete a newly created user and verify it deleted successfully


    Examples:
      | name     | gender   | email            | status   |
      | abcd21   | female   | bcd21@gmail.com  | active   |
      | defgh2   | male     | noo133@gmail.com | active   |