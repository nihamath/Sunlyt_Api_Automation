package apiPayloads;

public class feedbackPayload {
	
	public static String getFeedfbackPayload(int id) {
		return "{\r\n"
				+ "  \"data\": {\r\n"
				+ "    \"contact_us_ids\": [\r\n"
				+ "      "+id+"\r\n"
				+ "    ],\r\n"
				+ "    \"status\": 3,\r\n"
				+ "    \"reply\": \"sds\"\r\n"
				+ "  }\r\n"
				+ "}";
	}
	

}
