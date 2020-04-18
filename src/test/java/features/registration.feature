Feature: Registration testing

  Scenario: 1. Registration processing
    Given Select Auth Page is opened
    When On SignIn page click on button Create an Account
    And Execute registration with 'Firs name' Test, 'Last name' Test, 'Email' @gmail.com, 'password' dmss111278DAP***
    And On Registration page click on button Create Account
    Then Yourdetails Page is opened