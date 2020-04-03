package objects;

import javax.management.StringValueExp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Order {

	public static final String SUMMER_DRESSES_URL = "http://automationpractice.com/index.php?id_category=11&controller=category";

	public static final String DRESS_1_URL = "http://automationpractice.com/index.php?id_product=5&controller=product";

	public static final String DRESS_1_XPATH = "//li[@class='ajax_block_product col-xs-12 col-sm-6 col-md-4 first-in-line last-line first-item-of-tablet-line first-item-of-mobile-line last-mobile-line']//a[@class='product_img_link']";

	public static final String QUANTITY_INPUT_ID = "quantity_wanted";

	public static final String QUANTITY_ADD_BUTTON_XPATH = "//i[@class='icon-plus']";

	public static final String SIZE_INPUT_ID = "group_1";

	public static final String SIZE = "M";

	public static final int QUANTITY = 2;
	
	public static final String COLOUR = "Blue";

	public static final String COLOUR_BUTTON_NAME = COLOUR;

	public static final String ADD_BUTTON_XPATH = "//span[contains(text(),'Add to cart')]";

	
	//Method for adding quantity by entering value in input field
	public static void addQuantity1(WebDriver wd) {
		WebElement input = wd.findElement(By.id(QUANTITY_INPUT_ID)); 	//finding input field
		input.clear(); 													//deleting default input (1)
		input.sendKeys(String.valueOf(QUANTITY)); 						//input desired quantity
	}

	//Method for adding quantity by clicking + beside input field
	public static void addQuantity2(WebDriver wd) {
		WebElement buttonAdd = wd.findElement(By.xpath(QUANTITY_ADD_BUTTON_XPATH)); //finding + button
		for (int i = 0; i < QUANTITY - 1; i++) { 		
			buttonAdd.click();											//adding desired quantity; number of clicks should be less than wanted, because 1 is input by default
		}
	}

	//Method for selecting product size
	public static void chooseSize(WebDriver wd) {
		Select size = new Select(wd.findElement(By.id(SIZE_INPUT_ID)));
		size.selectByVisibleText(SIZE);
	}

	//Method for selecting product colour
	public static void chooseColour(WebDriver wd) {
		wd.findElement(By.name(COLOUR_BUTTON_NAME)).click();
	}

	//Moving chosen product(s) to shopping cart
	public static void makeOrder(WebDriver wd) {
		wd.findElement(By.xpath(ADD_BUTTON_XPATH)).click();
	}

	//Method for slowing down
	public static void uspori() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
