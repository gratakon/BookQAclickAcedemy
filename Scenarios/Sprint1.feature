Feature: Feature to validate info and phone links 
Description: This is Sprint1 Tests
		
@SmokeTestnow 
Scenario Outline: Home page Info link validation 
	Given User Enter "<username>" and "<password>" to Login to QAclick 
	And Verify QAclick Info link is displaying 
	Then Click on profile Image and Logout 
	Then User will close the window 
	Examples: 
		|username|password|
		|kiranguru488@gmail.com|guru@789|
		
@SmokeTestnow 
Scenario Outline: Home page Info link validation 
	Given User Enter "<username>" and "<password>" to Login to QAclick 
	And Verify phone link is displaying 
	Then Click on profile Image and Logout 
	Then User will close the window 
	Examples: 
		|username|password|
		|kiranguru488@gmail.com|guru@789|		

				
				
				
				
				
				
				
				
				
				
				
