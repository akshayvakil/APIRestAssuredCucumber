package stepDefinition;

import java.io.IOException;

import io.cucumber.java.Before;

/*
 * Object of Step definition  file is created as we need to use methods from it
 * No need to rewrite code.
 * 
 */



public class TestHooks {
	
	
	
	//Before is coming form cucumber.java package and not junit
	//Below line means Before calling TCs in DeletePlace preReqForDeleteAPImehtod() should be executed
	//Before Delete add place should happen so using StepDeiniate write a code here.
	@Before("@DeletePlace")
	public void preReqForDeleteAPImehtod() throws IOException
	{
		StepDefinationFile StepDefObject= new StepDefinationFile(); //Object of Step definition  file is created as we need to use methods from it
		if (StepDefinationFile.CreatedplaceID==null) // run only when varaible is null
		//Other way to use CreatedPlaceID variable is "StepDefObject.CreatedplaceID==null"
	 //but variable is marked as static so classname.varaible name to be used
		
		{
			//Write a code to add place ID
		
		StepDefObject.add_place_payoad("Akshay","French");  //This method create request specification 		
		//NOTE WHY addPlacePayload is not used add_place_payoad is used both are different
		//add_place_payoad is method in stepDefFile
		//addPlacePayload is method in testDataBuildDataDriven pojo creation
		
		StepDefObject.user_calls_with_http_request1("AddPlaceAPI", "POST"); // Call Add Place API
		
		StepDefObject.verify_created_place_id_to_using("Akshay", "GetPlaceAPI"); // verify and store place ID
		
		}
		
		
		
	}
	
	

}
