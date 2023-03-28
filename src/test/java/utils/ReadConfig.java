package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
Properties pro;
	
	public ReadConfig() {
		File src=new File("C:\\Users\\Nihamathulla\\eclipse-workspace\\Sunlyt_Crowdfunding_Api_Test\\src\\test\\Resources\\config.properties");
		try {
			FileInputStream fis= new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	public String getUrl() {
		String url= pro.getProperty("baseUrl");
		return url;
	}
	
	public String getBaseUrl() {
		String url= pro.getProperty("baseURLs");
		return url;
	}
	
	public String getsuperAdminEmail() {
		String superAdminEmail= pro.getProperty("superAdminEmail");
		return superAdminEmail;
	}
	
	public String getsuperAdminPassword() {
		String superAdminPassword= pro.getProperty("superAdminPassword");
		return superAdminPassword;
	}
	
	public String getcampaignAdminEmail() {
		String campaignAdminEmail= pro.getProperty("campaignAdminEmail");
		return campaignAdminEmail;
	}
	public String getcampaignAdminPassword() {
		String campaignAdminPassword= pro.getProperty("campaignAdminPassword");
		return campaignAdminPassword;
	}
	
	public String getfeedbackAdminEmail() {
		String feedbackAdminEmail= pro.getProperty("feedbackAdminEmail");
		return feedbackAdminEmail;
	}
	
	public String getfeedbackAdminPassword() {
		String feedbackAdminPassword= pro.getProperty("feedbackAdminPassword");
		return feedbackAdminPassword;
	}
	
	public String getuserAdminEmail() {
		String userAdminEmail= pro.getProperty("userAdminEmail");
		return userAdminEmail;
	}
	
	public String getuserAdminPassword() {
		String userAdminPassword= pro.getProperty("userAdminPassword");
		return userAdminPassword;
	}
	
	public String getsupportAdminEmail() {
		String supportAdminEmail= pro.getProperty("supportAdminEmail");
		return supportAdminEmail;
	}
	
	public String getsupportAdminPassword() {
		String supportAdminPassword= pro.getProperty("supportAdminPassword");
		return supportAdminPassword;
	}
	
	public String getadvertisementAdminEmail() {
		String advertisementAdminEmail= pro.getProperty("advertisementAdminEmail");
		return advertisementAdminEmail;
	}
	
	public String getadvertisementAdminPassword() {
		String advertisementAdminPassword= pro.getProperty("advertisementAdminPassword");
		return advertisementAdminPassword;
	}
	
	public String getwebUserEmail() {
		String webUserEmail= pro.getProperty("webUserEmail");
		return webUserEmail;
	}
	
	public String getwebUserPassword() {
		String webUserPassword= pro.getProperty("webUserPassword");
		return webUserPassword;
	}


}
