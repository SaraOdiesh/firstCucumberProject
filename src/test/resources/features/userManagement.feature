@login @regression
Feature: Title of your feature
  I want to use this template for my feature file
  
  
   Background: 
    Given As a user, I am on the login page
    
    
  @validlogin @smokeTest
  Scenario: Successful login
    When I enter valid username and password
    And I click on the login button
    Then I should be on the user profile page

  @invalidlogin 
  Scenario Outline: Invalid username login
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
    
    
    @invalidLoginAttempts
  Scenario Outline: Invalid credential login attempt
  When I enter email "<email>" and password "<password>"
  And I click on login button
  Then I should see an error message
  And I should not be logged in
  
  Examples:
  | email                           | password         |
  | entityadmin@primetechschool.com | hellopassword    |
  | entityAd@primetechschool.com    | primetech@school |
  |                                 | Testing123       |
  | nothing@primetechschool.com     |                  |
  
  
  
  
  @validLoginAttempts
  Scenario Outline: valid credential login attempt
  When I enter email "<email>" and password "<password>"
  And I click on login button
  Then I should be on user profile page
  
  Examples:
  | email                           | password         |
  | entityadmin@primetechschool.com | primetech@school |
  | entityadmin@primetechschool.com | primetech@school |
  | entityadmin@primetechschool.com | primetech@school |
  | entityadmin@primetechschool.com | primetech@school |
  | entityadmin@primetechschool.com | primetech@school |
  | entityadmin@primetechschool.com | primetech@school |
  | entityadmin@primetechschool.com | primetech@school |
  | entityadmin@primetechschool.com | primetech@school |
    
