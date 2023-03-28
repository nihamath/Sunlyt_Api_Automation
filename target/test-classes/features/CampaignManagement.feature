
Feature: Test the campaign management APIs
  
  Scenario Outline: Verify that the get campaign list api is working for  <role> role
    Given Get the access token as "<role>" user
    When Admin call the campaign list api
    Then Verify the response status code is <status>
  
  Examples:
  | role           			| status|
  | Super Admin    			| 200   |
  | Campaign Admin 			| 200   |
  | Advertisement Admin | 403   |
  | User Admin 					| 403   |
  | Feedback Admin 			| 403   |
 	| Support Admin 			| 403   |
 	
 	
 	Scenario Outline: Verify that the create admin api is working for  <role> role
    Given Get the access token as "<role>" user
    When Admin create a new campaign by calling create campaign api
    Then Verify the response status code is <status>
  
  Examples:
  | role           			| status|
  | Super Admin    			| 200   |
  | Campaign Admin 			| 200   |
  | Advertisement Admin | 403   |
  | User Admin 					| 403   |
  | Feedback Admin 			| 403   |
 	| Support Admin 			| 403   |
 	
 	
 	 	Scenario Outline: Verify that the edit campaign api is working for  <role> role
    Given Get the access token as "<role>" user
    When Admin call the campaign list api
    And Get the campaign id of the newly create campaign
    When Admin call the update campaign api
    Then Verify the response status code is <status>
  
  Examples:
  | role           			| status|
  | Super Admin    			| 200   |
  | Campaign Admin 			| 200   |
  | Advertisement Admin | 403   |
  | User Admin 					| 403   |
  | Feedback Admin 			| 403   |
 	| Support Admin 			| 403   |
 	
 	
 	Scenario Outline: Verify that the  campaign live api is working for  <role> role
    Given Get the access token as "<role>" user
    When Admin call the campaign list api
    And Get the campaign id of the newly create campaign
    When Admin call the campaign live api
    Then Verify the response status code is <status>
  
  Examples:
  | role           			| status|
  | Super Admin    			| 200   |
  | Campaign Admin 			| 200   |
  | Advertisement Admin | 403   |
  | User Admin 					| 403   |
  | Feedback Admin 			| 403   |
 	| Support Admin 			| 403   |
 	

  
  