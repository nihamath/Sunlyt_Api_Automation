package stepDefinition;

import java.io.FileNotFoundException;

import io.cucumber.java.en.When;
import utils.ApplicationApi;
import utils.BaseClass;

public class PaymentApiSteps extends BaseClass {
	
	@When("Admin call the payment list api")
	public void admin_call_the_admin_user_list_api() throws FileNotFoundException {
		 res = ApplicationApi.get("/admin/donation?page=1&page_size=10",token);
		
	}

}
