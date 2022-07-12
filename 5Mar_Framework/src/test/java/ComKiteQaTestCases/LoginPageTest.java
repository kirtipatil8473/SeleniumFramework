package ComKiteQaTestCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Com.kite.qa.base.TestBase;
import Com.kite.qa.pages.HomePage;
import Com.kite.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	
	
	public LoginPageTest() throws IOException {
		super();
		
	}
	 public static Logger log = LogManager.getLogger(TestBase.class.getName());
	@BeforeMethod
	
	public void setup() throws IOException {
		
		initialization(); 
		log.info("Driver is initialized");
		
		loginpage = new LoginPage();
		log.info("Loginpage object");
	}
	
	 @Test(priority=2)
	 public void HomePageTitleTest() throws InterruptedException {
			String Title = loginpage.ValidateLoginPageTitle(props.getProperty("username"), props.getProperty("password"), props.getProperty("pin"));
			Assert.assertEquals(Title, "ite - Zerodha's fast and elegant flagship trading platform");
		}
	 @Test(priority=3)
	 public void KiteUserID() throws InterruptedException {
		boolean UserID= loginpage.validateKiteloginUserID(props.getProperty("username"), props.getProperty("password"), props.getProperty("pin"));
		Assert.assertTrue(true);
		
     }
	
	 @Test(priority=1)
	 public void loginTest() throws InterruptedException, IOException {
	HomePage homepage=loginpage.login(props.getProperty("username"), props.getProperty("password"), props.getProperty("pin"));
	Thread.sleep(5000);
	Assert.assertTrue(false);
	
	 }
	@AfterMethod
	public void teardown() throws InterruptedException {
		
		Thread.sleep(3000);
		driver.quit();
	}
	
}
