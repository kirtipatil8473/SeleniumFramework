package Com.kite.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.kite.qa.base.TestBase;




  public class HomePage extends TestBase{
	  
	     public HomePage() throws IOException {
	    	 
	    	 PageFactory.initElements(driver, this);
	
	}


		@FindBy(xpath="//span[@class=\"user-id\"]")
		 WebElement UserID;
		 
		 @FindBy(xpath = "//a[contains(text(),' Coin')]")
		 WebElement ClickedUserID;
		 
		 @FindBy(xpath = "//span[contains(text(),'Positions')]")
		 WebElement Position;
		 
		 @FindBy(xpath ="//span[@class=\"nickname\"]")
		 WebElement Nickname;
		 
		 public String ValidateHomepageTitle(String UN,String PWD, String PIN) throws InterruptedException {
		    	
		    	Thread.sleep(2000);
		    	return driver.getTitle();
		    	
		      }
	     
	     
	     
	}
