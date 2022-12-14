Feature: This is to test Login functionality

  Background: Login functionality
    Given User enters the website through URL https://cloudstudio.visionet.com/Login

  @Invalid_Login
  Scenario Outline: Invalid Login to the Application
    When User fills the Username and Password from given "<Username>" and "<Password>"
    And User clicks on Login button
    Examples: 
      | Username | Password     |
      | abcd1234 | Vlr4Cmp@2021 |

  @Login
  Scenario Outline: Valid Login to the Application
    When User fills the Username and Password from given "<Username>" and "<Password>"
    And User clicks on Login button
    Examples: 
      | Username           | Password     |
      | Reader-VLR-AtClose | Vlr4Cmp@2021 |
