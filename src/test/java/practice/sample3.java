package practice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class sample3 {

	public static void main(String[] args) {

		//Step 1: Launch the browser
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.get("https://demo.vtiger.com/vtigercrm/");
				//Step 2:Login to Application
				//driver.findElement(By.name("username")).sendKeys("admin");
				//driver.findElement(By.name("password")).sendKeys("Test@123");
				driver.findElement(By.xpath("//button[text()='Sign in']")).click();
				//step 3: Navigate to Organizations link
				driver.findElement(By.id("appnavigator")).click();
				driver.findElement(By.xpath("//div[@class='menu-item app-item dropdown-toggle app-item-color-MARKETING']")).click();
				driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&view=List&app=MARKETING']")).click();
				//click on Create Organization look Up Image
		       driver.findElement(By.id("Accounts_listView_basicAction_LBL_ADD_RECORD")).click();
		       //Create Organization with Mandatory fields
		       driver.findElement(By.id("Accounts_editView_fieldName_accountname")).sendKeys("sap");
		     
		       //Select "Chemicals" in the industry drop down
		       
		       Select dropdown = new Select(driver.findElement(By.name("industry")));
		       dropdown.selectByVisibleText("Chemicals");
		       //save and verify
		       driver.findElement(By.xpath("//button[@type='submit']")).click();
		     //Step 7: Logout of Application
				 driver.findElement(By.xpath("//span[@class='fa fa-user']")).click();
				 driver.findElement(By.linkText("Exit")).click();
					System.out.println("Sign out successfull");
			
		       
		       
	}

}
