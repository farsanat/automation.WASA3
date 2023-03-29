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

public class demo3 {

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
				String ORGNAME = eutil.readDataFromExcel("contacts",7,2);
				String ORGNAME1 = eutil.readDataFromExcel("contacts",7,3);
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
				//Step 3:Navigate to Contacts Link
				driver.findElement(By.id("appnavigator")).click();
				driver.findElement(By.xpath("//div[@class='menu-item app-item dropdown-toggle app-item-color-MARKETING']")).click();
				driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&view=List&app=MARKETING']")).click();
				//Step 4:Click on create contact look up image
				driver.findElement(By.id("Contacts_listView_basicAction_LBL_ADD_RECORD")).click();
				//Step 5: Create contact with mandatory fields and save
				driver.findElement(By.id("Contacts_editView_fieldName_lastname")).sendKeys(ORGNAME);
				//select the source of apparel and select partner
				Select dropdown = new Select(driver.findElement(By.name("leadsource")));
			       dropdown.selectByVisibleText(ORGNAME1);
			       //click the save
			       driver.findElement(By.xpath("//button[@type='submit']")).click();
			     //Step 8: Validate
			       String orgHeader = driver.findElement(By.xpath("//span[@class='lastname']")).getText();
					if (orgHeader.contains(ORGNAME)) 
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
