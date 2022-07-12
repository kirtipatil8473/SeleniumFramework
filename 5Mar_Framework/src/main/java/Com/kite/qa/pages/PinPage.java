package Com.kite.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.kite.qa.base.TestBase;

public class PinPage extends TestBase{

	public PinPage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	
}
