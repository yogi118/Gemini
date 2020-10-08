package stepDefinitions;

import apiActions.CreateNewOrder;
import apiBuilders.PostAPIBuilder;
import apiVerifications.APIVerification;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateNewOrderSteps {

	private CreateNewOrder createOrder;
	String url;

	public CreateNewOrderSteps() {
		createOrder = new CreateNewOrder();
	}

	@Given("I have {string} and {string} for placing new buy order")
	public void i_have_and_for_placing_new_buy_order(String base_url, String endpoint) {
		url = base_url + endpoint;
	}

	@When("I want to place new purchase order for {string} with quantity {string} and price {string} of {string} type")
	public void i_want_to_place_new_purchase_order_for_with_quantity_and_price_of_type(String symbol, String amount,
			String price, String type) {
		createOrder.placeNewPurchaseOrder(url, symbol, amount, price, type);
		System.out.println(PostAPIBuilder.response.body().asString());
	}

	@Then("User shold be able to place the new buy order")
	public void user_shold_be_able_to_place_the_new_buy_order() {
		// TODO: Put the actual get when response is generated
		// APIVerification.responseKeyValidationFromJsonObject(PostAPIBuilder.response,
	}

	@Then("User shold not be able to place the new buy order")
	public void user_shold_not_be_able_to_place_the_new_buy_order() {
		// TODO: Put the actual get when response is generated
		// APIVerification.responseKeyValidationFromJsonObject(PostAPIBuilder.response,
	}

	@Then("I should get {string} as post response")
	public void i_should_get_proper_response(String statusCode) {
		APIVerification.responseCodeValidation(PostAPIBuilder.response, Integer.parseInt(statusCode));
	}

	@Then("Response should contain {string} error message")
	public void response_should_contain_as_error_message(String message) {
		// Code to verify error message presence
	}

	@Then("Toltal price paid should be {string} as per amount")
	public void toltal_price_paid_should_be_as_per_amount(String totalPrice) {
		// Code to verify error total price from response
	}

	@When("I want to place new purchase order for {string} with stop_price {string} and price {string} of {string} type")
	public void i_want_to_place_new_purchase_order_for_with_stop_price_and_price_of_type(String symbol,
			String stopPrice, String price, String type) {

	}

	@When("I want to place new purchase order for {string} with stop_price {string} and price {string} of {string} type with {string} optional array")
	public void i_want_to_place_new_purchase_order_for_with_stop_price_and_price_of_type_with_optional_array(
			String symbol, String stopPrice, String price, String type, String options) {

	}
}
