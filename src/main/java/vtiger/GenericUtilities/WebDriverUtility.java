 package vtiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WebDriverUtility {
	/**
	 * this method maximize window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * this method minimize window
	 * @param driver
	 */
	public void minimiziWindow(WebDriver driver)
	{
		 driver.manage().window().maximize();
	}
	/**
	 * this method wait for page
	 * @param driver
	 * @param element
	 */
	public void waitForPage(WebDriver driver)
	{
		long time = 2000;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	/**
	 * this method wait until the element will visible
	 * @param driver
	 * @param element
	 */
	public void waitforElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	/**
	 * this method wait until the element will clickable
	 * @param driver
	 * @param element
	 */
	public void waitforElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	/**
	 * This method will handle the drop down based on index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	/**
	 * This method will handle the drop down based on value
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * This method will handle dropdown based on visible text
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text, WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * This method will perform mouse hover action
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform right click anywhere in web page
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will perform right click on a web element
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}
	
	/**
	 * This method will perform double click anywhere on web page
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will perform double click on a web element
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param srcElement
	 * @param dstElement
	 */
	public void dragAndDropAction(WebDriver driver, WebElement srcElement, WebElement dstElement)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(srcElement, dstElement).perform();
	}
	
	/**
	 * This method will aceept the alert
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 * This method will dismiss the alert
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will capture the text from Alert popup
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	
	/**
	 * This method will handle frame based on index
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will handle frame based on name or ID
	 * @param driver
	 * @param nameOrId
	 */
	public void handleFrame(WebDriver driver, String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	
	/**
	 * This method will handle frame based on web element
	 * @param driver
	 * @param element
	 */
	public void handleFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will switch to immediate parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * This method will switch to default frame
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * this method will switch the child window
	 * @param driver
	 * @param partial
	 */
	public void switchwindow(WebDriver driver,String partial)
	{
		//capture all window ids
		Set<String> winids = driver.getWindowHandles();
		//navigate to each window and 
		for(String win:winids)
		{
			//switch window and capture the title
			String wintitle = driver.switchTo().window(win).getTitle();
			//compare the title with required partial title
			if(wintitle.contains(partial))
			{
				break;
			}
		}
		
	}
	/**
	 * this method take screenshot and save it in file
	 * @param driver
	 * @param scrshot
	 * @return
	 * @throws IOException 
	 */
	public String screenshot(WebDriver driver,String scrshot) throws IOException
	{
		TakesScreenshot	scrsh= (TakesScreenshot)driver;
		File src=scrsh.getScreenshotAs(OutputType.FILE);
		File dest=new File(".//screenshot//"+scrshot+".png");
		FileUtils.copyFile(src, dest);
		return dest.getAbsolutePath();//used for extend reports..
		
		
	}
	/**
	 * this method will perform random scroll downwards vertically
	 * @param driver
	 */
	public void scrollaction(WebDriver driver)
	{
	JavascriptExecutor	js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,500)", "");
	
	
	}
	/**
	 * this method will sroll until the element is identified in DOM
	 * @param driver
	 * @param element
	 */
	public void scrollaction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor	js=(JavascriptExecutor)driver;	
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")",element);
		
	}
	
	
}
