package StepDefination;

import PageObject_File.BaseClass;
import Utilitiy.CommonMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GlueCode {
	private CommonMethod obj;
	private BaseClass obj1;
	public GlueCode(BaseClass obj1) throws Throwable {
		this.obj1=obj1;
		obj=new CommonMethod(obj1);
	}
	@Given("User is launching browser")
	public void user_is_launching_browser() throws Throwable {
	    obj.LaunchDriver();
	}

	@When("Browser Launch successfully")
	public void browser_launch_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("Search keyword {string}")
	public void search_keyword(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("Display the result")
	public void display_the_result() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("Close the browser")
	public void close_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}




}
