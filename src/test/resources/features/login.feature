
Feature: login functionality
  As a user, I should be able to login

  Background: login menu
    Given user is on the home page
    When user clicks on the login menu

  Scenario: positive login test
    And user enters valid credentials and clicks on the login button
    Then Then verify that user can see username


  @wip
  Scenario:
    When user enters "testSumeyra" username "kara1234" password and clicks on the login button
    Then verify that user can see "testSumeyra" username