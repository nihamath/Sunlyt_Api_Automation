package apiPayloads;

public class ReportedCommentPayload {
	
	public static String getReportedCommentPayload(int id) {
		return "{\r\n"
				+ "  \"data\": {\r\n"
				+ "    \"comment_report_ids\": [\r\n"
				+ "      "+id+"\r\n"
				+ "    ],\r\n"
				+ "    \"status\": 3,\r\n"
				+ "    \"reason_to_reject\": \"\"\r\n"
				+ "  }\r\n"
				+ "}";
	}

}
