Feature: DemoQA Home Page

  Scenario: Open DemoQA home page
    Given I open the DemoQA home page
    Then the page title should be "DEMOQA"

  Scenario: HomePage elements visibility
    Given I open the DemoQA home page
    Then The home page elements should be visible