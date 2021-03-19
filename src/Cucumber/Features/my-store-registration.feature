Feature: my store registration
  Scenario Outline: user can register with proper data
    Given user is on registration page
    When user inputs <first name>, <last name>, <email>, <password>
    When user clicks Save button
    Then user is registered

    Examples:
    |first name|last name|email         |password|
    |Kasia     |Leń      |mail@mail.com |123     |
    |Basia     |Pomidory |jsjjs@nana.pl |asasasa |
    |Sławek    |Jabolek  |123@123.jsjs  |hasło123|
    