Feature: Testing a Happy Path

  Scenario Outline: 1. Select required trim follow the happy path
    Given Select Mustang Mach-e Page is opened
    When Select button for <trim> trim is clicked
    Then Select button for Extended Range Battery - <text> is clicked

    Examples:
      | trim | price   | text                         |
#      | SELECT                  | $43,895 | |
#      | PREMIUM                 | $50,600 | |
#      | CALIFORNIA RT.1 EDITION | $52,400 | |
      | GT   | $60,500 | Extended Range Battery - AWD |