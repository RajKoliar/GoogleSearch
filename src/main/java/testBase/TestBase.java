package testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import timeout.WaitPropertiesObject;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\Ponraj Koliar\\workspace\\NewEclipse\\GoogleSearchFunctionalityTest\\src\\main\\java\\globalTestData\\ConfigProperties");
					//"C:\\Users\\Ponraj Koliar\\workspace\\NewEclipse\\MakeMyTrip\\src\\main\\java\\globalTestData\\ConfigProperties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\MyPrograams\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(WaitPropertiesObject.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(WaitPropertiesObject.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
