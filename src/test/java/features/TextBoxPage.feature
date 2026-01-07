Feature: Text Box Page

  Background:
    Given User opens the DemoQA home page
    And User navigates to the Text Box page

  Scenario: Validate that the most important elements are visible
    Then Text Box fields are visible

  Scenario: Validate that the form can be submitted
    When User fills valid data in the Text Box fields
    And User submits the valid data
    Then Submitted data is displayed correctly
