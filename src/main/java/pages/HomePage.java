package pages;

import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class HomePage extends TestBase{
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public String validateNavigationPageTitle() {
		return driver.getTitle();
	}
}
