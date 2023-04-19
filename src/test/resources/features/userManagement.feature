@login @regression
Feature: Title of your feature
  I want to use this template for my feature file

  @validlogin @loginTests @smokeTest
  Scenario: Successful login
    Given As a user, I am on the login page
    When I enter valid username and password
    And I click on the login button
    Then I should be on the user profile page

  @invalidlogin @loginTests
  Scenario Outline: Invalid username login
    Given As a user, I am on the login page
    When I enter invalid username and valid password
    And I click on the login button
    Then I should see an error message
    And I should not be on the user profile page

  @invalidPasswordLogin
  Scenario: Invalid passowrd login
    When I enter a vaid username and invalid password
    And I click on login button
    Then I should see an error message
    And I should not be logged in
    And I click on login button

  @invalidUsernameandInvalidPassword
  Scenario: Invalid username and invalid password
    When I enter invalid username and invalid password
    And I click on login button
    Then I should see an error message
    And I should not be logged in