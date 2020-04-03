package objects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Registration30 {

	public static final String HOMEPAGE_URL = "http://automationpractice.com";

	public static final String LOGINPAGE_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

	public static final String STATUSBTN_XPATH = "//div[@class='header_user_info']//a[contains(@class, 'log')]";

	public static final String USERBTN_XPATH = "//a[@class='account']";

	public static final String EMAIL_INPUT_ID = "email_create";

	public static final String SUBMIT_BTN_ID = "SubmitCreate";

	public static final String FIRSTNAME_FIELD_ID = "customer_firstname";

	public static final String LASTNAME_FIELD_ID = "customer_lastname";

	public static final String PASSWORD_FIELD_ID = "passwd";

	public static final String ADDRESS_FIELD_ID = "address1";

	public static final String CITY_FIELD_ID = "city";

	public static final String SELECT_STATE_ID = "id_state";

	public static final String POSTALCODE_FIELD_ID = "postcode";

	public static final String SELECT_COUNTRY_ID = "id_country";

	public static final String COUNTRY_NAME = "United States";

	public static final String MOBILEPHONE_FIELD_ID = "phone_mobile";

	public static final String ALIASADDRESS_FIELD_ID = "alias";

	public static final String REGISTER_BTN_ID = "submitAccount";

	// Method for retrieving data from excell table
	public static String getData(int i, int j) {

		FileInputStream fis;
		XSSFWorkbook wb;

		try {
			fis = new FileInputStream("people.xlsx");
			wb = new XSSFWorkbook(fis);
			return wb.getSheetAt(0).getRow(i).getCell(j).toString();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	// Method for creating an account using data from excell table
	public static void createAccount(WebDriver wd, int i) {

		wd.findElement(By.id(EMAIL_INPUT_ID)).sendKeys(getData(i, 0));
		wd.findElement(By.id(SUBMIT_BTN_ID)).click();
		wd.findElement(By.id(FIRSTNAME_FIELD_ID)).sendKeys(getData(i, 1));
		wd.findElement(By.id(LASTNAME_FIELD_ID)).sendKeys(getData(i, 2));
		wd.findElement(By.id(PASSWORD_FIELD_ID)).sendKeys(getData(i, 3));
		wd.findElement(By.id(ADDRESS_FIELD_ID)).sendKeys(getData(i, 4));
		wd.findElement(By.id(CITY_FIELD_ID)).sendKeys(getData(i, 5));
		Select state = new Select(wd.findElement(By.id(SELECT_STATE_ID)));
		state.selectByVisibleText(getData(i, 6));
		wd.findElement(By.id(POSTALCODE_FIELD_ID)).sendKeys(getData(i, 7));
		Select country = new Select(wd.findElement(By.id(SELECT_COUNTRY_ID)));
		country.selectByVisibleText(getData(i, 8));
		wd.findElement(By.id(MOBILEPHONE_FIELD_ID)).sendKeys(getData(i, 9));
		wd.findElement(By.id(ALIASADDRESS_FIELD_ID)).sendKeys(getData(i, 10));
		uspori();
	}

	// Method for submitting data after filling form
	public static void submitForm(WebDriver wd) {
		wd.findElement(By.id(REGISTER_BTN_ID)).click();
	}

	// Method for checking user status (signed in or not)
	public static boolean logStatus(WebDriver wd) {
		String status = wd.findElement(By.xpath(STATUSBTN_XPATH)).getText();
		if (status.equals("Sign out"))
			return true;
		else
			return false;
	}

	// Method for finding name of logged user
	public static String findLoggedUser(WebDriver wd) {
		if (logStatus(wd)) {
			return wd.findElement(By.xpath(USERBTN_XPATH)).getText();
		} else
			return null;
	}

	// Method for locating Sign out button
	public static void logOut(WebDriver wd) {
		if (logStatus(wd)) {
			wd.findElement(By.linkText("Sign out")).click();
		}
	}

	// Method for slowing down program execution
	public static void uspori() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
