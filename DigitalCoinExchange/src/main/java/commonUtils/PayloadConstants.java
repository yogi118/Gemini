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
	
	public static String newStopLimiOrderPayload = "{\r\n" + 
			"    \"amount\": \".1\",\r\n" + 
			"    \"client_order_id\": \"470135\",\r\n" + 
			"    \"price\": \"%s\",\r\n" + 
			"    \"nonce\": %s,\r\n" + 
			"    \"side\": \"Buy\",\r\n" + 
			"    \"request\": \"/v1/order/new\",\r\n" + 
			"    \"stop_price\": \"%s\",\r\n" + 
			"    \"symbol\": \"%s\",\r\n" + 
			"    \"type\": \"%s\"\r\n" + 
			"}";
	
	public static String newOptionOrderPayload = "{\r\n" + 
			"    \"order_id\": \"7419662\",\r\n" + 
			"    \"id\": \"7419662\",\r\n" + 
			"    \"symbol\": \"%s\",\r\n" + 
			"    \"exchange\": \"gemini\",\r\n" + 
			"    \"avg_execution_price\": \"0.00\",\r\n" + 
			"    \"side\": \"buy\",\r\n" + 
			"    \"type\": \"%s\",\r\n" + 
			"    \"timestamp\": \"%s\",\r\n" + 
			"    \"timestampms\": %s,\r\n" + 
			"    \"is_live\": True,\r\n" + 
			"    \"is_cancelled\": False,\r\n" + 
			"    \"is_hidden\": False,\r\n" + 
			"    \"was_forced\": False,\r\n" + 
			"    \"executed_amount\": \"0\",\r\n" + 
			"    \"options\": [%s],\r\n" + 
			"    \"stop_price\": \"%s\",\r\n" + 
			"    \"price\": \"%s\",\r\n" + 
			"    \"original_amount\": \"0.01\"\r\n" + 
			"}";
}
