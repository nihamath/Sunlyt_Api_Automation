
Feature: Validate the Admin api

   Scenario Outline: Verify that the get admin list api is working for  <role> role
    Given Get the access token as "<role>" user
    When Admin call the admin user list api
    Then Verify the response status code is <status>
  
  Examples:
  | role           			| status|
  | Super Admin    			| 200   |
  | Campaign Admin 			| 403   |
  | Advertisement Admin | 403   |
  | User Admin 					| 403   |
  | Feedback Admin 			| 403   |
 	| Support Admin 			| 403   |
  

   Scenario Outline: Verify that the create admin  api is working for <role> role
    Given Get the access token as "<role>" user
    When Admin call the create admin api
    Then Verify the response status code is <status>
  
  Examples:
  | role           			| status|
  | Super Admin    			| 200   |
  | Campaign Admin 			| 403   |
  | Advertisement Admin | 403   |
  | User Admin 					| 403   |
  | Feedback Admin 			| 403   |
 	| Support Admin 			| 403   |
  
  
  Scenario Outline: Verify that the update admin  api is working for  <role> role
    Given Get the access token as "<role>" user
    When Admin call the serach admin user api
    And Get the userID of the admin user
    When Admin call the update admin user api
    Then Verify the response status code is <status>
  
  Examples:
  | role           			| status|
  | Super Admin    			| 200   |
  | Campaign Admin 			| 403   |
  | Advertisement Admin | 403   |
  | User Admin 					| 403   |
  | Feedback Admin 			| 403   |
 	| Support Admin 			| 403   |

  
  
  Scenario Outline: Verify that the actiavte and deactivate admin  api is working for  <role> role
    Given Get the access token as "<role>" user
    When Admin call the serach admin user api
    And Get the userID of the admin user
    When Admin call the deactivate admin user api
    Then Verify the response status code is <status>
    When Admin call the deactivate admin user api
    Then Verify the response status code is <status>
  
  Examples:
 	| role           			| status|
  | Super Admin    			| 200   |
  | Campaign Admin 			| 403   |
  | Advertisement Admin | 403   |
  | User Admin 					| 403   |
  | Feedback Admin 			| 403   |
 	| Support Admin 			| 403   |