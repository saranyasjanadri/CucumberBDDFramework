Feature: Login

  @sanity
  Scenario: Successful login with valid Credentials
    Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Logout link
    Then Page Title should be "Your store. Login"
    And Close browser

  @regression
  Scenario Outline: Login Data Driven
    Given User Launch Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/"
    And User enters Email as "<email>" and Password as "<password>"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Logout link
    Then Page Title should be "Your store. Login"
    And Close browser

    Examples: 
      | email                | password |
      | admin@yourstore.com  | admin    |
      | admin1@yourstore.com | admin123 |
