

@Test
  Feature: Registrations
    Scenario: As a user i should be able to register successfully
      Given I am on registration page
      When I enter required filed
      And I click on register button
      Then I able to register successfully
