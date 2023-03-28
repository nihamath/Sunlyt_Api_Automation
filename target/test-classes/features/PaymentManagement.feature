
Feature: Validating the payment APIs

   Scenario Outline: Verify that the payment list api is working for  <role> role
    Given Get the access token as "<role>" user
    When Admin call the payment list api
    Then Verify the response status code is <status>
  
  Examples:
  | role           			| status|
  | Super Admin    			| 200   |
  | Campaign Admin 			| 200   |
  | Advertisement Admin | 403   |
  | User Admin 					| 403   |
  | Feedback Admin 			| 403   |
 	| Support Admin 			| 403   |
