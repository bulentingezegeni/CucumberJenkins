@admin_login @smoke
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
    Then capture the screenshot
#    Then close the application

#    DATA TABLES:
#  Data tables are used for providing data ---DDT (Data Driven Testing with Cucumber)
#  Data tables are similar to Scenario Outline
#  But Data tables can be used in any step to provide data inside a Scenario
#  Difference is Example Keyword -- For Data Table no usage for Example
#  # We need to store the data coming from Feature file in a Data Collection like List or List of Map

