package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createOrganisationpage {
	//decleration
	@FindBy(id="Accounts_listView_basicAction_LBL_ADD_RECORD")
	private WebElement orglookupImg;
	//initialization
	public createOrganisationpage(WebDriver driver) 
	{
	PageFactory.initElements(driver,this);
	}
	//utilization
	public WebElement getOrglookupImg() {
		return orglookupImg;
	}
	
	//buisness library
	public void clickonOrglookup()
	{
		orglookupImg.click();
	}
	

}
