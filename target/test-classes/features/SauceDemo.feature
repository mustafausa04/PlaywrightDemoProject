# we normally use one feature file for each module of the application
  @regression
Feature: User access control
  Sauce demo apps user management use cases

  Background:
    Given User is on the sauce login page
      # the background steps will be considered scenario steps for each of the scenario in this feature file.
   # and background steps will be executed just before any scenario steps defined in the scenario.
   # you can only put the steps which are the beginning of the scenario into the background.


#Verify a valid username and password should be able to login and user is directed to homepage;
  @sauce_valid_login @smoke_test
  Scenario: Valid sauce user should be able to login
    When User enters a valid username and a valid password
    And User clicks on login button
    Then User should be able to login successfully
      #And user is directed to the homepage

   #Verify a valid username and with invalid password should not be able to login.
  @invalid_pass_login @smoke_test
  Scenario: Valid sauce user with invalid password should not be able to login
    When User enters a valid username and a invalid password
    And User clicks on login button
    Then User should not be logged in
    And Error message "Epic sadface: Username and password do not match any user in this service" displays