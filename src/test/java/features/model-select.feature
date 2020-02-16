Feature: Testing of Select Mustang Mach-e Model Page

  Scenario: 1. Select Model Page opens successfully
    Given Select Mustang Mach-e Page is opened
    Then Assert Select Model Page is Opened


  Scenario: 2. Validate Elements are present in the body of the page
    Given Select Mustang Mach-e Page is opened
    Then Assert Elements Are Present in the Body

  Scenario: 3. Validate that 4 cards of products are displayed in the body of the page
    Given Select Mustang Mach-e Page is opened
    Then Assert 4 Cards Are Present in the Body

  Scenario: 4. Verify elements in model cards
    Given Select Mustang Mach-e Page is opened
    Then Validate that each card contain all the elements

  Scenario: 5. Verify text in the body of a card
    Given Select Mustang Mach-e Page is opened
    Then Validate that text is present and correct in the body of a card
