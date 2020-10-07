package apiVerifications;

import org.json.JSONArray;
import org.json.JSONObject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.restassured.response.Response;

public class APIVerification {

	public static void responseCodeValidation(Response response, int statusCode) {
		assertEquals(statusCode + " not returned", statusCode, response.getStatusCode());
	}

	public static void responseKeyValidationfromArray(Response response, String key) {
		JSONArray array = new JSONArray(response.getBody().asString());
		for (int i = 0; i < array.length(); i++) {
			JSONObject obj = array.getJSONObject(i);
			boolean isKeyPresent = obj.get(key) != null ? true : false;
			assertTrue(key +" Key is not present", isKeyPresent);
		}
	}

	public static void responseKeyValidationFromJsonObject(Response response, String key) {
		JSONObject json = new JSONObject(response.getBody().asString());
		boolean isKeyPresent = json.get(key) != null ? true : false;
		assertTrue(key +" Key is not present", isKeyPresent);
	}

}
