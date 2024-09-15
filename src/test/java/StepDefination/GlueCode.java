package StepDefination;

import PageObject_File.BaseClass;
import PageObject_File.googlePage;
import Utilitiy.CommonMethod;
import Utilitiy.Step_Details;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GlueCode {
	private CommonMethod obj;
	private BaseClass obj1;
	public  googlePage gpobj;
	public GlueCode(BaseClass obj1) throws Throwable {
		this.obj1=obj1;
		obj=new CommonMethod(obj1);
		gpobj=new googlePage(obj1);
	}
	@Before
	public void intializeScenario(Scenario scenario) {
		obj1.initialize_scenario(scenario);
	}
	@Given("User is launching browser")
	public void user_is_launching_browser() throws Throwable {
		BaseClass.extent_test_obj = BaseClass.extent.createTest(BaseClass.scenario.getName());
	    obj.LaunchDriver();
	}

	@When("Browser launch successfully enter the URL.")
	public void enter_the_URL() throws Throwable {
		String step_name=Step_Details.stepName;
		System.out.println(step_name);
		obj.assertion_method(step_name, gpobj.enterurl());
		
	}

	@Then("Search keyword {string}")
	public void search_keyword(String string) throws Throwable {
		 //gpobj.searchKeyword();
		obj.assertion_method(Step_Details.stepName, gpobj.searchKeyword());
	}

	@Then("Display the result")
	public void display_the_result() {
	    
	}

	@Then("Close the browser")
	public void close_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}




}
