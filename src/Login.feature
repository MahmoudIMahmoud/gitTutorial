Feature: Login
	@SmokeTest
	Scenario: Login with correct credentials
		Given I navigate to the login page
		And I entere user name as "admin" and password as "demo123"
		And I click login button
		Then I should get to dashboard page


		
	Scenario Outline: Login with incorrect credentials
		Given I navigate to the login page
		And I entere a user name <username> and a password <password>
		And I click login button
		Then I should get an error message <message>
		Examples:
			|username|password|message|
			|admin	 |pass    |Wrong password|
			|wrong   |demo123 |Wrong user|
		