Feature: User can login in personal cabinet
  As a User

  Background:
    Given User is on login form

  @login
  Scenario: Successful login with valid credentials
    Given User has valid credentials
    When User inputs name
    And User inputs password
    And User clicks on login button
    Then User verify that login with correct name and password is successfully and User on 'Personal cabinet' page

  @login
  Scenario Outline: Unsuccessful login with invalid credentials
    Given User doesn't has valid credentials
    When User inputs <name> name
    And User inputs <password> password
    And User clicks on login button
    Then User verify that login with incorrect name and password isn't successfully and User on remind login or password page
    Examples:
      | name     | password |
      | testtask | 12345    |
      | gomel    | 12345678 |
