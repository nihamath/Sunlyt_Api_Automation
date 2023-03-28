package apiPayloads;

public class loginPayload {
	
	
	
	public static String getAdminLoginPayload(String email, String paswd) {
		return "{\r\n"
				+ "  \"data\": {\r\n"
				+ "    \"username\": \""+email+"\",\r\n"
				+ "    \"password\": \""+paswd+"\"\r\n"
				+ "  }\r\n"
				+ "}";
	}
	
	
	
	public static String getWebUserPayload(String email, String paswd) {
		return "{\r\n"
				+ "  \"data\": {\r\n"
				+ "    \"username\": \""+email+"\",\r\n"
				+ "    \"password\": \""+paswd+"\",\r\n"
				+ "    \"token\": \"\",\r\n"
				+ "    \"registration_type\": 0,\r\n"
				+ "    \"agreed_terms\": false\r\n"
				+ "  }\r\n"
				+ "}";
	}
	

}
