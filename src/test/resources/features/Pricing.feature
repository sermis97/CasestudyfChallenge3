Feature: Pricing Checkout

  Scenario: Checking basket price
    Given the user is on the airtame.com
    When the user navigate  to Pricing page
    And the user add  an Airtame device to the cart
    And the user add two more Airtames and two PoE adaptors to cart
    Then verify that total price equals one thousand four hundred fifty five Euro

