package stepDefinition;

import java.io.FileNotFoundException;

import apiPayloads.ReportedCommentPayload;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import utils.ApplicationApi;
import utils.BaseClass;

public class CommentsApiSteps extends BaseClass {
	int commentId;
	
	@When("Admin call the reportedcomment list api")
	public void admin_call_the_reportedcomment_list_api() throws FileNotFoundException {
		 res = ApplicationApi.get("/admin/comment_report/?page=1&page_size=10&status=1",token);
		
	}
	
	@And("Get the commentID of the reported comment")
	public void Get_the_comment_ID_of_the_reported_comment() {
		JsonPath js = new JsonPath(res.asString());
		if(js.get("data.report_data.report_list[0].id") != null) {
			commentId=js.get("data.report_data.report_list[0].id");
		}
		System.out.println(commentId);
		
		
		
	}
	
	@When("Admin call the update reported comment api")
	public void admin_call_the_update_reported_comment_api() throws FileNotFoundException {
		 res = ApplicationApi.post("/admin/comment_report/",token,ReportedCommentPayload.getReportedCommentPayload(commentId));
		
	}
	

}
