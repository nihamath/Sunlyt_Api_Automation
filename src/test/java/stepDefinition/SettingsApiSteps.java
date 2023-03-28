package stepDefinition;

import java.io.FileNotFoundException;

import apiPayloads.SettingsPayload;
import io.cucumber.java.en.When;
import utils.ApplicationApi;
import utils.BaseClass;

public class SettingsApiSteps extends BaseClass {
	
	
	@When("Admin call the get settings api")
	public void admin_call_the_get_settings_api() throws FileNotFoundException {
		 res = ApplicationApi.get("/admin/configuration/",token);
		
	}
	
	@When("Admin call the update settings api")
	public void admin_call_the_update_settings_api() throws FileNotFoundException {
		 res = ApplicationApi.put("/admin/configuration/",token,SettingsPayload.getSettingPayload());
		
	}
	
	
	
	

}
