package practice;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.GenericUtilities.javaUtility;
import vtiger.GenericUtilities.propertyfileutility;

public class demo4 {

	public static void main(String[] args) throws IOException {
		//create object for all utilities
		propertyfileutility putil=new propertyfileutility();
		ExcelFileUtility eutil=new ExcelFileUtility();
		WebDriverUtility wutil=new WebDriverUtility();
		javaUtility jutil=new javaUtility();
		// Step 1: Read all the necessary Data
		/* Read data from property File - Common Data */
		String URL = putil.readDataFromPropertyFile("url");
		String BROWSER = putil.readDataFromPropertyFile("browser");
		String USERNAME = putil.readDataFromPropertyFile("username");
		String PASSWORD = putil.readDataFromPropertyFile("password");
		// Step 2: Launch the browser - runtime polymorphism
		/* Read data from excel sheet - Test data */
		
		 String value = eutil.readDataFromExcel("campaigns", 1, 2);
		// value1=eutil.readDataFromExcel("campaigns", 1, 3);
		String value2=eutil.readDataFromExcel("campaigns", 4, 2);
		
		 WebDriver  driver = null;
		
		if (BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else 
		{
			System.out.println("Invalid Browser name");
		}
		wutil.maximizeWindow(driver);
		wutil.waitForPage(driver);
		driver.get(URL);
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		//Step 3:Navigate to Contacts Link
		driver.findElement(By.id("appnavigator")).click();
		driver.findElement(By.xpath("//div[@class='menu-item app-item dropdown-toggle app-item-color-MARKETING']")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Campaigns&view=List&app=MARKETING']")).click();
		//Step 4:Click on create campaigns look up image
		driver.findElement(By.id("Campaigns_listView_basicAction_LBL_ADD_RECORD")).click();
		//Step 5: Create campaigns with mandatory fields 
		driver.findElement(By.id("Campaigns_editView_fieldName_campaignname")).sendKeys(value);
		
		//create product from product look up image
		driver.findElement(By.xpath("//span[@class='input-group-addon createReferenceRecord cursorPointer clearfix']")).click();
		driver.findElement(By.id("Products_editView_fieldName_productname")).sendKeys(value2);
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		driver.findElement(By.xpath("//i[@class='fa fa-calendar ']")).click();
		driver.findElement(By.xpath("//td[@class='today day']")).click();
		//Step 8: Validate
		 driver.findElement(By.xpath("//button[@type='submit']")).click();
		 String orgHeader=driver.findElement(By.xpath("//span[@class='campaignname']")).getText();
		 if (orgHeader.contains(value)) 
			{
				System.out.println(orgHeader + " PASS");
			} else {
				System.out.println("FAIL");
			}
		//Step 7: Logout of Application
			driver.findElement(By.xpath("//span[@class='fa fa-user']")).click();
	        
			 driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("Sign out successfull");

	}

}
