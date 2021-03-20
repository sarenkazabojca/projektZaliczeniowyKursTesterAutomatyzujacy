Feature: my store - order

  Scenario: user can order products
    Given user is on login page
    When user makes proper login
    When user search in catalog 'Hummingbird Printed Sweater'
    When user choose 'Hummingbird Printed Sweater' in search result
    When user choose size 'M'
    When user set the quantity to 5
    When user add product to cart
    When user click 'Proceed to checkout' in dialog window
    When user click 'Proceed to checkout' in cart
    When user click 'Continue' on address page
    When user click 'Continue' on shipping method page
    When user choose 'Pay by Check' option
    When user click checkbox with terms of service
    When user submit on payment page
    When user make screenshot with order details
    Then user made proper order
    And  close browser