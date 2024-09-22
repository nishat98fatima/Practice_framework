package StepDefination;

import org.testng.Assert;

import PageObject_File.BaseClass;
import PageObject_File.apiValidation;
import PageObject_File.googlePage;
import Utilitiy.CommonMethod;
import Utilitiy.Rest_Assured;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class ApiGlueCode {
	private CommonMethod cmn_methods;
	private BaseClass base_class;
   private apiValidation apiValidateobj;

	// public googlePage gpobj;
	public ApiGlueCode(BaseClass base_class) throws Throwable {
		this.base_class = base_class;
		cmn_methods = new CommonMethod(base_class);
		 apiValidateobj=new apiValidation(base_class);
	}

	@Given("User is going to {string}")
	public void user_is_going_to(String keyword) {
		base_class.scenario_keyword = keyword;
	}

	@When("User perform the PostAPI call")
	public void user_perform_the_post_api_call() throws Throwable {
		Assert.assertTrue(apiValidateobj.validateapi());
	}
	@Then("Compare Expected and actual result.")
	public void compareresult()throws Throwable{
		Assert.assertTrue(apiValidateobj.the_comparison_result_should_be_logged_in_the_report());
		
	}
	
	

}
