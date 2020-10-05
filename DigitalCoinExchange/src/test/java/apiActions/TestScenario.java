package apiActions;


import java.util.List;

import apiVerifications.APIVerification;
import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;

public class TestScenario {
	
	public boolean verifyTradeSymbol(Response response, String symbol) {
		boolean symbolPresent = false;
		String [] symbols = response.asString().split(",");
		for(int i = 0; i < symbols.length; i++) {
			if(symbols[i].replaceAll("[^a-zA-Z0-9]", "").equals(symbol)) {
				return true;
			}
		}
		return symbolPresent;
	}
	
	public boolean verifyKeysArePresent(Response response, DataTable dataTable) {
		List<List<String>> test = dataTable.asLists();
		for (List<String> list : test) {
			String key = list.get(0);
			APIVerification.responseKeyValidationFromJsonObject(response, key);
		}
		return true;
	}
}
