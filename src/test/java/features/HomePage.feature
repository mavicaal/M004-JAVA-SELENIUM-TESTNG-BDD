Feature: DemoQA Home Page

  Background:
    Given User opens the DemoQA home page

  Scenario: Open DemoQA home page
    Then the page title should be "DEMOQA"

  Scenario: HomePage elements visibility
    Then The home page elements should be visible