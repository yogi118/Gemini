package apiBuilders;

import static io.restassured.RestAssured.given;
import java.util.Map;

import io.restassured.response.Response;
import io.restassured.http.ContentType;

public class PostAPIBuilder {

	public static Response response;

	public static void post(Map<String, String> body) {
		response = given().contentType(ContentType.JSON).body(body).when().post();
	}
}
