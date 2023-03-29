package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createNewContactpage {
	//rule1:create pom class for every web page
	//rule2:identify the web elements with @findBy,@findAll and findBys
	@FindBy(id="Contacts_editView_fieldName_lastname")
	private WebElement lastnameTxt;
	@FindBy(xpath="//button[@type='submit']")
		private WebElement submitBtn;	
	@FindBy(name="industry")
	private WebElement industryDropdwn;
	
	//rule3:create a constructor to initialize these web elements
	public createNewContactpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//rule4:provide getters to access these elements
	public WebElement getLastnameTxt() {
		return lastnameTxt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public WebElement getIndustryDropdwn() {
		return industryDropdwn;
	}
	//buisness libraries
	public void createContact (String lastname)
	{
		lastnameTxt.sendKeys(lastname);
		submitBtn.click();
	}
	
	public void createContact (String lastname,String industry)
	{
		lastnameTxt.sendKeys(lastname,industry);
		
		submitBtn.click();
	}

	

}
