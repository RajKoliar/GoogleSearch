package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class SearchFunctionalityPage extends TestBase{

	
	@FindBy(xpath="//input[@name='q']")
	WebElement searchBox;
	
	@FindBy(xpath="//div[@class='lJ9FBc']//input[1]")
	WebElement searchButton;
	
	public SearchFunctionalityPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateSearchPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage searchRequest(String search) {
		searchBox.sendKeys(search);
		searchButton.click();
		return new HomePage();
	}
}
