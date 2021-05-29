package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.TestBase;

public class SearchResultCountPage extends TestBase{
	
	@FindBy(id="result-stats")
	WebElement searchResultPagesCount;
	
	public SearchResultCountPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String PageResultCount() {
		String pageCount=searchResultPagesCount.getText();
		String[] arrOfStr = pageCount.split(" ", 4);
		return arrOfStr[1];
	}

	public String PageResultTime() {
		String pageCount=searchResultPagesCount.getText();
		String[] arrOfStr = pageCount.split(" ", 4);
		String value=arrOfStr[3].trim();
		String ResultTime=value.substring(1, value.length()-1);
		return ResultTime;
	}
}
