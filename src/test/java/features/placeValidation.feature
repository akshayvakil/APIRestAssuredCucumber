Feature: Validating place's API

Scenario: Verify if place is successfully added using AddPlaceAPI.

  Given Add place payoad
  When user calls "AddPlaceAPI" with post http request
  Then api call got success code 200
  And "status" in response body is "OK" 
  #These are exact values coming from api response which we are validating
  And "scope" in response body is "APP" 
  #These are exact values coming from api response which we are validating

