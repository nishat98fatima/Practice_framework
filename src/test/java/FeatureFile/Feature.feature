Feature: Browser Login and Search Keyword
Scenario Outline: Launch Broswer
Given User is launching browser 
When Browser Launch successfully
Then Search keyword "<Keyword>"
And Display the result
Then Close the browser
Examples:
|Keyword|
|Test_1|