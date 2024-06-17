Feature: Validating place's API

Scenario Outline: Verify if place is successfully added using AddPlaceAPI.

  Given Add place payoad <"name"> <"language">
  When user calls "AddPlaceAPI" with post http request1
  Then api call got success code1 200
  And "status" in response body1 is "OK" 
  #These are exact values coming from api response which we are validating
  And "scope" in response body1 is "APP" 
  #These are exact values coming from api response which we are validating
  
  Examples:
  |name    |language|
  |AAAHouse|English |
  |BBBHouse|French  |
 