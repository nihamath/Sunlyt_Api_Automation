package apiPayloads;

public class UserPayload {
	
	
	public static String getRegistrationPayload() {
		
		String email = "nihamathulla+"+(int)(Math.random()*10000)+"@qburst.com";
		String name = "APInihamathulla"+(int)(Math.random()*10000);
		return "{\r\n"
				+ "  \"data\": {\r\n"
				+ "    \"username\": \""+email+"\",\r\n"
				+ "    \"password\": \"Nihamath@123\",\r\n"
				+ "    \"first_name\": \""+name+"\",\r\n"
				+ "    \"last_name\": \"test\",\r\n"
				+ "    \"is_newsletter_subscribed\": false,\r\n"
				+ "    \"agreed_terms\": true,\r\n"
				+ "    \"tc_id\": 26\r\n"
				+ "  }\r\n"
				+ "}";
	}
	
	
	public static String getDeactivateUser(int id) {
		
		
		return "{\r\n"
				+ "  \"data\": {\r\n"
				+ "    \"user_id\": \""+id+"\",\r\n"
				+ "    \"is_active\": 0\r\n"
				+ "  }\r\n"
				+ "}";
	}
	
public static String getActivateUser(int id) {
		
		
		return "{\r\n"
				+ "  \"data\": {\r\n"
				+ "    \"user_id\": \""+id+"\",\r\n"
				+ "    \"is_active\": 1\r\n"
				+ "  }\r\n"
				+ "}";
	}
	

public static String getDeleteUserPayload(int id) {
	
	
	return "{\r\n"
			+ "  \"data\": {\r\n"
			+ "    \"user_id\": \""+id+"\",\r\n"
			+ "    \"is_deleted\": 1\r\n"
			+ "  }\r\n"
			+ "}";
}
	

}
