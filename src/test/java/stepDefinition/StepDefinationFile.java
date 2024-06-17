package stepDefinition;

import static io.restassured.RestAssured.given;
//import static org.testng.Assert.assertEquals;

import java.io.IOException;
import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.Utils;
import resources.testDataBuild;
import resources.testDataBuildDataDriven;


public class StepDefinationFile extends Utils{
	
	//Declare Request specification variables are Global level so that
	//these variables can be used in all methods
	
	RequestSpecification request;
	ResponseSpecification responseBuilder;
	Response response;
	testDataBuildDataDriven addplacepayload2= new testDataBuildDataDriven();
	

@Given("Add place payoad <{string}> <{string}>")
	public void add_place_payoad(String name, String language) throws IOException {


	request = given().spec(reqspecfication()).body(addplacepayload2.addPlacePayload(name,language));

		
    //throw new io.cucumber.java.PendingException();
}
@When("user calls {string} with post http request1")
public void user_calls_with_post_http_request(String string) {
    // Write code here that turns the phrase above into concrete actions
	responseBuilder=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	response=	request.when().post("/maps/api/place/add/json")
			.then().spec(responseBuilder).extract().response();
	//throw new io.cucumber.java.PendingException();
}
@Then("api call got success code1 {int}")
public void api_call_got_success_code(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
	assertEquals(response.getStatusCode(),200);
   
}
@Then("{string} in response body1 is {string}")
public void in_response_body_is(String keyValue, String ExpectedValue) {
	//values for these two parameters will come from feature file
	// e.g. And "status" in response body is "ok"
	//keyValue=status , ExpectedValue=ok
    // Write code here that turns the phrase above into concrete actions
	String responsString= response.asString();
	JsonPath responseJson= new JsonPath(responsString);
	assertEquals(responseJson.get(keyValue).toString(),ExpectedValue);
	
}


}
