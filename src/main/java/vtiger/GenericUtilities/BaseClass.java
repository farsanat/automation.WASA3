package vtiger.GenericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger.ObjectRepository.LoginPage;
import vtiger.ObjectRepository.homePage;

public class BaseClass {
	//create object for all utilities
			public propertyfileutility putil=new propertyfileutility();
			public ExcelFileUtility eutil=new ExcelFileUtility();
			public WebDriverUtility wutil=new WebDriverUtility();
			public javaUtility jutil=new javaUtility();
			public static WebDriver ddriver;
			public WebDriver driver;
			
			
			@BeforeSuite
			public void bsConfig()
			{
			   System.out.println("----- Database Connection successfull -----");
			}
			//@Parameters("browser")
			//@BeforeTest
			@BeforeClass(groups= {"SmokeSuit","reggressionSuit" })
			public void bcConfig(/*String BROWSER*/) throws IOException
			
			{
				String URL = putil.readDataFromPropertyFile("url");
				String BROWSER = putil.readDataFromPropertyFile("browser");
				// Step 2: Launch the browser - runtime polymorphism
				if (BROWSER.equalsIgnoreCase("chrome"))
				{
					ChromeOptions option = new ChromeOptions();
		            option.addArguments("--remote-allow-origins=*");

					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver(option);
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
				ddriver=driver;
				wutil.maximizeWindow(driver);
				wutil.waitForPage(driver);
				driver.get(URL);
			}
				@BeforeMethod(groups={"SmokeSuit","reggressionSuit" })
				public void bmConfig() throws IOException
				{
					String USERNAME = putil.readDataFromPropertyFile("username");
					String PASSWORD = putil.readDataFromPropertyFile("password");
					//login to app
					LoginPage lp=new LoginPage(driver);
					lp.clicksubmit();
					System.out.println("----- Login successful -----");

				}
				@AfterMethod(groups={"SmokeSuit","reggressionSuit" } )
				public void amConfig()
				{
					homePage hp=new homePage(driver);
					hp.clicksignLnk();
					hp.clicksignoutBtn();
				
					System.out.println("----- Logout successful -----");
				}
				@AfterClass(groups={"SmokeSuit","reggressionSuit" })
				public void acConfig()
				{
					driver.quit();
					System.out.println("----- Browser Closed successfully -----");
				}
				
				@AfterSuite(groups={"SmokeSuit","reggressionSuit" } )
				public void asConfig()
				{
					System.out.println("----- Database Connection successfull -----");
					
				}
			
			}
			
			
	


