package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;
import timeout.WaitPropertiesObject;

public class AutoSuggestionPage extends TestBase{

	public AutoSuggestionPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='q']")
	WebElement searchBox;
	
	
	public String searchRequest(String textfield) throws InterruptedException{
		searchBox.sendKeys(textfield);
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(WaitPropertiesObject.IMPLICIT_WAIT,TimeUnit.SECONDS);
		List<WebElement> options = driver.findElements(By.xpath("//ul/li"));
		for (int i = 1; i <= options.size(); i++) {
			String FromScreen = driver.findElement(By.xpath("//ul/li[" + i + "]")).getText();
			if (prop.getProperty("autoSuggestiveSearch").equalsIgnoreCase(FromScreen)) {
				driver.findElement(By.xpath("//ul/li[" + i + "]")).click();
				break;
			}
		}
		//String title=driver.getTitle();
		return driver.getTitle();
	}
}
