package stepDefinitions;

import static org.junit.Assert.assertTrue;

import apiActions.TestScenario;
import apiBuilders.GetAPIBuilder;
import apiVerifications.APIVerification;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class TestScenarioSteps {

	private TestScenario testScenario;

	public TestScenarioSteps() {
		testScenario = new TestScenario();
	}

	@When("I hit the get request {string} to get all the symbols present")
	public void i_hit_the_get_request_to_get_all_the_symbols_present(String url) {
		GetAPIBuilder.get(url);
	}

	@Then("I should get valid response")
	public void i_should_get_valid_response() {
		APIVerification.responseCodeValidation(GetAPIBuilder.response, 200);
	}

	@Then("Response should contain {string} as trade symbol")
	public void response_should_contain_as_trade_symbol(String symbol) {
		boolean tradeSymbolPresent = testScenario.verifyTradeSymbol(GetAPIBuilder.response, symbol);
		assertTrue("Response does not contain " + symbol + " trade symbol", tradeSymbolPresent);
	}
	
	@When("I hit the get request {string} and analyze the response")
	public void i_hit_the_get_request_and_analyze_the_response(String url) {
		GetAPIBuilder.get(url);
	}

	@Then("Response body should contain the key values")
	public void response_body_should_contain_the_key_values(DataTable dataTable) {
		testScenario.verifyKeysArePresent(GetAPIBuilder.response, dataTable);
	}
}
