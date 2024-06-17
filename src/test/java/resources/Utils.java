package resources;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	RequestSpecification reqeustspecBuilder;
	
	public RequestSpecification reqspecfication() throws FileNotFoundException
	
	{
		//Log filters are used with Streams
		//logs will be written in a file 
		//Common things are included included in this page.
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		reqeustspecBuilder= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
		.addFilter(RequestLoggingFilter.logRequestTo(log))
		.addFilter(ResponseLoggingFilter.logResponseTo(log))
		.setContentType(ContentType.JSON).build();
		
		
		/*
		 * Code without Log filers
		 * reqeustspecBuilder= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
		 *.setContentType(ContentType.JSON).build();
		 */
				
		
		return reqeustspecBuilder;
		
	}

}
