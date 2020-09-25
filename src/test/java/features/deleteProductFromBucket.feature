Feature: User can delete product from the bucket
  As a User

  @deleteProduct
  Scenario Outline: Successful deleted product from the bucket
    Given User is on bucket page with product <id> in the bucket
    When  User deletes product from the bucket
    Then User sees that bucket is empty and cost is 0
    Examples:
      | id      |
      | 5754419 |
