package TestCases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.AutoSuggestionPage;
import pages.HomePage;
import pages.SearchFunctionalityPage;
import testBase.TestBase;

public class AutoSuggestiveTest extends TestBase{

	SearchFunctionalityPage searchPage;
	AutoSuggestionPage dropdown;
	HomePage homepage;
	public AutoSuggestiveTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		dropdown=new AutoSuggestionPage();
	}
	
	
	@Test
	public void verifyAutoSuggestionTest() throws InterruptedException{
		String title=dropdown.searchRequest(prop.getProperty("substring"));
		System.out.println("Auto-Suggestive Link opened for "+title);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
