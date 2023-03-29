package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createOrgInformationpage {

	//decleration
	@FindBy(xpath="//span[@class='recordLabel pushDown']")
	private WebElement orggetHeadertxt;
	
	//initialisation
	public createOrgInformationpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//utilization

	public WebElement getOrggetHeadertxt() {
		return orggetHeadertxt;
	}
	
	//buisness library
	/**
	 * this method will capture the text from org header and return to caller
	 * @return
	 */
	public String getorgheader()
	{
		return orggetHeadertxt.getText();
	}
}
