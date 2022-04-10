@excel_login
Feature: login_feature
  @admin_login
  Scenario: TC_01_admin_login
    Given user login with excel as "admin"
    Then capture the screenshot
    Then close the application

    # Doing a codeless framework
  # Because I created enough reusable step definitions
    @employee_login
    Scenario: TC_02_employee_login
      Given user login with excel as "employee"
      Then capture the screenshot
      Then close the application
