Feature: Login

/*Scenario: Successful Login with Valid credentials
   Given User Launch Chrome driver
   When user opens URL "https://admin-demo.nopcommerce.com/login"
   And User enters email as "admin@yourstore.com" and password as "admin"
   And Click on Login
   Then page title should be "Dashboard / nopCommerce administration"
   When user click on logout link
   Then page title should be "Your store. Login"
   And close browser
*/
@sanity
Scenario Outline: Login Data Driven
   Given User Launch Chrome driver
   When user opens URL "https://admin-demo.nopcommerce.com/login"
   And User enters email as "<email>" and password as "<password>"
   And Click on Login
   Then page title should be "Dashboard / nopCommerce administration"
   When user click on logout link
   Then page title should be "Your store. Login"
   And close browser
   
   Examples:
   | email | password |
   | admin@yourstore.com | admin |
   | admin@yourstore.com | admin123 |
   
   
   
   
   
   