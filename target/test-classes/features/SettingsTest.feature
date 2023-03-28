
Feature: Validate the settings configuration api

   Scenario Outline: Verify that the settings configuratiom api is working for  <role> role
    Given Get the access token as "<role>" user
    When Admin call the get settings api
    Then Verify the response status code is <status>
  
  Examples:
  | role           			| status|
  | Super Admin    			| 200   |
  | Campaign Admin 			| 403   |
  | Advertisement Admin | 403   |
  | User Admin 					| 403   |
  | Feedback Admin 			| 403   |
 	| Support Admin 			| 403   |
  
  
   Scenario Outline: Verify that the update settings configuratiom api is working for  <role> role
    Given Get the access token as "<role>" user
    When Admin call the update settings api
    Then Verify the response status code is <status>
  
  Examples:
  | role           			| status|
  | Super Admin    			| 200   |
  | Campaign Admin 			| 403   |
  | Advertisement Admin | 403   |
  | User Admin 					| 403   |
  | Feedback Admin 			| 403   |
 	| Support Admin 			| 403   |