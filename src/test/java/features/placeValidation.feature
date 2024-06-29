Feature: Validating place's API

@AddPlace
# Create tags to run only selected Scenarios
Scenario Outline: Verify if place is successfully added using AddPlaceAPI.

  Given Add place payoad "<name>" "<language>"
  # before enum class line was like When user calls "AddPlaceAPI" with post http request1
  When user calls "AddPlaceAPI" with "POST" http request1
  # Enums class has method AddPlaceAPI, this configuration is done in stepdefination using enum constructor "AddPlaceAPI" keyword should match.
  #Inteliggence is added so that instead of AddPlaceAPI another service will also get called e.. GetPlaceAPI
  Then api call got success code1 200
  And "status" in response body1 is "OK" 
  #These are exact values coming from api response which we are validating
  And "scope" in response body1 is "APP" 
  #These are exact values coming from api response which we are validating
  And verify created place id to "<name>" using "GetPlaceAPI"
  
  Examples:
  |name    |language|
  |BBBHouse|English |
  # |BBBHouse|French  | commented in chapter 87 for as dataset is learned no need of datasets

@DeletePlace  
Scenario: Verify delete place functionality
Given DeletePlace Payload 
When user calls "DeletePlaceAPI" with "POST" http request1
Then api call got success code1 200
And "status" in response body1 is "OK" 


 