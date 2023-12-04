Feature: Customers
 Background: Below are the common steps for each scenario
 Given User Launch Chrome driver
   When user opens URL "https://admin-demo.nopcommerce.com/login"
   And User enters email as "admin@yourstore.com" and password as "admin"
   And Click on Login
   Then verify dashboard
#Scenario: Add new customer
   #Given User Launch Chrome driver
   #When user opens URL "https://admin-demo.nopcommerce.com/login"
   #And User enters email as "admin@yourstore.com" and password as "admin"
   #And Click on Login
   #Then verify dashboard
   #When user click on Customerand Menu
   #And click on Customers Menu item
   #And click on Add New button
   #Then user can view Add new customer page
   #When user enter cutomer info
   #And click on save button
   #Then user can view confirmed message "The new customer has been added successfully"
   #And close browser

@sanity
Scenario: Search Customer by email ID
   When user click on Customerand Menu
   And click on Customers Menu item
   When user enter email id
   And click on search button
   Then user should found email in the search table
   And close browser
   
@regression   
 Scenario: Search Customer by name(multiple customer by same Name) so identify by email
    When user click on Customerand Menu
   And click on Customers Menu item
   When user enter first name and last name
   And click on search button
   Then user should found Name along with email in the search table
   And close browser