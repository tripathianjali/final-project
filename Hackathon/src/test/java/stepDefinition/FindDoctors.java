package stepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Test.BaseClass;
import Testcase.TC_001Doctor;
import Testcase.TC_002Surgeries;
import Testcase.TC_003Form;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FindDoctors extends BaseClass{
     WebDriver driver;
     TC_001Doctor tc001=new TC_001Doctor();
     TC_002Surgeries tc002=new TC_002Surgeries();
     TC_003Form tc003=new TC_003Form();
  

     @Given("Setup of browser for the given application")
     public void the_location_and_type_of_doctor() throws IOException, InterruptedException
     {
         BaseClass base=new BaseClass();
        base.setup("windows","chrome");
        logger.info("-----Browser setup-----");
       
        }

     @When("Search for the desired location and speciality of Doctor")
     public void Search_for_the_desired_location_and_speciality_of_Doctor() throws InterruptedException 
     {
    	 tc001.click_LocationSearchBox();
    	 logger.info("----Getting location-----");
    	 tc001.Location();
    	 logger.info("----Getting location-----");
    	 tc001.click_SearchDentist();
    	 logger.info("----Searching for doctor-----");
    	 
     } 
    	 @And("add the required filters for searching doctors")
         public void add_the_required_filters_for_searching_doctors() throws InterruptedException 
    	 {
    	 tc001.click_PatientStories();
    	 logger.info("----Applying fitler for Patient Stories-----");
    	 tc001.click_Experience();
    	 logger.info("----Applying fitler for Experience-----");
    	 tc001.click_ToApplyFilter();
    	 tc001.select_fees();
    	 logger.info("----Applying fitler for Fees-----");
    	 tc001.click_ToApplyFilter();
    	 tc001.select_availability();
    	 logger.info("----Applying fitler for availability-----");
    	
     }

     @Then("capture the details of first {int} doctors")
     public void capture_the_details_of_first_doctors(Integer int1) throws IOException {
    	 tc001.getDoctordetails();
    	 logger.info("----Getting first 5 Doctor details -----");
     }
     
 	

 	@When("the user is on Surgery Page and the list of types of Surgeries are displayed")
 	public void the_user_is_on_Surgery_Page_and_the_list_of_types_of_Surgeries_are_displayed() throws InterruptedException {
 	   tc002.PopularSurgery();
 	  logger.info("----Searching for Popular Surgery-----");
 	}

 	@Then("capture the list of Popular Surgeries in excel")
 	public void capture_the_list_of_popular_surgeries_in_excel()
 	{
 	   tc002.writeData();
 	  logger.info("----Writing list in Excek-----");
 	}
 	

 	@And("all the details of form with invalid email")
 	public void all_the_details_of_form_with_invalid_email() throws InterruptedException 
 	{
 	       tc003.Schedule_DemoForm();
 	       tc003.get_Name();
 	       tc003.get_invalidEmail();
 	      logger.info("---Filling form for Scheduling a demo-----");
 	       tc003.get_OrganizationSize();
 	       tc003.get_IntrestedIn();
 	      logger.info("----Selecting options from dropdown-----");
 	}

 	@When("the email is invalid")
 	public void the_email_is_invalid() throws InterruptedException 
 	{
 	   tc003.schedule_Demo();
 	  logger.info("----Entering invalid Emaiil-----");
 	}

 	@Then("validate if Taking a demo button is disabled")
 	public void validate_if_taking_a_demo_button_is_disabled() throws InterruptedException 
 	{
 	    tc003.get_ValidEmail();
 	 	  logger.info("----Entering Valid Emaiil-----");
 	}

 	@And("if email is valid capture ThankYou")
 	public void if_email_is_valid_capture_thank_you() throws InterruptedException
 	{
 		tc003.get_Thankyou();
 	 	  logger.info("----Capturing Thank You message----");
 		
 	}

}
