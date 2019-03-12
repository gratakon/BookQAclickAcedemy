Feature: feature to validate Edit page links
Description: This is sprint3 tests

 
@RegressionTest 
Scenario Outline: Edit details page validation
	Given User Enter "<username>" and "<password>" to Login to QAclick
	And Verify QAclick Info link is displaying
	Then click on profile Image and edit profile
	And Verify the Notification Preferences checkbox one is selected
	When User save changes
	And Verify the save changes success message is displayed
	Then User will close the window 
	Examples: 
		|username|password|
		|ratakondavenkateshrgv@gmail.com|guru@777|
		
		
@ABCTest 
Scenario Outline: Edit details page validation
	Given User Enter "<username>" and "<password>" to Login to QAclick
	And Verify QAclick Info link is displaying
	Then click on profile Image and edit profile
	And Verify the Notification Preferences checkbox one is selected
	When User save changes
	And Verify the save changes success message is displayed
	Then User will close the window 
	Examples: 
		|username|password|
		|ratakondavenkateshrgv@gmail.com|guru@789|