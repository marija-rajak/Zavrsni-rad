package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Navigation {

	public static final String HOME_PAGE_URL = "http://automationpractice.com/index.php";

	public static final String WOMEN_BTN_XPATH = "//a[@class='sf-with-ul'][contains(text(),'Women')]";

	public static final String WOMEN_SUBMENU_XPATH = "//body[@id='index']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[1]/ul[1]";

	public static final String DRESSES_SUBMENU_XPATH = 
"//body[@id='index']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/ul[1]";
	
	public static final String SUMMER_DRESSES_LINK_XPATH = "//ul[@class='submenu-container clearfix first-in-line-xs']//ul//li//a[contains(text(),'Summer Dresses')]";
	
	public static final String SUMMER_DRESSES_LINK2_XPATH = "//body[@id='index']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li/ul[@class='submenu-container clearfix first-in-line-xs']/li[3]/a[1]";

	public static final String DRESSES_BTN_XPATH = "//body[@id='index']/div[@id='page']/div[@class='header-container']/header[@id='header']/div/div[@class='container']/div[@class='row']/div[@id='block_top_menu']/ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a[1]";

	//Method for opening section of submenu
	public static void openSubmenu(WebDriver wd, String xpath, Actions act) {
		act.moveToElement(wd.findElement(By.xpath(xpath))).perform();
	}
	
	//Method for clicking link in submenu
	public static void clickLink(WebDriver wd, String xpath, Actions act) {
		act.moveToElement(wd.findElement(By.xpath(xpath))).click().perform();
	}

}
