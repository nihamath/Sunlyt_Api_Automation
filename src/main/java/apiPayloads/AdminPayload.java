package apiPayloads;

public class AdminPayload {
	
	public static String getCreateAdminPayload() {
		String email = "nihamathulla+admin"+(int)(Math.random()*10000)+"@qburst.com";
		
		return "{\r\n"
				+ "  \"data\": {\r\n"
				+ "    \"username\": \""+email+"\",\r\n"
				+ "    \"password\": \"Nihamath@123\",\r\n"
				+ "    \"first_name\": \"NihamathAPITest\",\r\n"
				+ "    \"last_name\": \"test\",\r\n"
				+ "    \"role_id\": 9\r\n"
				+ "  }\r\n"
				+ "}";
	}
	
	
	public static String updateAdminPayload() {
		
		
		return "{\r\n"
				+ "  \"data\": {\r\n"
				+ "    \"username\": \"nihamathulla+admin9484@qburst.com\",\r\n"
				+ "    \"first_name\": \"APInihamathulla6698\",\r\n"
				+ "    \"last_name\": \"test\",\r\n"
				+ "    \"role_id\": 9,\r\n"
				+ "    \"user_id\": 657\r\n"
				+ "  }\r\n"
				+ "}";
	}
	
public static String deactivateAdminPayload(int id) {
		
		
		return "{\r\n"
				+ "  \"data\": {\r\n"
				+ "    \"user_id\": \""+id+"\",\r\n"
				+ "    \"is_active\": 0\r\n"
				+ "  }\r\n"
				+ "}";
	}

public static String activateAdminPayload(int id) {
	
	
	return "{\r\n"
			+ "  \"data\": {\r\n"
			+ "    \"user_id\": \""+id+"\",\r\n"
			+ "    \"is_active\": 1\r\n"
			+ "  }\r\n"
			+ "}";
}


}
