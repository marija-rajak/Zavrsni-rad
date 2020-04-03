package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Registration1 {

	public static final String TO_CHECKOUT_BTN_XPATH = "(//a[@class='button btn btn-default standard-checkout button-medium'])";

	public static final String EMAIL_INPUT_ID = "email_create";

	public static final String SUBMIT_BTN_ID = "SubmitCreate";

	public static final String FIRSTNAME_FIELD_ID = "customer_firstname";

	public static final String LASTNAME_FIELD_ID = "customer_lastname";

	public static final String PASSWORD_FIELD_ID = "passwd";

	public static final String ADDRESS_FIELD_ID = "address1";

	public static final String CITY_FIELD_ID = "city";

	public static final String SELECT_STATE_ID = "id_state";

	public static final String STATE_NAME = "Alabama";

	public static final String POSTALCODE_FIELD_ID = "postcode";

	public static final String SELECT_COUNTRY_ID = "id_country";

	public static final String COUNTRY_NAME = "United States";

	public static final String MOBILEPHONE_FIELD_ID = "phone_mobile";

	public static final String ALIASADDRESS_FIELD_ID = "alias";

	public static final String REGISTER_BTN_ID = "submitAccount";

	public static final String SIGNOUTBTN_XPATH = "//a[@class='account']";

	public static final String STATUSBTN_XPATH = "//div[@class='header_user_info']//a[contains(@class, 'log')]";

	// Method for clicking Proceed to checkout button and registering an email for
	// new user
	public static void cartCheckout(WebDriver wd) {

		wd.findElement(By.xpath(TO_CHECKOUT_BTN_XPATH)).click();
		wd.findElement(By.id(EMAIL_INPUT_ID)).sendKeys("email2564@email.com");
		wd.findElement(By.id(SUBMIT_BTN_ID)).click();
	}

	// Method for filling form with user data
	public static void fillingForm(WebDriver wd) {

		wd.findElement(By.id(FIRSTNAME_FIELD_ID)).sendKeys("ime");
		wd.findElement(By.id(LASTNAME_FIELD_ID)).sendKeys("prezime");
		wd.findElement(By.id(PASSWORD_FIELD_ID)).sendKeys("12345");
		wd.findElement(By.id(ADDRESS_FIELD_ID)).sendKeys("adresa1");
		wd.findElement(By.id(CITY_FIELD_ID)).sendKeys("city1");
		Select state = new Select(wd.findElement(By.id(SELECT_STATE_ID)));
		state.selectByVisibleText(STATE_NAME);
		wd.findElement(By.id(POSTALCODE_FIELD_ID)).sendKeys("00000");
		Select country = new Select(wd.findElement(By.id(SELECT_COUNTRY_ID)));
		country.selectByVisibleText(COUNTRY_NAME);
		wd.findElement(By.id(MOBILEPHONE_FIELD_ID)).sendKeys("0123456789");
		wd.findElement(By.id(ALIASADDRESS_FIELD_ID)).sendKeys("adresa2");
		uspori();
	}

	// Method for submitting form
	public static void submitForm(WebDriver wd) {
		wd.findElement(By.id(REGISTER_BTN_ID)).click();
	}

	// Method for reading text from status button (sign in/sign out)
	public static String findStatus(WebDriver wd) {

		WebElement temp = wd.findElement(By.xpath(STATUSBTN_XPATH));
		return temp.getText();
	}

	// Method for finding sign out button as an indicator of user status
	public static WebElement nadjielement(WebDriver wd) {

		try {
			WebElement e = wd.findElement(By.xpath(SIGNOUTBTN_XPATH));
			return e;

		} catch (NoSuchElementException e) {
			return null;
		}
	}

	// Method for slowing down to observe
	public static void uspori() {
		try {
			Thread.sleep(2000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
