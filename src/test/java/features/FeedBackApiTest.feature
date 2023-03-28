
Feature: Validating the user feedback APIs



  Scenario Outline: Verify that the feedback listing api is working for  <role> role
    Given Get the access token as "<role>" user
    When Admin call the feedback_listing_api with get http request
    Then Verify the response status code is <status>
  
  Examples:
  | role           			| status|
  | Super Admin    			| 200   |
  | Campaign Admin 			| 403   |
  | Advertisement Admin | 403   |
  | User Admin 					| 403   |
  | Feedback Admin 			| 200   |
 	| Support Admin 			| 403   |



	Scenario Outline: Verify that the update feedback  api is working for  <role> role
    Given Get the access token as "<role>" user
    When Admin call the feedback_listing_api with get http request
    And Get the feedback ID of the latest feedback
    When Admin call the update feedback api
    Then Verify the response status code is <status>
  
  Examples:
  | role           			| status|
  | Super Admin    			| 200   |
  | Campaign Admin 			| 403   |
  | Advertisement Admin | 403   |
  | User Admin 					| 403   |
  | Feedback Admin 			| 200   |
 	| Support Admin 			| 403   |
  
  
  Scenario: Verify the end to end flow of the user feedback process
  
  	Given Get the access token as "Web User" user 
  	And User call the submit feedback api
  	Given Get the access token as "Super Admin" user
  	When Admin call the feedback_listing_api with get http request
    And Get the feedback ID of the latest feedback
  	When Admin call the update feedback api
    Then Verify the response status code is 200



 