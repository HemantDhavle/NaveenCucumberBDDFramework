Feature: Account page feature

Background: 
Given user already logged into the application
|username|password|
|dhavlehemant607@gmail.com|Automation@123|


Scenario: Account page title
Given user is on Account page
When User gets the title of the page
Then Page title should be "My account - My Store"

Scenario: Account section count
Given user is on Account page
When user gets the accounts section
|MY ACCOUNT|
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
|Home|
Then account section count should be 6