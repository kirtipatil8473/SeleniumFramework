package ComKiteQaTestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Com.kite.qa.base.TestBase;
import Com.kite.qa.pages.HomePage;
import Com.kite.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	 public HomePageTest() throws IOException {
		super();
	
	}

	public static Logger log = LogManager.getLogger(TestBase.class.getName());
	
	LoginPage loginpage;
	HomePage homepage;
	
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization();	
		log.info("Driver is initialized");
		
		homepage = new HomePage();
		log.info("Loginpage object");
	}

	@Test	
	 public void HomepageTitle() throws InterruptedException {
			String Title = homepage.ValidateHomepageTitle(props.getProperty("username"), props.getProperty("password"), props.getProperty("pin"));
			 Assert.assertEquals(Title, "Kite - Zerodha's fast and elegant flagship trading platform");
		
	}
		
	@AfterMethod
	public void TearDown() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.quit();
	}

}
