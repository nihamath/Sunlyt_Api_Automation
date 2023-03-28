package utils;

import static io.restassured.RestAssured.given;
import apiPayloads.loginPayload;
import io.restassured.response.Response;

public class tokenManager {
	
	static ReadConfig read= new ReadConfig();

	
	
	public static String getToken(String role) {
		String token = "";
		
	switch(role) {
		case "Super Admin":
			token=adminLogin(read.getsuperAdminEmail(),read.getsuperAdminPassword());
			break;
			
		case "Campaign Admin":
			token=adminLogin(read.getcampaignAdminEmail(),read.getcampaignAdminPassword());
			break;
			
		case "Advertisement Admin":
			token=adminLogin(read.getadvertisementAdminEmail(),read.getadvertisementAdminPassword());
			break;
			
		case "User Admin":
			token=adminLogin(read.getuserAdminEmail(),read.getuserAdminPassword());
			break;
			
		case "Feedback Admin":
			token=adminLogin(read.getfeedbackAdminEmail(),read.getfeedbackAdminPassword());
			break;
			
		case "Support Admin":
			token=adminLogin(read.getsupportAdminEmail(),read.getsupportAdminPassword());
			break;
			
		case "Web User":
			token=userLogin(read.getwebUserEmail(),read.getwebUserPassword());
			break;
			
		}
		
		return token;
	}


	public static String adminLogin(String email, String pswd) {
		
		Response res=given().
				baseUri(read.getUrl()).header("Content-Type", "application/json").body(loginPayload.getAdminLoginPayload(email,pswd)).
			when().
				post("admin/login/").
			then().assertThat().statusCode(200).extract().response();
		System.out.println(res.path("data.token.access"));
		return res.path("data.token.access");
		
		
	}
	
public static String userLogin(String email, String pswd) {
		
	Response res=given().
			baseUri(read.getUrl()).header("Content-Type", "application/json").body(loginPayload.getWebUserPayload(email, pswd)).
		when().
			post("user/login/").
		then().assertThat().statusCode(200).extract().response();
	System.out.println(res.path("data.token.access"));
	return res.path("data.token.access");
	
	}
	

}
