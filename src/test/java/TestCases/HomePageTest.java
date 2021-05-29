package TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import pages.HomePage;
import testBase.TestBase;

public class HomePageTest extends TestBase{

	HomePage homePage;
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage=new HomePage();
	}
	
	@Test
	public void homePageTitleTest() {
		String title=homePage.validateHomePageTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Google");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
