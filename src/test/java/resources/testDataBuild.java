package resources;
import java.util.ArrayList;
import java.util.List;

import pojo.PayloadPojo;
import pojo.location;

public class testDataBuild {

	public PayloadPojo addPlacePayload() {
		// Return object of PayloadPojo once all values are set
		PayloadPojo addPlacejson = new PayloadPojo();

		addPlacejson.setAccuracy(50);
		addPlacejson.setAddress("29, side layout, cohen 09");
		addPlacejson.setLanguage("French-IN");
		addPlacejson.setPhone_number("\"(+91) 983 893 3937");
		addPlacejson.setName("Frontline house");

		// setting type which is list we need to create a list object first
		List<String> typelist = new ArrayList<String>();
		typelist.add("shoe park");
		typelist.add("shop");
		addPlacejson.setTypes(typelist);
		// setting location which is another class we need to create a object of
		// location

		location loc = new location();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		addPlacejson.setLocation(loc);
		return addPlacejson;

	}

}
