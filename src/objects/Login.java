package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Login {

	public static final String HOMEPAGE_URL = "http://automationpractice.com/index.php";
	
	public static final String LOGINBTN_XPATH = "//a[@class='login']";
	
	public static final String EMAILINPUTFIELD_XPATH = "//input[@id='email']";
	
	public static final String PASSWERINPUTFIELD_XPATH = "//input[@id='passwd']";
	
	public static final String SIGNINBTN_NAME = "SubmitLogin";
	
	
	//Method for opening and filling login section form on login page-entering email and password
	public static void logIn(WebDriver wd, int i) {

		wd.findElement(By.xpath(LOGINBTN_XPATH)).click();
		wd.findElement(By.xpath(EMAILINPUTFIELD_XPATH)).sendKeys(Registration30.getData(i, 0));
		wd.findElement(By.xpath(PASSWERINPUTFIELD_XPATH)).sendKeys(Registration30.getData(i, 3));
		wd.findElement(By.name(SIGNINBTN_NAME)).click();
	}
	
	
			
	
}
