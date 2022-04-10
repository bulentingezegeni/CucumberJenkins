@user_registration @smoke
Feature: registration feature

  Scenario Outline: user should be able to register

    Given user is on the registration page
    And user enters ssn number as "<SSN>"
    And user enters firstname as "<firstName>" and lastname as "<lastName>"
    And user provides address "<address>"
    And user provides phoneNumber "<phoneNumber>"
    And user provides username "<username>"
    And user provides email "<email>"
    And user provides the firstPassword as "<firstPassword>" and secondPassword as "<secondPassword>"
    Then user clicks on the register button and see the success message as "<successMessage>"


    Examples: user info
      |SSN      |firstName |lastName|address|phoneNumber|username  |email     |firstPassword  |secondPassword |successMessage|
      |528-63-5687|New User|last|Milky way|456-279-5588|utasatemoour|kawaeeo123454@gmail.com|Utilisateur123.|Utilisateur123.|Registration saved!|


  # Firstly I create a feature file
  # I will write my test cases by using Gherkin language as it helps everyone to understand test cases
  # I will create suggested step defs
  # I will create step defs class and paste step defs here
  # I will create page class to locate Web elements