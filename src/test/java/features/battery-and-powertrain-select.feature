Feature: Testing of Battery and Powertrain page for Mustang Mach-e

  Scenario Outline: 1. Select "Select" trim and validate that Battery and Powertrain page opens.
    Given Select Mustang Mach-e Page is opened
    When Select button for <trim> trim is clicked
    Then Validate that Battery and Powertrain Page is Opened with price <price>

    Examples:
      | trim                    | price   |
      | SELECT                  | $43,895 |
      | PREMIUM                 | $50,600 |
      | CALIFORNIA RT.1 EDITION | $52,400 |
      | GT                      | $60,500 |


  Scenario: 2. Select "Premium" trim and validate that Battery and Powertrain page opens.
    Given Select Mustang Mach-e Page is opened
    When Select button for Premium Trim is clicked
    Then Validate that Battery and Powertrain Page is Opened for Premium trim