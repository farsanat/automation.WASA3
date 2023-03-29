package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createContactInformationpage {
	//rule1:create pom class for every web page
		//rule2:identify the web elements with @findBy,@findAll and findBys
	@FindBy(xpath="//span[@class='lastname']")
	private WebElement contactLoohupImg;
	//initialization
	public createContactInformationpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//utilization
	public WebElement getContactLoohupImg() {
		return contactLoohupImg;
	}
	//buisness library
	
	public String createContact()
	{
		return contactLoohupImg.getText();
		
	}

}
