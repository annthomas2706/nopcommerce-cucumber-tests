Feature: Adding details for New Customer in nopCommerce admin

  Scenario: Add New Customer
    Given User launches Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And User clicks the login button
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on customer menu
    And clicks on Customer Menu Item
    And click on Add new button
    Then User can view Add new customer page
    When User enters customer Info
    And click on save button
    And close browser
    
   
   Scenario: Search Customer by Email
    Given User launches Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And User clicks the login button
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on customer menu
    And clicks on Customer Menu Item
    And Enter Customer Email
    When click on Search button
    Then User should found email on search table
    And close browser