@wip
Feature: login functionality
  As a user, I should be able to login

  Scenario: positive login test
    Given user is on the home page
    When user clicks on the login menu
    And user enters valid credentials and clicks on the login button
    Then Then verify that user cann see username