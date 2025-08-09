Feature: Admin Login to nopCommerce

  As an admin user
  I want to log in to the nopCommerce admin dashboard
  So that I can manage the website


@sanity
  Scenario: Successful login with valid credentials
    Given User launches Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And User clicks the login button
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User clicks out Logout button
    Then Login title should be "nopCommerce demo store. Login"
    And Close browser
    
  
  @regression  
  Scenario Outline: Login Data Driven
  
  	Given User launches Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>" and password as "<password>"
    And User clicks the login button
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User clicks out Logout button
    Then Login title should be "nopCommerce demo store. Login"
    And Close browser
    
   Examples:
   		
   		| email | password |
   		| admin@yourstore.com | admin |
   		| admin1@yourstore.com | admin |
   
   

