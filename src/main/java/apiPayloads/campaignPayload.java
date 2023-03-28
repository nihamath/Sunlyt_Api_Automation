package apiPayloads;

public class campaignPayload {
	
	public static String getLiveCampaignPayload(int id) {
		return "{\r\n"
				+ "  \"data\": {\r\n"
				+ "    \"campaign_ids\": [\r\n"
				+ "      "+id+"\r\n"
				+ "    ],\r\n"
				+ "    \"campaign_status\": 2\r\n"
				+ "  }\r\n"
				+ "}";
	}

}
