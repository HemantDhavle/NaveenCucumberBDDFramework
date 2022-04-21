Feature: Login page feature

Scenario: Login Page Title
Given User is on login page
When User gets the title of the page
Then Page title should be "Login - My Store"

Scenario: Forgot password link
Given User is on login page
Then Forgot your password link should be displayed

Scenario: Login with correct credentials
Given User is on login page
When user enters username "dhavlehemant607@gmail.com"
And user enters password "Automation@123"
And user clicks on login button
Then User gets the title of the page
And Page title should be "My account - My Store"