package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	RequestSpecification reqeustspecBuilder;
	
	public RequestSpecification reqspecfication()
	
	{
		//STEP1 Create Object of Request specificationBuilder 
		//Common things are included included in this page.
		reqeustspecBuilder= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
				.setContentType(ContentType.JSON).build();
		
		return reqeustspecBuilder;
		
	}

}
