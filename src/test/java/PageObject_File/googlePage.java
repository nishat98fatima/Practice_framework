package PageObject_File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utilitiy.ReadConfig;

public class googlePage {
	private BaseClass obj;

	public googlePage(BaseClass obj) throws Throwable {
		this.obj = obj;
	}

	String searchBar = "//input[@id='searchInput']";
	String button = "//button[@class='pure-button pure-button-primary-progressive']";

	public boolean enterurl() throws Throwable {
		boolean result = false;
		try {
			obj.driver.get(ReadConfig.get_from_config("URL"));
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

public boolean searchKeyword() throws Throwable {
	boolean result=false;
			try {
	WebElement search=obj.driver.findElement(By.xpath(searchBar));
	search.sendKeys(ReadConfig.get_from_config("SearchKeyword"));
	WebElement searchbutton=obj.driver.findElement(By.xpath(button));
	searchbutton.click();
	result=true;
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return result;
			
	
}
}
