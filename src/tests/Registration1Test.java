package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.Cart;
import objects.Order;
import objects.Registration1;

public class Registration1Test {

	public static WebDriver wd;
	public static Actions act;
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

	// Test for creating an account after adding products to shopping cart, using Proceed to checkout button
	
	@Test
	public void proceedToCheckoutTest() {

		wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		wd.get(Order.SUMMER_DRESSES_URL);				//Opening home page
		wd.manage().window().maximize();
		wd.navigate().to(Order.DRESS_1_URL);			//Navigating to particular product page
		Order.addQuantity1(wd);							//Setting number of products wanted
		Order.chooseSize(wd);							//Setting product size
		Order.chooseColour(wd);							//Setting product colour 
		Order.makeOrder(wd);							//Moving products to shopping cart
		wd.navigate().to(Cart.CART_URL);				//Opening cart page

		Registration1.cartCheckout(wd);					//Proceeding using checkout button and opening registration page
		Registration1.fillingForm(wd);					//Filling form
		Registration1.submitForm(wd);					//Submitting form
		
		String status = Registration1.findStatus(wd);	//Finding value of user status to test
		String expected1 = "Sign out";					//Setting expected value of status indicator to test
		
		String current = wd.getTitle();					//Finding page title to test
		String expected2 = "Order - My Store";			//Setting expected title of logged in user page
		
		sa.assertNotNull(Registration1.nadjielement(wd));	//Testing presence of signed in status indicator
		sa.assertEquals(status, expected1);				//Testing if user is signed in
		sa.assertEquals(current, expected2);			//Testing if page for logged in user is opened
				
		sa.assertAll();
	}
}
