Feature: OrangeHRM

	@orangehrm
  Scenario: Verify Login and Home Screen
    Given user is at the login page
    When User enters in UserName
    And User enters in the Password
    And User clicks on Login Button
    Then User is logged in successfully
    Then Verify all Menu options
      | Header      |
      | Admin       |
      | PIM         |
      | Leave       |
      | Time        |
      | Recruitment |
      | My Info     |
      | Performance |
      | Dashboard   |
      | Directory   |
      | Maintanence |
      | Claim       |
      | Buzz        |
