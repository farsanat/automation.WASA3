package practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.ExcelFileUtility;
import vtiger.GenericUtilities.WebDriverUtility;
import vtiger.GenericUtilities.javaUtility;
import vtiger.GenericUtilities.propertyfileutility;

public class demo2 {

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
		/* Read data from excel sheet - Test data */
		String ORGNAME = eutil.readDataFromExcel("organisation", 4, 2)+jutil.getRandomNumber();
WebDriver driver = null;

// Step 2: Launch the browser - runtime polymorphism
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
//step 3: Navigate to Organizations link
driver.findElement(By.id("appnavigator")).click();
driver.findElement(By.xpath("//div[@class='menu-item app-item dropdown-toggle app-item-color-MARKETING']")).click();
driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&view=List&app=MARKETING']")).click();
//click on Create Organization look Up Image
driver.findElement(By.id("Accounts_listView_basicAction_LBL_ADD_RECORD")).click();
//Create Organization with Mandatory fields
driver.findElement(By.id("Accounts_editView_fieldName_accountname")).sendKeys("ORGNAME");

//Select "Chemicals" in the industry drop down

Select dropdown = new Select(driver.findElement(By.name("industry")));
dropdown.selectByVisibleText("Chemicals");
//save and verify
driver.findElement(By.xpath("//button[@type='submit']")).click();
//Step 7: Logout of Application
 driver.findElement(By.xpath("//span[@class='fa fa-user']")).click();
 driver.findElement(By.linkText("Sign Out")).click();
	System.out.println("Sign out successfull");

	}

}
