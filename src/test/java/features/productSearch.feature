Feature: User can search for product
  As a user

  @search
  Scenario Outline: User navigates to the product page which user search for
    Given User is on main page
    When User inputs product <id> ID
    And User clicks search button
    Then User is on product page which the same product <id> ID
    Examples:
      | id     |
      | 676142 |
      | 249465 |
      | 301760 |
