Feature: Check that main tutorial course pages have loaded in TheTestRoom.com

Scenario: To test that the WebDriver Cucmber tutorial main page has loaded
Given I navigate to TheTestRoom.com
When I navigate to "Java Cucumber Tutorial" page
When I navigate to "Java WebDriver Tutorial" page
When I navigate to "Java Cucumber Tutorial" page
Then the page title should be visible