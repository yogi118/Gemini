Feature: New Place order
  As the Gemini Exchange user, I can place a new buy oredr  
  so that I can buy the new didgital coins

  @Regression @Smoke @Broken @post
  Scenario Outline: As an end user, I want to place new buy order for digital coin
    Given I have "<base_uri>" and "<base_path>" for placing new buy order
    When I want to place new purchase order for "<symbol>" with quantity "<amount>" and price "<price>" of "<type>" type
    Then I should get "200" as post response
    And User shold be able to place the new buy order

    Examples: 
      | base_uri               | base_path     | symbol | amount | price   | type           |
      | https://api.gemini.com | /v1/order/new | btcusd |      5 | 3633.00 | exchange limit |

  @Regression @Smoke @Broken @post
  Scenario Outline: As an end user, I should not be able to place order for which exchange sybol is not present
    Given I have "<base_uri>" and "<base_path>" for placing new buy order
    When I want to place new purchase order for "<symbol>" with quantity "<amount>" and price "<price>" of "<type>" type
    Then I should get "201" as post response
    And User shold not be able to place the new buy order

    Examples: 
      | base_uri               | base_path     | symbol | amount | price   | type           |
      | https://api.gemini.com | /v1/order/new | hfahfk |      5 | 3633.00 | exchange limit |

  @Regression @Broken @post
  Scenario Outline: As an end user, I should pay total amount as per quantity and price of the digital coin
    Given I have "<base_uri>" and "<base_path>" for placing new buy order
    When I want to place new purchase order for "<symbol>" with quantity "<amount>" and price "<price>" of "<type>" type
    Then I should get "200" as post response
    And Toltal price paid should be "<total_price>" as per amount

    Examples: 
      | base_uri               | base_path     | symbol | amount | price   | total_price | type           |
      | https://api.gemini.com | /v1/order/new | btcusd |      3 | 3633.00 |    10899.00 | exchange limit |

  @Regression @Broken @post
  Scenario Outline: As an end user, I should not be able to place order when price is in -ve value
    Given I have "<base_uri>" and "<base_path>" for placing new buy order
    When I want to place new purchase order for "<symbol>" with quantity "<amount>" and price "<price>" of "<type>" type
    Then I should get "201" as post response
    And User shold not be able to place the new buy order

    Examples: 
      | base_uri               | base_path     | symbol | amount | price | type           |
      | https://api.gemini.com | /v1/order/new | btcusd |      3 |  -321 | exchange limit |

  @Regression @Broken @post
  Scenario Outline: As an end user, I should not be able to place order when the stop limit price is higher than the price
    Given I have "<base_uri>" and "<base_path>" for placing new buy order
    When I want to place new purchase order for "<symbol>" with stop_price "<stop_price>" and price "<price>" of "<type>" type
    Then I should get "201" as post response
    And User shold not be able to place the new buy order

    Examples: 
      | base_uri               | base_path     | symbol | stop_price | price | type                |
      | https://api.gemini.com | /v1/order/new | btcusd |      10700 | 10500 | exchange stop limit |

  @Regression @Broken @post
  Scenario Outline: As an end user, I should not be able to place order when the stop limit price is higher than the price
    Given I have "<base_uri>" and "<base_path>" for placing new buy order
    When I want to place new purchase order for "<symbol>" with stop_price "<stop_price>" and price "<price>" of "<type>" type with "<options>" optional array
    Then I should get "201" as post response
    And User shold not be able to place the new buy order

    Examples: 
      | base_uri               | base_path     | symbol | stop_price | price    | type                | options          |
      | https://api.gemini.com | /v1/order/new | btcusd |   10400.00 | 10500.00 | exchange stop limit | 3644.00, 3645.00 |
