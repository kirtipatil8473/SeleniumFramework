package DemoMavenPackage1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoMavenProject1 
{
	@Test
	public void demomessage()
	{
		System.out.println("Hello world");
	}
	@Test
	public void website()
	{
		System.setProperty("webdriver.chrome.driver","C:\\ChromeExe\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
	}
	@Test
	public void excel1() throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\ankit\\Desktop\\Uday-Project\\SeleniumData.xlsx");

		 
		Sheet sh = WorkbookFactory.create(file).getSheet("Sheet2");

		 int lastRowIndex = sh.getLastRowNum(); //Find the Index

		 for(int i=0; i<=lastRowIndex; i++)
		 {
		 String info =
		sh.getRow(i).getCell(1).getStringCellValue();
		 System.out.println(info);
		 } 
	}
}
