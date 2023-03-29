package vtiger.ContactTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import static org.testng.Assert.fail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

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
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.createContactInformationpage;
import vtiger.ObjectRepository.createContactpage;
import vtiger.ObjectRepository.createNewContactpage;
import vtiger.ObjectRepository.homePage;
@Listeners(vtiger.GenericUtilities.ListnersImplementation.class)
public class createcontacts  extends BaseClass{
	@Test(groups="SmokeSuit")
	
 
	public void createcontactsTest() throws IOException {
		// Step 1: Read all the necessary Data
				/* Read data from property File - Common Data */
		
		/* Read data from excel sheet - Test data */
		
		 String lastname = eutil.readDataFromExcel("contacts", 1, 2)+jutil.getRandomNumber();

		 
		//step 3: Navigate to Organizations link
		 homePage hp=new homePage(driver);
		 hp.clickonconLnk();
		 hp.clickonmarketngLnk();
			hp.clickoncontactsLnk();
			//Step 4:Click on create contact look up image
			createContactpage ccp=new createContactpage(driver);
			ccp.clickonContactBtn();
			//Step 5: Create contact with mandatory fields and save
			createNewContactpage cnc=new createNewContactpage(driver);
			cnc.createContact(lastname);
			//Step 8: Validate
			 createContactInformationpage cci= new  createContactInformationpage(driver);
			 String orgHeader =cci.createContact();
			 AssertJUnit.assertTrue(orgHeader.contains(lastname));
			 System.out.println(orgHeader+" --- Organization created");
			//driver.findElement(By.xpath("//button[text()='Sign in']")).click();
			//Step 3:Navigate to Contacts Link
			//driver.findElement(By.id("appnavigator")).click();
			//driver.findElement(By.xpath("//div[@class='menu-item app-item dropdown-toggle app-item-color-MARKETING']")).click();
			//driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&view=List&app=MARKETING']")).click();
			//Step 4:Click on create contact look up image
			//driver.findElement(By.id("Contacts_listView_basicAction_LBL_ADD_RECORD")).click();
			//Step 5: Create contact with mandatory fields and save
			//driver.findElement(By.id("Contacts_editView_fieldName_lastname")).sendKeys(value);
	       // driver.findElement(By.xpath("//button[@type='submit']")).click();
	      //Step 8: Validate
		       /*String orgHeader = driver.findElement(By.xpath("//span[@class='lastname']")).getText();
				if (orgHeader.contains(value)) 
				{
					System.out.println(orgHeader + " PASS");
				} else {
					System.out.println("FAIL");
				}*/
	      //Step 7: Logout of Application
			//driver.findElement(By.xpath("//span[@class='fa fa-user']")).click();
	        
			// driver.findElement(By.linkText("Sign Out")).click();
				//System.out.println("Sign out successfull");
			
	

		
		

	}
	@Test(groups="reggressionSuit" )
	public void demoscript()
	{
		System.out.println("demo passed");
		//Assert.fail();
		
	}
	@Test
	public void regional()
	
	{
		System.out.println("regional reggression");
	}

}
