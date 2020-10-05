package apiBuilders;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class GetAPIBuilder {
	
	public static Response response;
	
	public static void get(String url) {
		response = given().when().get(url);
	}
}
