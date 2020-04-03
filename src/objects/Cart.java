package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {

	public static final String CART_URL = "http://automationpractice.com/index.php?controller=order";
	
	public static final String SIZECOLORVALUE_XPATH = "//td[@class='cart_description']//a[contains(text(),'Color : Blue, Size : M')]";
		
	public static final String QUANTITYVALUE_XPATH = "//input[@name='quantity_5_24_0_0']";
	
	//Method for retrieving colour and size of ordered products-outprint is separated to elements, and only desired are used 
	public static String[] getSizeColour(WebDriver wd) {
		String temp = wd.findElement(By.xpath(SIZECOLORVALUE_XPATH)).getText();
		String[] temp2 = temp.split(" ");
		String size = temp2[5];
		String colour = temp2[2].substring(0, temp2[2].length()-1);
		String[] values = {size, colour};
		return values;
	}
	
	//Method for retrieving number of ordered products 
		public static String getQuantity(WebDriver wd) {
		return wd.findElement(By.xpath(QUANTITYVALUE_XPATH)).getAttribute("value");
	}
	
	
}
