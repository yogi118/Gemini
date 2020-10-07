package commonUtils;

public class PayloadConstants {

	public static String newOrderPayload = "\r\n" + 
			"{\r\n" + 
			"   \"request\": \"/v1/order/new\",\r\n" + 
			"    \"nonce\": %s,\r\n" + 
			"    \"symbol\": \"%s\",\r\n" + 
			"    \"amount\": \"%s\",\r\n" + 
			"    \"price\": \"%s\",\r\n" + 
			"    \"side\": \"buy\",\r\n" + 
			"    \"type\": \"%s\",\r\n" + 
			"    \"options\": [\"maker-or-cancel\"] \r\n" + 
			"}";
}
