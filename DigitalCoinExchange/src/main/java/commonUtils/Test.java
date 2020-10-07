package commonUtils;

import java.time.Instant;
import java.util.Base64;

public class Test {

	public static void main(String[] args) {
		String timestamp = Instant.now().getEpochSecond() + "";
		System.out.println(timestamp);
		
		String val = "{\r\n" + 
				"   \"request\": \"/v1/order/new\",\r\n" + 
				"    \"nonce\": %s,\r\n" + 
				"    \"symbol\": \"btcusd\",\r\n" + 
				"    \"amount\": \"5\",\r\n" + 
				"    \"price\": \"3633.00\",\r\n" + 
				"    \"side\": \"buy\",\r\n" + 
				"    \"type\": \"exchange limit\",\r\n" + 
				"    \"options\": [\"maker-or-cancel\"] \r\n" + 
				"}";

		String payload = String.format(val, timestamp);
		String payloadB64 = Base64.getEncoder().encodeToString(payload.getBytes());
		System.out.println(payloadB64);
	}

}
