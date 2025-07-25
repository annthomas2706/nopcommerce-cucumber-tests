#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Admin Login to nopCommerce

  As an admin user
  I want to log in to the nopCommerce admin dashboard
  So that I can manage the website

  Scenario: Successful login with valid credentials
    Given User launches Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And User clicks the login button
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User clicks out Logout button
    Then Login title should be "nopCommerce demo store. Login"
    And Close browser
    
    
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
   
   

