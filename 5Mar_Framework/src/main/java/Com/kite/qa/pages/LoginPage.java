package Com.kite.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.kite.qa.base.TestBase;

public class LoginPage extends TestBase{

	
	//PageFactory
	@FindBy(id ="userid")
	WebElement Username;	
//	driver.fndelement(By.id("userid"));
	
	@FindBy(id="password")
	WebElement Password;
		
	@FindBy(xpath ="//button[@type=\"submit\"]")
	WebElement LoginButton;
	
	@FindBy(id="pin")
	WebElement Pin;
	   
	@FindBy(xpath ="//button[@type=\"submit\"]")
	 WebElement ContinueButton;
	
	@FindBy(xpath ="//span[contains(text(),'GP8097')]")
	WebElement UserID2;
	
	
	//Initializing the page object
	public LoginPage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	
public String ValidateLoginPageTitle(String UN,String PWD, String PIN) throws InterruptedException {
    	
    	Thread.sleep(2000);
    	return driver.getTitle();
    	
      }
      
      public boolean validateKiteloginUserID(String UN,String PWD, String PIN) throws InterruptedException {
    	  Username.sendKeys(UN);
    	  Thread.sleep(2000);
    	  Password.sendKeys(PWD);
    	  Thread.sleep(2000);
    	  LoginButton.click();
    	  Thread.sleep(2000);
    	  Pin.sendKeys(PIN);
    	  Thread.sleep(2000);
    	  ContinueButton.click();
   	  
    	  return UserID2.isDisplayed();
    	  
      }     
      
      public HomePage login(String UN,String PWD, String PIN) throws InterruptedException, IOException {
    	  Username.sendKeys(UN);
    	  Thread.sleep(2000);
    	  Password.sendKeys(PWD);
    	  Thread.sleep(2000);
    	  LoginButton.click();
    	  Thread.sleep(2000);
    	  Pin.sendKeys(PIN);
    	  Thread.sleep(2000);
    	  ContinueButton.click();  	  
    	  return new HomePage();
      }
	
}