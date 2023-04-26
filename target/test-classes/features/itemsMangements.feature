@regression @itemsTests
Feature: Items Management

  # any steps defined under background will be executed before the first step of eahc scenarios
  # in the feature file.
  Background: 
    Given As an entity user, I am logged in
    And I navigate to Items tab

  @createItem @smoketest
  Scenario: As a user, I am able to create an item or a service
    And I navigate to Items tab
    When I click on the Add Item button
    Then I should be on item input page
    When I provide item information name "Notebook", price 1800, unit "pc", and description "a good book"
    And I click Save Item button
    Then The Item is addedpc to the Item list table

  @createItemWithDataTable @smoketest
  Scenario: As a user, I am able to create an item or a service
    When I click on the Add Item button
    Then I should be on item input page
    When I provide item information to the fields
      | MacBook Pro | 180000 | box | a good thing |
    And I click Save Item button
    Then The Item is added to the Item list table

  @updateItem
  Scenario: As a user, I am able to update an item or a service
    And I navigate to Items tab
    When I select the item "MacBook Pro"
    And I should be on item details page
    When I update the item price to 1200 dollars
    And I click Update Item button
    Then the Item price is updated to 1200 dollars

  @createAnItem @smoketest
  Scenario: As a user, I am able to create an item or a service
    When I click on the Add Item button
    Then I should be on item input page
    When I provide item information name "iphone pro", price "1800", unit "pc", and description "a good phone"
    And I click Save Item button
    Then The Item is added to the Item list table

  @deleteAnItem @smoketest
  Scenario: As a user, I am able to create an item or a service
    When I click on the Add Item button
    Then I should be on item input page
    When I provide item information name "iphone pro", price "1800", unit "pc", and description "a good phone"
    And I click Save Item button
    Then The Item is added to the Item list table
    When I delete the Item
    Then The Item will be deleted
