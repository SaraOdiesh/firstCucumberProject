#Test case:
#go to amazon.com
#verify that you are on the amazon home page. (verify with title).
#verify dropdown value is by default "All Departments"
#select department Home & Kitchen, and search coffee mug.
#verify you are on coffee mug search results page (use title).
#verify you are in Home & Kitchen department.

Feature: Amazon departments

  @amazonTest 
  Scenario: As a User, I am able to select different departments and search
    Given I am on the amazon homepage
    And The departments dropdown is "All Departments"
    When I select the department "Home & Kitchen"
    And I search "Coffee mug"
    Then I should be on "Coffee mug" search result page
    And The departments dropdown is "Home & Kitchen"
   @amazonSearch
  Scenario Outline: Search for a specific item and verify the search result
    Given I am on the amazon homepage
    When I search "<testdata>" and click search
    And I wait for the search result page to load
    Then I verify the search criteria text element matches

    Examples: 
      | testdata          |
      | Coffee mug        |
      | pretty coffee mug |
      | cool coffee mug   |
      | cute coffee mug   |
