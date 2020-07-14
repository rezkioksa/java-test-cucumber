Feature: Purchasing Pillow Using Credit Card As Payment Method

  @correctCreditCard
  Scenario: Purchase Using Correct Credit Card
    When I open "midtransUrl" page
    And I buy and checkout the pillow
    And I check Order Summary
    And I select "creditCard" payment method
    And I verify payment checkout with "creditCardNumberTrue" credit card number
    And I verify the summary payment

#  Completed
  @wrongCreditCard
  Scenario: Purchase Using Wrong Credit Card
    When I open "midtransUrl" page
    And I buy and checkout the pillow
    And I check Order Summary
    And I select "creditCard" payment method
    And I verify payment checkout with "creditcardNumberFalse" credit card number
    And I verify the summary payment
    Then the transaction should be "failedStatus"