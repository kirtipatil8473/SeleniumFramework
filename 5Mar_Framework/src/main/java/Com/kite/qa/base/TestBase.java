package Com.kite.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import Com.kite.qa.Util.TestUtil;
import net.bytebuddy.utility.RandomString;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties props;
	
	
	public TestBase() throws IOException {
		
		
		props = new Properties();
		
		FileInputStream ip =  new FileInputStream("C:\\Users\\ankit\\eclipse-workspace\\MavenProject2\\src\\main\\java\\com\\kite\\qa\\config\\confiq.properties");
		
		props.load(ip);
						
	}

	public static void initialization() {
		
		ChromeOptions option =new ChromeOptions();
		option.addArguments("--disable-notifications");
		
	    System.setProperty("webdriver.chrome.driver", "C:\\ChromeExe\\chromedriver.exe");
		
	     driver = new ChromeDriver(option);
	     
	     driver.manage().window().maximize();
	     
	     driver.manage().deleteAllCookies();
	     
	     driver.manage().timeouts().pageLoadTimeout(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	     
	     driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	     
	     driver.get(props.getProperty("url"));
		
	}
	
	
	 public  String getScreenShotPath(String testCaseName) throws IOException
	 
	 {
	
	 	TakesScreenshot ts= (TakesScreenshot) driver;
	 	
	 	File source = ts.getScreenshotAs(OutputType.FILE);
	 	
		String Random = RandomString.make(10);
		
	 	String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+""+Random+".png";
	 	
	 	FileUtils.copyFile(source,new File(destinationFile));
	 	return destinationFile;
	   }
	 }

	

