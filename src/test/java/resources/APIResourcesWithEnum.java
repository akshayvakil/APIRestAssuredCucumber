package resources;

//Enum is special class in java with collection of methods and constants
//We dont have to create object we just need to call APIResourcesWithEnum.ValueOf("AddPlaceAPI")
//Mandatory we need to create one constructor

public enum APIResourcesWithEnum {

	AddPlaceAPI("/maps/api/place/add/json"), // This line is method accepting arguments)
	GetPlaceAPI("maps/api/place/get/json"), 
	DeletePlaceAPI("maps/api/place/delete/json");

	private String resource;

	// As method is accepting arguments enum needs to have constructor with one
	// Constructor is called by ValueOfMethod provided by enum class
	// resource value e.g.AddPlaceAPI will be assigned using resource variable

	APIResourcesWithEnum(String resource) {
		this.resource=resource;
	}

	public String getResourcefromEnumClass() {

		return resource;
	}
}
