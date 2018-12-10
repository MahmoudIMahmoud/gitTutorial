package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks {

	@Before
	public void setup(){

		System.out.println("setup procedure ...");
	}
	
	@After
	public void teardown(Scenario scenario){
		System.out.println("teardown procedure ...");
		System.currentTimeMillis();
		if(scenario.isFailed())
			System.out.println(System.currentTimeMillis()+" The scenario "+scenario.getName()+" and id of "+scenario.getId()+" Failed :(");
		else
			System.out.println(System.currentTimeMillis()+" The scenario "+scenario.getName()+" and id of "+scenario.getId()+" Passed (:");
	}
}
