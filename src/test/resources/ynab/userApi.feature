Feature: Get user info

  Scenario: As user I want to get my info
    Given I use valid API key
    When I call get user endpoint
    Then I get valid user response
    Then My user id is f2233654-2dc7-422b-bf63-dd7c9eee01f1

  Scenario: As user I cannot see info for empty key
    Given I use empty API key
    When I call get user endpoint
    Then I get 401 HTTP error

  Scenario: As user I cannot see info for incorrect API key
    Given I use invalid API key
    When I call get user endpoint
    Then I get 401 HTTP error

  Scenario: As user I cannot see info without provided oauth2 header provided
    When I call get user endpoint without oauth headers
    Then I get 401 HTTP error

  Scenario: As user I should be not able to delete my user
    Given I use valid API key
    When I call delete user endpoint
    Then I get 401 HTTP error
    When I call get user endpoint
    Then I get valid user response
    Then My user id is f2233654-2dc7-422b-bf63-dd7c9eee01f1
