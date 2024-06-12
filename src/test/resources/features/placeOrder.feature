Feature: place order end to end test
  As a user, I should be able to place an order
  @wip
  Scenario: placing order
    Given user is on the home page
    When user clicks on the login menu
    When user enters "testSumeyra" username "kara1234" password and clicks on the login button
    And user adds "Samsung galaxy s6" product from "Phones" category
    And user adds "MacBook air" product from "Laptops" category
    And user adds "MacBook Pro" product from "Laptops" category
    And user adds "Apple monitor 24" product from "Monitors" category
    And user removes "MacBook Pro" product from cart page
    And user places order and capture and log amount
    Then verify the purchase order