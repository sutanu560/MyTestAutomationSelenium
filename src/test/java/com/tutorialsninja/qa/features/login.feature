Feature: LoginFunctionality of TutorialNinja Page

  Scenario: Login with invalid credentials
    Given User navigates to login page
    When User enters invalid email address into email field
    And User enters invalid password "1234567890" into password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch

  Scenario: User creates an account only with mandatory fields
    Given User navigates to Register Account page
    When User enters the details into below fields
      | firstName | Arun       |
      | lastName  | Motoori    |
      | telephone | 1234567890 |
      | password  |      12345 |
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get created successfully

  Scenario Outline: Login with valid credentials
    Given User navigates to login page
    When User enters valid email address <username> into email field
    And User enters valid password <password> into password field
    And User clicks on Login button
    Then User should get successfully logged in

    Examples: 
      | username               | password |
      | amotooricap1@gmail.com |    12345 |
      | amotooricap2@gmail.com |    12345 |
      | amotooricap3@gmail.com |    12345 |
