package practice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class sample5 {

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
		//Step 3:Navigate to Contacts Link
		driver.findElement(By.id("appnavigator")).click();
		driver.findElement(By.xpath("//div[@class='menu-item app-item dropdown-toggle app-item-color-MARKETING']")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&view=List&app=MARKETING']")).click();
		//Step 4:Click on create contact look up image
		driver.findElement(By.id("Contacts_listView_basicAction_LBL_ADD_RECORD")).click();
		//Step 5: Create contact with mandatory fields and save
		driver.findElement(By.id("Contacts_editView_fieldName_lastname")).sendKeys("zannu");
		//select the source of apparel and select partner
		Select dropdown = new Select(driver.findElement(By.name("leadsource")));
	       dropdown.selectByVisibleText("Partner");
	       //click the save
	       driver.findElement(By.xpath("//button[@type='submit']")).click();
	       //Step 7: Logout of Application
			 driver.findElement(By.xpath("//span[@class='fa fa-user']")).click();
			 driver.findElement(By.linkText("Çıkış")).click();
				System.out.println("Sign out successfull");
	}

}
