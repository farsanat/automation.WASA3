package vtiger.ContactTests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class createcontactsTest {
@Test

		public void createcontactTest() throws IOException {
			// Step 1: Read all the necessary Data
					/* Read data from property File - Common Data */
			FileInputStream fls=new FileInputStream("./src/test/resources/commom data.properties");
			Properties pro=new Properties();
			pro.load(fls);
			String browser=pro.getProperty("browser");
			String url=pro.getProperty("url");
			String username=pro.getProperty("username");
			String password=pro.getProperty("password");
			/* Read data from excel sheet - Test data */
			FileInputStream fls1=new FileInputStream("./src/test/resources/Untitled spreadsheet.xlsx");
			Workbook wb = WorkbookFactory.create(fls1);
			 String value = wb.getSheet("contacts").getRow(1).getCell(2).getStringCellValue();
			 WebDriver driver = null;

				// Step 2: Launch the browser - runtime polymorphism
				if (browser.equalsIgnoreCase("chrome"))
				{
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				}
				else if (browser.equalsIgnoreCase("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				}
				else 
				{
					System.out.println("Invalid Browser name");
				}
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get(url);
				driver.findElement(By.xpath("//button[text()='Sign in']")).click();
				//Step 3:Navigate to Contacts Link
				driver.findElement(By.id("appnavigator")).click();
				driver.findElement(By.xpath("//div[@class='menu-item app-item dropdown-toggle app-item-color-MARKETING']")).click();
				driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&view=List&app=MARKETING']")).click();
				//Step 4:Click on create contact look up image
				driver.findElement(By.id("Contacts_listView_basicAction_LBL_ADD_RECORD")).click();
				//Step 5: Create contact with mandatory fields and save
				driver.findElement(By.id("Contacts_editView_fieldName_lastname")).sendKeys(value);
		        driver.findElement(By.xpath("//button[@type='submit']")).click();
		      //Step 8: Validate
			       String orgHeader = driver.findElement(By.xpath("//span[@class='lastname']")).getText();
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



