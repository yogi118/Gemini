package apiActions;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import apiBuilders.PostAPIBuilder;
import commonUtils.FileUtils;
import commonUtils.JavaUtilis;
import commonUtils.PayloadConstants;
import io.restassured.response.Response;

public class CreateNewOrder {

	public void placeNewPurchaseOrder(String url, String symbol, String amount,
			String price, String type ) {
		String gemini_api_key = FileUtils.getProperty("gemini_api_key");
		String gemini_api_secret = FileUtils.getProperty("gemini_api_secret");
		
		String timestamp = JavaUtilis.timestamp();
		String payload = String.format(PayloadConstants.newOrderPayload, timestamp, symbol, amount, price, type);
		String payloadB64 = Base64.getEncoder().encodeToString(payload.getBytes());
		String signature = generateSignature(gemini_api_secret, payload);
		
		Map<String, String> hedaderConfiguation = new HashMap<String, String>();
		hedaderConfiguation.put("Content-Type", "text/plain");
		hedaderConfiguation.put("X-GEMINI-APIKEY", gemini_api_key);
		hedaderConfiguation.put("X-GEMINI-PAYLOAD", payloadB64);
		hedaderConfiguation.put("X-GEMINI-SIGNATURE", signature);
		hedaderConfiguation.put("Cache-Control", "no-cache");
		PostAPIBuilder.post(hedaderConfiguation, url);
	}
	
	public String generateSignature(String secretKey, String encryptedPayLoad) {
		String signature = "";
		SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes(), "HmacSHA384");
	    Mac mac;
		try {
			mac = Mac.getInstance("HmacSHA384");
			 mac.init(signingKey);
			signature = bytesToHex(mac.doFinal(encryptedPayLoad.getBytes()));
		} catch (NoSuchAlgorithmException | InvalidKeyException e) {
		}
		return signature;
	}
	
	private  String bytesToHex(final byte[] hash) {
	    final StringBuffer hexString = new StringBuffer();
	    for (int i = 0; i < hash.length; i++) {
	        final String hex = Integer.toHexString(0xff & hash[i]);
	        if (hex.length() == 1) {
	            hexString.append('0');
	        }
	        hexString.append(hex);
	    }
	    return hexString.toString();
	}
	
}
