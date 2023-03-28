package stepDefinition;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;

import apiPayloads.campaignPayload;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import utils.ApplicationApi;
import utils.BaseClass;
import utils.utility;


public class CampaignSteps extends BaseClass {
	
	int campaign_ID;
	
	@When("Admin call the campaign list api")
	public void admin_call_the_campaign_list_api() throws FileNotFoundException {
		 res = ApplicationApi.get("/admin/campaign/?page=1&page_size=10",token);
		
	}
	
	
	@When("Admin create a new campaign by calling create campaign api")
	public void Admin_create_a_new_campaign_by_calling_create_campaign_api() throws FileNotFoundException {

		RequestSpecification addCampaignnSpec= new RequestSpecBuilder().setBaseUri("https://sunlytcrowdfunding-qa.qburst.build/api/v1/admin/").addHeader("Authorization", token).build();
		
		RequestSpecification reqaddCampaign=given().log().all().spec(addCampaignnSpec).param("title", utility.setCampaignTitle()).param("description", "<p>dass</p>").param("criteria_for_claim", "<p>dass</p>").
				param("start_date","2022-11-13 00:00:00").param("end_date","2022-11-30 00:00:00").param("attachment_type", 1).param("category", 10).multiPart("image",new File("C:\\Users\\Nihamathulla\\Desktop\\campaign\\OIP (1).jpg"));
		
		
		res=reqaddCampaign.when().post("campaign/").then().extract().response();
		/*
		JsonPath js = new JsonPath(res.asString());
		campaign_ID=js.getInt("entity_id");
		System.out.println(campaign_ID);*/
		
	}
	
	
	@And("Get the campaign id of the newly create campaign")
	public void Get_the_campaign_id_of_the_newly_create_campaign() throws FileNotFoundException {
		JsonPath js = new JsonPath(res.asString());
		if(js.get("data.campaign_data.campaign_list[0].id") != null) {
			campaign_ID=js.get("data.campaign_data.campaign_list[0].id");
		}
		
		
	}
	
	@When("Admin call the update campaign api")
	public void Admin_call_the_update_campaign_api() throws FileNotFoundException {

		RequestSpecification addCampaignnSpec= new RequestSpecBuilder().setBaseUri("https://sunlytcrowdfunding-qa.qburst.build/api/v1/admin/").addHeader("Authorization", token).build();
		
		RequestSpecification reqaddCampaign=given().log().all().spec(addCampaignnSpec).param("title", utility.setCampaignTitle()).param("description", "<p>dass</p>").param("criteria_for_claim", "<p>dass</p>").
				param("start_date","2022-11-13 00:00:00").param("end_date","2022-11-30 00:00:00").param("attachment_type", 1).param("category", 10).param("campaign_id", campaign_ID).multiPart("image",new File("C:\\Users\\Nihamathulla\\Desktop\\campaign\\OIP (1).jpg"));
		
		
		res=reqaddCampaign.when().post("campaign/").then().extract().response();
	
		
	}
	
	
	@When("Admin call the campaign live api")
	public void admin_call_the_campaign_live_api() throws FileNotFoundException {
		 res = ApplicationApi.post("/admin/campaign_status/",token,campaignPayload.getLiveCampaignPayload(campaign_ID));
		
	}
	
	

}
