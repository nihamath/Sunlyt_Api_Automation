package stepDefinition;

import java.io.FileNotFoundException;

import apiPayloads.SettingsPayload;
import apiPayloads.TipsPayload;
import io.cucumber.java.en.When;
import utils.ApplicationApi;
import utils.BaseClass;

public class TipsApiSteps extends BaseClass {
	
	
	@When("Admin call the tipsPayout list api")
	public void admin_call_the_tipsPayout_list_api() throws FileNotFoundException {
		 res = ApplicationApi.get("/admin/redeem_tip/?page=1&page_size=10",token);
		
	}
	
	@When("Admin call the Payout tips api")
	public void admin_call_the_Payout_tips_api() throws FileNotFoundException {
		 res = ApplicationApi.post("/admin/redeem_tip/",token,TipsPayload.getPayoutTipsPaylaod());
		
	}
	
	
}
