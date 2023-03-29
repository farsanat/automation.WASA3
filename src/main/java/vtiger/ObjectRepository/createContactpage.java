package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createContactpage {
	//rule1:create pom class for every web page
			//rule2:identify the webelements with @findBy,@findAll and findBys
	
	@FindBy(id="Contacts_listView_basicAction_LBL_ADD_RECORD")
	private WebElement contactBtn;
	//rule3:create a constructor to initialize these web elements
	public createContactpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//rule4:provide getters to access these elements
	public WebElement getContactBtn() {
		return contactBtn;
	}
	//buisness library
	public void clickonContactBtn()
	{
		contactBtn.click();
	}
	

}
