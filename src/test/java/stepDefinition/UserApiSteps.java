package stepDefinition;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;

import org.junit.Assert;

import apiPayloads.UserPayload;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ApplicationApi;
import utils.BaseClass;


public class UserApiSteps extends BaseClass{
	
	
	String actual_name;
	String expected_name;
	int user_id;
	
	@Given("User register to the account using the Register api")
	public void user_register_to_the_account_using_the_register_api() {
		
		RequestSpecification regUserSpec= new RequestSpecBuilder().setBaseUri("https://sunlytcrowdfunding-qa.qburst.build/api/v1/").setContentType(ContentType.JSON).build();
		
		RequestSpecification reqUserReg=given().log().all().spec(regUserSpec).body(UserPayload.getRegistrationPayload());
		
		 res=reqUserReg.when().post("user/register").then().log().all().statusCode(200).extract().response();
		
		 JsonPath js = new JsonPath(res.asString());
		 expected_name=js.get("data.first_name");
		 
	    
	}
	
	@When("Admin search the new user by calling the User listing api")
	public void admin_search_the_new_user_by_calling_call_the_user_listing_api() throws FileNotFoundException {
		 res = ApplicationApi.get("/admin/users/?page=1&page_size=10&search_key="+expected_name,token);
		 /*JsonPath js = new JsonPath(res.asString());
		 actual_name=js.get("data.user_data.user_list[0].first_name");
		 user_id=js.get("data.user_data.user_list[0].id");*/
	 
	}

	@When("Admin call the User listing api")
	public void admin_call_the_user_listing_api() throws FileNotFoundException {
		 res = ApplicationApi.get("/admin/users/?page=1&page_size=10",token);
		 /*JsonPath js = new JsonPath(res.asString());
		 actual_name=js.get("data.user_data.user_list[0].first_name");
		 user_id=js.get("data.user_data.user_list[0].id");*/
	 
	}
	
	@And("Get the details of the latest user")
	public void get_the_details_of_the_latest_user() throws FileNotFoundException {
		 JsonPath js = new JsonPath(res.asString());
		if(js.get("data.user_data.user_list[0].id") != null) {
			 user_id=js.get("data.user_data.user_list[0].id");
			 actual_name=js.get("data.user_data.user_list[0].first_name");
		}
		
		
	 
	}
	
	

	@Then("Verify the user details")
	public void verify_the_user_details() {
		
		Assert.assertEquals(actual_name, expected_name );
	}
	
	@When("Admin call the deactivate user api")
	public void admin_call_the_deactivate_user_api() throws FileNotFoundException {
		 res = ApplicationApi.post("/admin/users/",token,UserPayload.getDeactivateUser(user_id));
		 
	 
	}
	
	@When("Admin call the activate user api")
	public void admin_call_the_activate_user_api() throws FileNotFoundException {
		 res = ApplicationApi.post("/admin/users/",token,UserPayload.getActivateUser(user_id));
		 
	 
	}
	

	@When("Admin call the delete user api")
	public void admin_call_the_delete_user_api() throws FileNotFoundException {
		 res = ApplicationApi.post("/admin/users/",token,UserPayload.getDeleteUserPayload(user_id));
		 
	 
	}


	    
	    
	

}
