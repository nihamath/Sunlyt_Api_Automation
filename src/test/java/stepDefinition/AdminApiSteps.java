package stepDefinition;

import java.io.FileNotFoundException;

import apiPayloads.AdminPayload;
import apiPayloads.TipsPayload;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import utils.ApplicationApi;
import utils.BaseClass;

public class AdminApiSteps extends BaseClass {
	
	int userID;
	
	@When("Admin call the admin user list api")
	public void admin_call_the_admin_user_list_api() throws FileNotFoundException {
		 res = ApplicationApi.get("/admin/admin-users/?page=1&page_size=10",token);
		
	}
	
	@When("Admin call the create admin api")
	public void admin_call_the_create_admin_api() throws FileNotFoundException {
		res = ApplicationApi.post("/admin/admin-users/",token,AdminPayload.getCreateAdminPayload());
		
	}
	
	@When("Admin call the serach admin user api")
	public void admin_call_the_search_admin_user_api() throws FileNotFoundException {
		res = ApplicationApi.get("/admin/admin-users/?page=1&page_size=10&search_key=APInihamathulla6698",token);
		
	}
	
	@And("Get the userID of the admin user")
	public void get_the_userID_of_the_admin_user() throws FileNotFoundException {
		JsonPath js = new JsonPath(res.asString());
		if(js.get("data.user_data.user_list[0].id") != null) {
			userID=js.get("data.user_data.user_list[0].id");
		}
		System.out.println(userID);
	}
	
	@When("Admin call the update admin user api")
	public void admin_call_the_update_admin_user_api() throws FileNotFoundException {
		res = ApplicationApi.put("/admin/admin-users/edit",token,AdminPayload.updateAdminPayload());
		
	}
	
	@When("Admin call the deactivate admin user api")
	public void admin_call_the_deactivate_admin_user_api() throws FileNotFoundException {
		res = ApplicationApi.post("/admin/admin-users/edit",token,AdminPayload.deactivateAdminPayload(userID));
		
	}
	
	@When("Admin call the activate admin user api")
	public void admin_call_the_activate_admin_user_api() throws FileNotFoundException {
		res = ApplicationApi.post("/admin/admin-users/edit",token,AdminPayload.activateAdminPayload(userID));
		
	}
	
	
	

}
