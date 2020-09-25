Feature: Product in bucket has correct name and correct cost
  As a User

  @checkProductData
  Scenario Outline: User can see that product in bucket has correct name and correct cost
    Given User is on product page with <id>
    When  User adds product in bucket
    And User goes to the bucket
    Then User sees that name in bucket is the same with name from product page
    Then User sees that cost in bucket is the same with cost from product page
    Examples:
      | id      |
      | 581769  |
      | 772179  |
      | 9798352 |
