#Homework Due Saturday
@user_creation
Feature: admin login feature

  Scenario: login_with_employee_credentials
    Given user is on the login page
    And user clicks on login dropdown
    And user clicks on sign in button
    And user enters admin_id and admin_password
      |admin_username|admin_password|
      |CWoburn       |Cw192837?     |
    And user clicks on the login button
    Then verify the login is successful



  Scenario Outline: creating_new_user
    Given admin clicks on user management
    And admin clicks on create a new user button
    And admin enters "<username>" for login
    And admin enters "<firstname>" for firstname and "<lastname>" for lastname
    And admin enters "<email>" for email
    And admin selects language
    And admin selects profile
    And admin clicks save button



    Examples: credentials
    |username|firstname|lastname|email|
    |crowsoooo |Ebru Nur      |Candan     |ema03il12341230@gmail.com|