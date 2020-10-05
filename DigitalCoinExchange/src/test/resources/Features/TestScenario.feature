Feature: Title of your feature
  I want to use this template for my feature file

  @Regression @Smoke 
  Scenario: As an end user, I want to verify Ether(ethuds) symbol is present for trading
    When I hit the get request "https://api.gemini.com/v1/symbols" to get all the symbols present
    Then I should get valid response
    And Response should contain "ethusd" as trade symbol


  @Regression
  Scenario: As an end user, I want to verify recent trading activity contains required key values
    When I hit the get request "https://api.gemini.com/v1/pubticker/btcusd" and analyze the response
    Then I should get valid response
    And Response body should contain the key values
      | bid        |
      | ask        |
      | volume     |
      | last       |
