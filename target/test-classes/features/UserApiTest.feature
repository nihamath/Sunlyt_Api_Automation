
Feature: Validating  the user api

  Scenario: Verify the end to end flow of user registration
    Given User register to the account using the Register api
    Then Verify the response status code is 200
    Given Get the access token as "Super Admin" user
    When Admin search the new user by calling the User listing api
    And Get the details of the latest user
    Then Verify the response status code is 200
    And Verify the user details
    When Admin call the deactivate user api
    Then Verify the response status code is 200
    When Admin call the activate user api 
    Then Verify the response status code is 200
    When Admin call the delete user api
    Then Verify the response status code is 200
    
  Scenario Outline: Verify that the user listing api is working for <role> role
    Given Get the access token as "<role>" user
    And Admin call the User listing api
    Then Verify the response status code is <status>
  
  Examples:
  | role           			| status|
  | Super Admin    			| 200   |
  | Campaign Admin 			| 403   |
  | Advertisement Admin | 403   |
  | User Admin 					| 200   |
  | Feedback Admin 			| 200   |
 	| Support Admin 			| 200   |
  
  
  Scenario Outline: Verify that the update user api is working for <role> role
    Given Get the access token as "<role>" user
    And Admin call the User listing api
    And Get the details of the latest user
    When Admin call the activate user api 
    Then Verify the response status code is <status>
  
  Examples:
  | role           			| status|
  | Super Admin    			| 200   |
  | Campaign Admin 			| 403   |
  | Advertisement Admin | 403   |
  | User Admin 					| 200   |
  | Feedback Admin 			| 403   |
 	| Support Admin 			| 403   |
  
  
    

