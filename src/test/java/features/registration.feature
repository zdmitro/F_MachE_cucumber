Feature: Registration testing

  Scenario: 1. Registration processing
    Given Select Mustang Mach-e Page is opened
    When On SignIn page click on button Create an Account
    And Execute registration with 'Firs name' null, 'Last name' null, 'Email' null, 'password' null
    And On Registration page click on button Create Account