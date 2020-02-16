package Configuration;

public class Variables {

	public interface Data {

		String MERCEDES_URL = "https://shop.mercedes-benz.com/en-gb/collection/";
		String COOKIES_BTN = "//*[@id='layer-text']/p[4]/button";
		String WOMEN_COLLECTION = "utils-content-carousel-container-tile-image";
		String BEACH_BAG = "//*[contains(text(),'Beach bag')]";
		String ADD_TO_BASKET = "//*[contains(text(),' Add to basket')]";
		String GO_TO_SHOPPING_BASKET = "//button[contains(text(),' Go to shopping basket')]";
		String CONTINUE_TO_ADDRESS_AND_DELIVERY = "//button[contains(text(),'Continue to address and delivery')]";
		String GUEST_EMAIL = "input#dcp-login-guest-user-email";
		String EMAIL = "mbfcunha@gmail.com";
		String PLACE_ORDER_AS_GUEST = "//button[contains(text(),'Place order as guest')]";
		String MS_LABEL = "//label[contains(text(),'Ms')]";
		String FIRST_NAME_LABEL = "co_payment_address-firstName";
		String LAST_NAME_LABEL = "co_payment_address-lastName";
		String ADDRESS_LINE1_LABEL = "co_payment_address-line1";
		String ADDRESS_LINE2_LABEL = "co_payment_address-line2";
		String POSTAL_CODE_LABEL = "co_payment_address-postalCode";
		String TOWN_LABEL = "co_payment_address-town";
		String CONTINUE_TO_PAYMENT_TYPE = "//button[contains(text(),'Continue to payment type')]";
		String PAYPAL = "//*[contains(text(),'PayPal')]";
		String CONTINUE_TO_VERIFICATION = "//button[contains(text(),'Continue to verification and order placement')]";
		String YOUR_ORDER_DATA = "//*[contains(text(),'Your order data')]";
	}
}
