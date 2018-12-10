package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginSteps {

	@Given("^I navigate to the login page$")
	public void iNavigateToTheLoginPage(){
		System.out.println("I navigate to the login page");
	}
	
	//@And ("^I entere user name \"([a-zA-Z0-9]*)\" and password \"([a-zA-Z0-9]*)\"$")
	@And("I entere a user name (.*) and a password (.*)$")
	public void iEnterUserNameAndPasswordOutLine(String username,String password){
		System.out.println("------------------------");
		System.out.println(String.format("I entere user name as %s and password as %s",username,password));
		System.out.println("----------------------------");
	}
	
	@Then("^I should get an error message (.*)$")
	public void i_should_get_error_message(String message) throws Throwable {
	    System.out.println("I should get error message:"+message);
	}
	
	
	@And ("^I entere user name as \"(.+)\" and password as \"(.+)\"$")
	public void iEnterUserNameAndPassword(String user,String pass){
		System.out.println("------------------------");
		System.out.println(String.format("I entere user name as %s and password as %s",user,pass));
		System.out.println("----------------------------");
	}
	
	
	@And("^I click login button$")
	public void iClickLogin(){
		System.out.println("And I click login button");
	}
	
	@Then("^I should get to dashboard page$")
	public void iShouldGetToDashbordPage(){
		System.out.println("I'm on the db page");
	}
}
