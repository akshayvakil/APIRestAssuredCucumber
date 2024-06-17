package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	RequestSpecification reqeustspecBuilder;
	
	public RequestSpecification reqspecfication() throws IOException
	
	{
		//Log filters are used with Streams
		//logs will be written in a file 
		//Common things are included included in this page.
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		reqeustspecBuilder= new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURI")).addQueryParam("key", "qaclick123")
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
	
	public String getGlobalValue(String key) throws IOException
	{
		Properties properties = new Properties();
		FileInputStream propfile=new FileInputStream("src/test/resources/global.properties");
		properties.load(propfile);
		return properties.getProperty(key);
		
		
	}

}
