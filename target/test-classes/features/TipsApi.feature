
Feature: Validate the Tips api

   Scenario Outline: Verify that the tips api is working for  <role> role
    Given Get the access token as "<role>" user
    When Admin call the tipsPayout list api
    Then Verify the response status code is <status>
  
  Examples:
  | role           			| status|
  | Super Admin    			| 200   |
  | Campaign Admin 			| 403   |
  | Advertisement Admin | 403   |
  | User Admin 					| 403   |
  | Feedback Admin 			| 403   |
 	| Support Admin 			| 403   |
  
  
   Scenario Outline: Verify that the payout tips api is working for  <role> role
    Given Get the access token as "<role>" user
    When Admin call the Payout tips api
    Then Verify the response status code is <status>
  
  Examples:
  | role           			| status|
  | Super Admin    			| 200   |
  | Campaign Admin 			| 403   |
  | Advertisement Admin | 403   |
  | User Admin 					| 403   |
  | Feedback Admin 			| 403   |
 	| Support Admin 			| 403   |