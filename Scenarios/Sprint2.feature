Feature: Feature to validate course links
Description: This is sprint2 tests

 
@RegressionTest
Scenario Outline: Mycourse link validation 
	Given User Enter "<username>" and "<password>" to Login to QAclick 
	And Verify My courses link is displaying 
	Then Click on profile Image and Logout 
	Then User will close the window 
	Examples: 
		|username|password|		
		|kiranguru488@gmail.com|guru@789|
		
@SmokeTest
Scenario Outline: All courses link validation 
	Given User Enter "<username>" and "<password>" to Login to QAclick 
	And Verify all courses link is displaying 
	Then Click on profile Image and Logout 
	Then User will close the window 
	Examples: 
		|username|password|
		|kiranguru488@gmail.com|guru@789|