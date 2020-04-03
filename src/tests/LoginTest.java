package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import objects.Login;
import objects.Registration30;

public class LoginTest {

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

	@Test
	public void existingUserLogin() {
		
		for (int i = 1; i <= 5; i++) {
			wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			wd.get(Login.HOMEPAGE_URL);							//Navigating to home page
			wd.manage().window().maximize();

			Login.logIn(wd, i);									//Opening and filling login form

			String name = Registration30.findLoggedUser(wd);	//Finding logged user name to test
			String expectedName = Registration30.getData(i, 1) + " " + Registration30.getData(i, 2); //Setting expected name to compare in test

			String currentUrl = wd.getTitle();					//Finding page title to test
			String expectedUrl = "My account - My Store";		//Setting expected page title to compare in test

			sa.assertTrue(Registration30.logStatus(wd));		//Testing sign in status
			
			sa.assertEquals(name, expectedName);				//Testing if name of logged user is correct
			sa.assertEquals(currentUrl, expectedUrl);			//Testing if page for logged in user is opened

			Registration30.logOut(wd);							//Logging user out
			
			currentUrl = wd.getTitle();							//Finding page title to test
			expectedUrl = "Login - My Store";					//Setting expected page title to compare in test

			sa.assertEquals(currentUrl, expectedUrl);			//Testing if page for no logged in user is opened
			
			sa.assertAll();
		}

		
	}
}
