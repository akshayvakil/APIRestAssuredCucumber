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
import resources.APIResourcesWithEnum;
import resources.Utils;
import resources.testDataBuild;
import resources.testDataBuildDataDriven;

public class StepDefinationFile extends Utils {

	// Declare Request specification variables are Global level so that
	// these variables can be used in all methods

	RequestSpecification request;
	ResponseSpecification responseBuilder;
	Response response;
	testDataBuildDataDriven payloadjsondata = new testDataBuildDataDriven();
	static String CreatedplaceID; // If this varaible is not made static it can NOT be used in multiple variables nullpointer exception will be received
	JsonPath responseJson;

	//@Given("Add place payoad <{string}> <{string}>")
	@Given("Add place payoad {string} {string}")
	public void add_place_payoad(String name, String language) throws IOException {

		request = given().spec(reqspecfication()).body(payloadjsondata.addPlacePayload(name, language));

		// throw new io.cucumber.java.PendingException();
	}

	@When("user calls {string} with {string} http request1")
	public void user_calls_with_http_request1(String resource, String httpReqMethodType) {
		// Write code here that turns the phrase above into concrete actions
		responseBuilder = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		/// Usimg enum class we are calling /maps/api/place/add/json resource
		// Without enum harcoded value was "response=
		/// request.when().post("/maps/api/place/add/json")"

		APIResourcesWithEnum enumReferenceVaraibleResource = APIResourcesWithEnum.valueOf(resource);
		String getAPIresourceFromEnum = enumReferenceVaraibleResource.getResourcefromEnumClass();
		
		//Without Enum response = request.when().post("/maps/api/place/add/json").then().spec(responseBuilder).extract().response();
	if(httpReqMethodType.equalsIgnoreCase("POST"))
		response = request.when().post(getAPIresourceFromEnum);
	else if(httpReqMethodType.equalsIgnoreCase("GET"))
		response = request.when().get(getAPIresourceFromEnum);
		
		// throw new io.cucumber.java.PendingException();
	}

	@Then("api call got success code1 {int}")
	public void api_call_got_success_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(), 200);

	}

	@Then("{string} in response body1 is {string}")
	public void in_response_body_is(String keyValue, String ExpectedValue) {
		// Note1: values for these two parameters will come from feature file
		// e.g. And "status" in response body is "ok"
		// keyValue=status , ExpectedValue=ok
		// Write code here that turns the phrase above into concrete actions
		
		//Note2:Everytime we will have to call JsonPath in all method instead lets create a method 
		// 
		//String responsString = response.asString();
		//JsonPath responseJson = new JsonPath(responsString);		
		//assertEquals(responseJson.get(keyValue).toString(), ExpectedValue);
	
		assertEquals(getValueofKeyfromJson(response,keyValue),ExpectedValue);
	}
	
	//@Then("verify created place id to <{string}> using {string}") when incorrect quotes are given in feature file
	@Then("verify created place id to {string} using {string}")
	
	public void verify_created_place_id_to_using(String expectedName, String resource) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	   //get aPI call before that prepare request spec similar to add place in Given method line 36
		CreatedplaceID=getValueofKeyfromJson(response, "place_id");
		request = given().spec(reqspecfication()).queryParam("place_id", CreatedplaceID);
		//Note:1 Now we need to call getAPI service 
		//We can call it using methond in when ,
		user_calls_with_http_request1(resource,"GET");
		String CreatedNamethorughservice=getValueofKeyfromJson(response, "name");
		//System.out.println("value coming from response is -> "+CreatedNamethorughservice);
		assertEquals(CreatedNamethorughservice,expectedName);
	}
	
	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
		//Notes: Spec Builder is already used in Given MEthod we just need to change body
		// one way to use direct json with escape sequence as follows
		//https://www.freeformatter.com/json-escape.html#before-output
		//request = given().spec(reqspecfication()).body(  "{\r\n  \"place_id\": \"9a07e54cf8970b87b25d46a5e3648c5d\"\r\n  }");
		request = given().spec(reqspecfication()).body(payloadjsondata.deletePayloadjson(CreatedplaceID));
		
	}

}
