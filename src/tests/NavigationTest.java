package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import objects.Navigation;

public class NavigationTest {

	public static WebDriver wd;
	public static Actions act;
	public static SoftAssert sa;

	@BeforeMethod
	public static void settings() {
		wd = new ChromeDriver();
		act = new Actions(wd);
		sa = new SoftAssert();
	}

	@AfterMethod
	public static void close() {
		wd.close();
	}

	//Test for navigating through women-summer dresses
	@Test
	public void navigationTest1() {
		wd.get(Navigation.HOME_PAGE_URL);										//Opening home page
		wd.manage().window().maximize();
		
		Navigation.openSubmenu(wd, Navigation.WOMEN_BTN_XPATH, act);			//Hovering women link
		Navigation.openSubmenu(wd, Navigation.WOMEN_SUBMENU_XPATH, act);		//Opening women submenu
		uspori();
		Navigation.clickLink(wd, Navigation.SUMMER_DRESSES_LINK_XPATH, act); 	//Clicking summer dresses link

		String current = wd.getCurrentUrl();									//Finding navigated page URL to test
		String expected = "http://automationpractice.com/index.php?id_category=11&controller=category";
																				//Setting URL of expected page
		boolean proveraURL = current.contains(expected);						//Checking if expected URL is part of the found one

		sa.assertTrue(proveraURL);												//Testing checking results
		sa.assertAll();

	}

	//Test for navigating through dresses-summer dresses
	@Test
	public void navigationTest2() {

		wd.get(Navigation.HOME_PAGE_URL);										//Opening home page
		wd.manage().window().maximize();
		
		Navigation.openSubmenu(wd, Navigation.DRESSES_BTN_XPATH, act);			//Hovering dresses link
		Navigation.openSubmenu(wd, Navigation.DRESSES_SUBMENU_XPATH, act);		//Opening dresses submenu
		uspori();
		Navigation.clickLink(wd, Navigation.SUMMER_DRESSES_LINK2_XPATH, act);	//Clicking summer dresses link

		String current = wd.getCurrentUrl();									//Finding navigated page URL to test
		String expected = "http://automationpractice.com/index.php?id_category=11&controller=category";
																				//Setting URL of expected page
		boolean proveraURL = current.contains(expected);						//Checking if expected URL is part of the found one

		sa.assertTrue(proveraURL);												//Testing checking results
		sa.assertAll();

	}

	//Test for comparing different paths to summer dresses
	@Test
	public void navigationTest3() {

		wd.get(Navigation.HOME_PAGE_URL);
		wd.manage().window().maximize();
		Navigation.openSubmenu(wd, Navigation.WOMEN_BTN_XPATH, act);
		Navigation.openSubmenu(wd, Navigation.WOMEN_SUBMENU_XPATH, act);
		Navigation.clickLink(wd, Navigation.SUMMER_DRESSES_LINK_XPATH, act);
		String current1 = wd.getCurrentUrl();

		wd.get(Navigation.HOME_PAGE_URL);
		wd.manage().window().maximize();
		Navigation.openSubmenu(wd, Navigation.DRESSES_BTN_XPATH, act);
		Navigation.openSubmenu(wd, Navigation.DRESSES_SUBMENU_XPATH, act);
		Navigation.clickLink(wd, Navigation.SUMMER_DRESSES_LINK2_XPATH, act);

		String current2 = wd.getCurrentUrl();
		sa.assertEquals(current1, current2);
		sa.assertAll();
	}

	public static void uspori() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
