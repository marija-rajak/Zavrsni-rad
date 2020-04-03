package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.Cart;
import objects.Order;

public class CartTest {

	public static WebDriver wd;
	public static SoftAssert sa;

	@BeforeMethod
	public static void settings() {
		wd = new ChromeDriver();
		sa = new SoftAssert();
	}

	@AfterMethod
	public static void close() {
		wd.close();
	}

	// Test for ordering products using method for adding quantity by entering value
	// in input field
	@Test
	public static void cartCheck() {

		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		wd.get(Order.SUMMER_DRESSES_URL);
		wd.manage().window().maximize();
		wd.navigate().to(Order.DRESS_1_URL); 		// Navigating to product page

		Order.addQuantity1(wd); 					// Adding quantity
		Order.chooseSize(wd); 						// Selecting size
		Order.chooseColour(wd); 					// Selecting colour
		Order.makeOrder(wd); 						// Adding products to cart
		uspori();

		wd.navigate().to(Cart.CART_URL); // Opening cart page

		String actualQuantity = Cart.getQuantity(wd); // Finding quantity value to test
		String actualSize = Cart.getSizeColour(wd)[0]; // Finding size value to test
		String actualColour = Cart.getSizeColour(wd)[1]; // Finding colour value to test

		String expectedQuantity = String.valueOf(Order.QUANTITY); // Setting expected expected quantity to compare in test
		String expectedSize = Order.SIZE; 			// Setting expected expected size to compare in test
		String expectedColour = Order.COLOUR; 		// Setting expected expected colour to compare in test

		sa.assertEquals(actualQuantity, expectedQuantity); 	// Testing if quantity is correct
		sa.assertEquals(actualSize, expectedSize); 			// Testing if size is correct
		sa.assertEquals(actualColour, expectedColour); 		// Testing if colour is correct

		sa.assertAll();

	}

	//// Test for ordering products using method for adding quantity by clicking +
	//// button
	@Test
	public static void cartCheck2() {

		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		wd.get(Order.SUMMER_DRESSES_URL);
		wd.manage().window().maximize();
		wd.navigate().to(Order.DRESS_1_URL); 		// Navigating to product page

		Order.addQuantity2(wd); 					// Adding quantity
		Order.chooseSize(wd); 						// Selecting size
		Order.chooseColour(wd); 					// Selecting colour
		Order.makeOrder(wd); 						// Adding products to cart
		uspori();

		wd.navigate().to(Cart.CART_URL); 			// Opening cart page

		String actualQuantity = Cart.getQuantity(wd); // Finding quantity value to test
		String actualSize = Cart.getSizeColour(wd)[0]; // Finding size value to test
		String actualColour = Cart.getSizeColour(wd)[1]; // Finding colour value to test

		String expectedQuantity = String.valueOf(Order.QUANTITY); // Setting expected expected quantity to compare in test
		String expectedSize = Order.SIZE; 			// Setting expected expected size to compare in test
		String expectedColour = Order.COLOUR; 		// Setting expected expected colour to compare in test

		sa.assertEquals(actualQuantity, expectedQuantity); 	// Testing if quantity is correct
		sa.assertEquals(actualSize, expectedSize); 			// Testing if size is correct
		sa.assertEquals(actualColour, expectedColour); 		// Testing if colour is correct

		sa.assertAll();

	}

	public static void uspori() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
