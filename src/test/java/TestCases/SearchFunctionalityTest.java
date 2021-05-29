package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchFunctionalityPage;
import testBase.TestBase;

public class SearchFunctionalityTest extends TestBase{

	SearchFunctionalityPage searchPage;
	public SearchFunctionalityTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		searchPage=new SearchFunctionalityPage();
	}
	
	@Test
	public void searchRequestTest() {
		searchPage.searchRequest(prop.getProperty("searchKeyword"));
		String title=searchPage.validateSearchPageTitle();
		System.out.println(title);
		Assert.assertTrue(title.contains(prop.getProperty("searchKeyword")));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
