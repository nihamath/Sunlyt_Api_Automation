Feature: Validate the comments api

   Scenario Outline: Verify that the reported comment list api is working for <role> role
    Given Get the access token as "<role>" user
    When Admin call the reportedcomment list api
    Then Verify the response status code is <status>
  
  Examples:
  | role           			| status|
  | Super Admin    			| 200   |
  | Campaign Admin 			| 403   |
  | Advertisement Admin | 403   |
  | User Admin 					| 403   |
  | Feedback Admin 			| 200   |
 	| Support Admin 			| 403   |
 	
 	
 	Scenario Outline: Verify that the update reported comment  api is working for  <role> role
    Given Get the access token as "<role>" user
    When Admin call the reportedcomment list api
    And Get the commentID of the reported comment
    When Admin call the update reported comment api
    Then Verify the response status code is <status>
  
  Examples:
  | role           			| status|
  | Super Admin    			| 200   |
  | Campaign Admin 			| 403   |
  | Advertisement Admin | 403   |
  | User Admin 					| 403   |
  | Feedback Admin 			| 200   |
 	| Support Admin 			| 403   |
 	
 	
 	
 	