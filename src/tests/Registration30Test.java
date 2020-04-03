package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.Registration30;

public class Registration30Test {

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

	//Test for creating 30 accounts using data from excell table
	@Test
	public void accountCreateTest() {

		for (int i = 1; i <= 30; i++) {
			wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			wd.get(Registration30.HOMEPAGE_URL);				//Opening home page
			wd.manage().window().maximize();

			wd.navigate().to(Registration30.LOGINPAGE_URL);		//Navigating to sign in page

			Registration30.createAccount(wd, i);				//Filling the form	
			Registration30.submitForm(wd);						//Submitting the form

			String name = Registration30.findLoggedUser(wd);	//Finding logged user name to test
			String expectedName = Registration30.getData(i, 1) + " " + Registration30.getData(i, 2);	//Setting expected name to compare in test

			String currentUrl = wd.getTitle();					//Finding page title to test
			String expectedUrl = "My account - My Store";		//Setting expected page title to compare in test

			sa.assertTrue(Registration30.logStatus(wd));		//Testing sign in status
			
			sa.assertEquals(name, expectedName);				//Testing if name of logged user is correct
			sa.assertEquals(currentUrl, expectedUrl);			//Testing if page for logged in user is opened

			Registration30.logOut(wd);							//Logging user out
			
			currentUrl = wd.getTitle();							//Finding page title to test
			expectedUrl = "Login - My Store";					//Setting expected page title to compare in test

			sa.assertEquals(currentUrl, expectedUrl);			//Testing if page for no logged in user is opened
		}

		sa.assertAll();
	}

}
