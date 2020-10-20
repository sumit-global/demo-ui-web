Feature: To validate Demo Website

  Background: 
    Given I am on Demo online webpage

  @UI
  Scenario: To validate Cart Functionality
    When I added "Sony vaio i5" to the cart
    And I navigated back to Home screen
    And I added "Dell i7 8gb" to the cart
    And I navigate to cart screen
    And I delete item from "1" row and "4" column
    And I click on "Place Order" button
    And I save total amount
    And I fill the user form using
      | testing   |
      | India     |
      | Delhi     |
      | 123456789 |
      |        12 |
      |      2020 |
    And I click on "Purchase" button  
    Then I capture LogId and assert total amount
    And I click on "OK" button
