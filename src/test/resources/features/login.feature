Feature: login functionality
  As a user, I should be able to login

  Background: login menu
    Given user is on the home page
    When user clicks on the login menu

  Scenario: positive login test
    And user enters valid credentials and clicks on the login button
    Then Then verify that user can see username

  Scenario: positive test with parameters
    When user enters "testSumeyra" username "kara1234" password and clicks on the login button
    Then verify that user can see "testSumeyra" username


  Scenario Outline: positive login test with DDT
    When user enters "<username>" username "<password>" password and clicks on the login button
    Then verify that user can see "<username>" username
    Examples:
      | username    | password |
      | batch16     | Test123- |
      | testSumeyra | kara1234 |


  Scenario Outline: positive login test DDT with dataTable
    When user enters following credentials
      | username | <username> |
      | password | <password> |

    Then verify that user can see "<username>" username
    Examples:
      | username    | password |
      | batch16     | Test123- |
      | testSumeyra | kara1234 |