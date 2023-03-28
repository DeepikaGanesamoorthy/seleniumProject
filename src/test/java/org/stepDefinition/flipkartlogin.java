package org.stepDefinition;
import io.cucumber.datatable.*;

import java.util.List;
import java.util.Map;

import org.base.BaseClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import or.pojoclass.pojo;

public class flipkartlogin extends BaseClass {
	@Given("To launch the browser and maximise the window")
	public void to_launch_the_browser_and_maximise_the_window() {
	    launchBrowser();
	    Windowmaximize();
	}

	@When("To launch the Url of the flip kart application")
	public void to_launch_the_Url_of_the_flip_kart_application() {
	    launchUrl("https://www.flipkart.com/");
	}

	@When("To pass invalid mobile number in mobile number field")
	public void to_pass_invalid_mobile_number_in_mobile_number_field(DataTable d)
	{
		List<List<String>> l = d.asLists();
		pojo p=new pojo();
					
	 Passtext(l.get(1).get(0),p.getEmail() );	
  
	}

	@When("To click the login button")
	public void to_click_the_login_button() {
		pojo p=new pojo();
	    clickBtn(p.getLogin());
	}

	@Then("To close the Browser")
	public void to_close_the_Browser() {
//	   closeEntireBrowser(); 
	}







}
