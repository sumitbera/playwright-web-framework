#Author: sumit@socar.my

Feature: This feature will helps user login on gearbox

  Background: Launch gearbox web app
    Given I launch gearbox web app

  @GB
  Scenario Outline: Successful login on gearbox
    Given I'm on login screen
    When I enter valid "<email id>" and "<password>"
    And I click on login button
    Then I should be logged in successfully

    Examples:
      | email id            | password     |
      | sumit_test@socar.my | Password123! |