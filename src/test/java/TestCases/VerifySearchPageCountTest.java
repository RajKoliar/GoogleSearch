package TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchFunctionalityPage;
import pages.SearchResultCountPage;
import testBase.TestBase;

public class VerifySearchPageCountTest extends TestBase{

	SearchFunctionalityPage searchPage;
	SearchResultCountPage pagecount;
	public VerifySearchPageCountTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		pagecount=new SearchResultCountPage();
		searchPage=new SearchFunctionalityPage();
	}
	
	@Test(priority=1)
	public void displayPageResultCountTest() {
		searchPage.searchRequest(prop.getProperty("searchKeyword"));
		String PageResultCount=pagecount.PageResultCount();
		System.out.println("Pages Count displayed for "+prop.getProperty("searchKeyword") +" is "+PageResultCount);
	}
	
	@Test(priority=2)
	public void displayPageResponseTime() {
		searchPage.searchRequest(prop.getProperty("searchKeyword"));
		String PageResponseTime=pagecount.PageResultTime();
		System.out.println("Pages Response Time displayed for "+prop.getProperty("searchKeyword") +" is "+PageResponseTime);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
