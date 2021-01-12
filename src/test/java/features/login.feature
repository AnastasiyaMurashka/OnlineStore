Feature: User can login in personal cabinet
  As a User

  Background:
    Given User is on login form

  @login
  Scenario: Successful login with valid credentials
    Given User has valid credentials

