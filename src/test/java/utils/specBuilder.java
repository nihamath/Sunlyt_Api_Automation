package utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class specBuilder {
	

	public static ReadConfig read= new ReadConfig();
	public static RequestSpecification getRequestSpec(String token) throws FileNotFoundException {

		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		return  new RequestSpecBuilder()
				.setBaseUri(read.getBaseUrl()).setBasePath("/v1")
				.addHeader("Authorization", token)
				.addHeader("Content-Type", "application/json").addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log))
				.log(LogDetail.ALL).build();
		
	}


	public static ResponseSpecification getResponseSpec() {

		return new ResponseSpecBuilder().
				expectContentType(ContentType.JSON).
				log(LogDetail.ALL).build();
		
	}

}
