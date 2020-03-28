Feature: Get budget of the user

  Scenario: As user I want to get my existing budget
    Given I use valid API key
    When I call get budget endpoint with id 14e265a4-1b05-4b4a-bab0-1ad4488a0820
    Then I get valid budget response
    Then Name field is My Budget

  Scenario: As user I cannot get non-existing budget
    Given I use valid API key
    When I call get budget endpoint with random uuid
    Then I get 404 HTTP error

  Scenario: As user I cannot get any budget without API key
    Given I use empty API key
    When I call get budget endpoint with random uuid
    Then I get 401 HTTP error

  Scenario: As user I cannot get any budget with incorrect API key
    Given I use invalid API key
    When I call get budget endpoint with random uuid
    Then I get 401 HTTP error

  Scenario: As user I cannot get budget without id
    Given I use valid API key
    When I call get budget endpoint with id null
    Then I get 405 HTTP error