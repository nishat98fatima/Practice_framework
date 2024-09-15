Feature: Browser Login and Search Keyword
@Test
Scenario Outline: Launch Broswer
Given User is launching browser
When Browser launch successfully enter the URL. 
Then Search keyword "<Keyword>"
And Display the result
Then Close the browser
Examples:
|Keyword|
|Test_1|