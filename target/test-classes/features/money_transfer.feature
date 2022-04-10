@new_money_transfer
Feature: money transfer feature

  Scenario Outline: login_with_customer_credentials
    Given user is on the login page
    Given user has log in with "<username>" and "<password>"

    Examples: Login Credentials
    | username         | password      |
    | shaylee.lindgren | mVSk$eq1YoZwq |


  Scenario: user_should_make_money_transfer

    Given user clicks on my operations
    And user clicks on transfer money
    When user select the current account to transfer money from
    And user select the other account to transfer money to
    When user provides the balance "3" for dolar and "5" cent
    And user types the description
    Then user makes the money transfer and verify success message
    Then close the application












