Feature: my store - adding a new address
  Scenario Outline: user can add new address to account
    Given user is on login page
    When user makes proper login
    When user clicks 'Addresses' tile
    When user clicks '+Create new address' button
    When user inputs <address>, <city>, <postalCode>, <country>, <phone> to address form
    When user clicks 'Save' button
    Then user added a new proper address
#    And  close browser

    Examples:
    |address                     |city       |postalCode |country       |phone       |
    |ul. Konstytucji 3 Maja 120  |Koszalin   |75-828     |United Kingdom|53 412 78 25|
#    |ul. Gojawiczyńskiej Poli 113|Warszawa   |01-773     |United Kingdom|60 140 25 83|
#    |ul. Organizacji WiN 120     |Łódź       |90-968     |United Kingdom|67 308 14 72|
#    |ul. Fiołkowa 67             |Lublin     |20-834     |United Kingdom|69 365 30 49|
#    |ul. Kołodzieja 130          |Poznań     |61-070     |United Kingdom|67 582 95 61|
