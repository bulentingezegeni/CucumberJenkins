#All feature files must start with Feature keyword. There can be only 1 Feature keyword per file.
  # Feature describes the overall test cases.
  # It can be the user story name
  # Google_Search_Functionality --> writing like this is convention
  # Google Search Functionality --> we can also write like this
@google_search
Feature: Google_Search_Functionality
# Scenario = Test Case
 # TC is Test Case

   # Under scenario we will have TEST STEPS
    # Given, And, Then, When, But, *annotations
    # These are Gherkin language
    # Each Step MUST START with a GHERKIN KEYWORD

    # Given should be used as preconditions
    # Then should be used for verifications
    # And and When should be used in the middle steps
    # But technically we can use any here and it does not need to match with the one in stepdefs class


  Background: user_is_on_the_google_page
    # Background keyword is used before Scenario keyword and it will run before each Scenario
    # Background is used for repeated pre conditions
    # It cannot be used after Scenario keyword, so use it first
    Given user is on the google page

  @iphone_search
  Scenario: TC01_iphone_search
    When user search for iphone on google
    Then verify the result has iPhone related results
    Then capture the screenshot
    Then  close the application

# We can create multiple Scenarios
  @teapot_search
  Scenario: TC02_teapot_search
    When user search for Tea Pot on google
    Then verify the result has Tea Pot related results
    Then capture the screenshot
    Then close the application

 # flower scenario -- wip=work in progress
  @flower_search @wip
  Scenario: TC03_flower_search
    When user search for flower on google
    Then verify the result has flower related results
    Then capture the screenshot
    Then close the application

 #What is a feature file?
#We write our test scenarios in feature files.
#We use Gherkin language in the feature files such as Feature, Scenario, Given, And, Then, When, But, Background,...
#It is written in plain English
#Known as non technical part. Everybody can read and understand

#What is a step definition?
#We write our Java code in the step definitions
#This has the technical part.Only technical people can understand
