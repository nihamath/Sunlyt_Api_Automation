package utils;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;

import io.restassured.response.Response;


public class ApplicationApi {
	
	
public static Response get(String url, String token) throws FileNotFoundException {
		
		return given(specBuilder.getRequestSpec(token)).
				when().get(url).
				then().spec(specBuilder.getResponseSpec()).extract().response();
		
	}
	

public static Response post(String url,  String token,String body) throws FileNotFoundException {
		
		return given(specBuilder.getRequestSpec(token)).body(body).
				when().post(url).
				then().spec(specBuilder.getResponseSpec()).extract().response();
		
	}

public static Response put(String url,  String token,String body) throws FileNotFoundException {
	
	return given(specBuilder.getRequestSpec(token)).body(body).
			when().put(url).
			then().spec(specBuilder.getResponseSpec()).extract().response();
	
}

}
