package stepDefinition;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Assert;

import apiPayloads.feedbackPayload;
import apiPayloads.loginPayload;
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
import utils.specBuilder;






public class feedbackSteps extends BaseClass{
	
	
	int feedbackId;
	
	@Given("Get the access token as {string} user")
	public void get_the_access_token_as_user(String role) {
		
		token= "Bearer "+utils.tokenManager.getToken(role);
	    
	}

	@When("Admin call the feedback_listing_api with get http request")
	public void admin_call_the_feedback_listing_api_with_get_http_request() throws FileNotFoundException {
		
		 res = ApplicationApi.get("/admin/contact_us/?page=1&page_size=10&status=4",token);
		
	   
	}

	@Then("Verify the response status code is {int}")
	public void verify_the_response_status_code_is(int int1) {
	
		Assert.assertEquals(res.statusCode(), int1);
		
	    
	}
	
 
	@And("Get the feedback ID of the latest feedback")
	public void Get_the_feedback_ID_of_the_latest_feedback() {
		JsonPath js = new JsonPath(res.asString());
		if(js.get("data.contact_us_data.contact_us_list[0].id") != null) {
			feedbackId=js.get("data.contact_us_data.contact_us_list[0].id");
		}
		System.out.println(feedbackId);
		
		
		
	}
	
	@When("Admin call the update feedback api")
	public void admin_call_the_update_feedback_api() throws FileNotFoundException {
		System.out.println(feedbackPayload.getFeedfbackPayload(feedbackId));
		
		 res = ApplicationApi.post("/admin/contact_us/",token,feedbackPayload.getFeedfbackPayload(feedbackId));
		
	   
	}
	
	
	@And("User call the submit feedback api")
	public void user_call_the_submit_feedback_api() throws FileNotFoundException {
		
		
		RequestSpecification feedbackSpec= new RequestSpecBuilder().setBaseUri("https://sunlytcrowdfunding-qa.qburst.build/api/v1/").addHeader("Authorization", token).build();
		
		RequestSpecification reqfeedbackSpec=given().log().all().spec(feedbackSpec).param("contact_category", 18).param("message", "test")
				.param("email", "nihamathulla@qburst.com").multiPart("attachment",new File("C:\\Users\\Nihamathulla\\Desktop\\campaign\\OIP (1).jpg"));
		
		 res=reqfeedbackSpec.when().post("user/contact_us/").then().log().all().extract().response();
		
		
	   
	}
	
	

}
