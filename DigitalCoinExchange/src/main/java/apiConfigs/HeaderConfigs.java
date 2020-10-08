package apiConfigs;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfigs {

	public HeaderConfigs() {

	}

	public static Map<String, String> defaultHeaders() {
		Map<String, String> defalutHeaders = new HashMap<String, String>();
		defalutHeaders.put("Content-Type", "application/json");
		return defalutHeaders;
	}
	
	public static Map<String, String> placeNewOrderHeader(String gemini_api_key, String payloadB64, String signature) {
		Map<String, String> hedaderConfiguation = new HashMap<String, String>();
		hedaderConfiguation.put("Content-Type", "text/plain");
		hedaderConfiguation.put("X-GEMINI-APIKEY", gemini_api_key);
		hedaderConfiguation.put("X-GEMINI-PAYLOAD", payloadB64);
		hedaderConfiguation.put("X-GEMINI-SIGNATURE", signature);
		hedaderConfiguation.put("Cache-Control", "no-cache");
		return hedaderConfiguation;
	}

}
