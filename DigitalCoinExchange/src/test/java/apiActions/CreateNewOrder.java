package apiActions;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import apiBuilders.PostAPIBuilder;
import apiConfigs.HeaderConfigs;
import commonUtils.FileUtils;
import commonUtils.JavaUtilis;
import commonUtils.PayloadConstants;

public class CreateNewOrder {

	public void placeNewPurchaseOrder(String url, String symbol, String amount, String price, String type) {
		String gemini_api_key = FileUtils.getProperty("gemini_api_key");
		String gemini_api_secret = FileUtils.getProperty("gemini_api_secret");

		String timestamp = JavaUtilis.timestamp();
		String payload = String.format(PayloadConstants.newOrderPayload, timestamp, symbol, amount, price, type);
		String payloadB64 = Base64.getEncoder().encodeToString(payload.getBytes());
		String signature = generateSignature(gemini_api_secret, payload);

		Map<String, String> hedaderConfiguation = HeaderConfigs.placeNewOrderHeader(gemini_api_key, payloadB64,
				signature);
		PostAPIBuilder.post(hedaderConfiguation, url);
	}
	
	public void placeNewStopLimitPurchaseOrder(String url, String symbol, String stopPrice, String price, String type) {
		String gemini_api_key = FileUtils.getProperty("gemini_api_key");
		String gemini_api_secret = FileUtils.getProperty("gemini_api_secret");

		String timestamp = JavaUtilis.timestamp();
		String payload = String.format(PayloadConstants.newStopLimiOrderPayload, price, timestamp, stopPrice, symbol, type);
		String payloadB64 = Base64.getEncoder().encodeToString(payload.getBytes());
		String signature = generateSignature(gemini_api_secret, payload);

		Map<String, String> hedaderConfiguation = HeaderConfigs.placeNewOrderHeader(gemini_api_key, payloadB64,
				signature);
		PostAPIBuilder.post(hedaderConfiguation, url);
	}
	
	public void placeNewOptionsPurchaseOrder(String url, String symbol, String stopPrice, String price, String type, String options) {
		String gemini_api_key = FileUtils.getProperty("gemini_api_key");
		String gemini_api_secret = FileUtils.getProperty("gemini_api_secret");

		String timestamp = JavaUtilis.timestamp();
		String timestamp2 = timestamp + JavaUtilis.randomNumebr();
		String payload = String.format(PayloadConstants.newOptionOrderPayload, symbol, type, timestamp, timestamp2, options, stopPrice, price);
		String payloadB64 = Base64.getEncoder().encodeToString(payload.getBytes());
		String signature = generateSignature(gemini_api_secret, payload);

		Map<String, String> hedaderConfiguation = HeaderConfigs.placeNewOrderHeader(gemini_api_key, payloadB64,
				signature);
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

	private String bytesToHex(final byte[] hash) {
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
