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
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	public static RequestSpecification reqeustspecBuilder; // use single instance for entire exeuction
	
	public RequestSpecification reqspecfication() throws IOException
	{

		
		//Log filters are used with Streams
		//logs will be written in a file 
		//Common things are included included in this page.
		if (reqeustspecBuilder==null) 
			// for multiple datasets of same TCs dataset logs will be override in logging.txt file.
			// to avoid it if logic is added
			// this will ensure reqeustspecBuilder will be generated only once for multiple datasets
		{
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		reqeustspecBuilder= new RequestSpecBuilder().setBaseUri(getGlobalValue("baseURI")).addQueryParam("key", "qaclick123")
		.addFilter(RequestLoggingFilter.logRequestTo(log))
		.addFilter(ResponseLoggingFilter.logResponseTo(log))
		.setContentType(ContentType.JSON).build();
		return reqeustspecBuilder;
		}
		return reqeustspecBuilder;
			
		/*
		 * Code without Log filers
		 * reqeustspecBuilder= new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
		 *.setContentType(ContentType.JSON).build();
		 */
				
		
		
		
	}
	
	public String getGlobalValue(String key) throws IOException
	{
		Properties properties = new Properties();
		FileInputStream propfile=new FileInputStream("src/test/resources/global.properties");
		properties.load(propfile);
		return properties.getProperty(key);
		
		
	}
	
	public String getValueofKeyfromJson(Response response, String key)
	{
		String responsString = response.asString();
		JsonPath responseJson = new JsonPath(responsString);
		String valuefromKey=responseJson.get(key).toString();
		return valuefromKey;
		
	}

}
