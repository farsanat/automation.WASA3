package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class createNewOrganisationpage extends WebDriverUtility 
{
	//decleration
	@FindBy(id="Accounts_editView_fieldName_accountname")
	private WebElement orgnameEdt;
	@FindBy(name="industry")
	private WebElement industryDropdwn;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement saveorgBtn;
	//initialization
	public createNewOrganisationpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//utilization
	public WebElement getOrgnameEdt() {
		return orgnameEdt;
	}
	public WebElement getIndustryDropdwn() {
		return industryDropdwn;
	}
	public WebElement getSaveorgBtn() {
		return saveorgBtn;
	}
	
	//buisness library
	/**
	 * this method will create organisation with orgname
	 * @param ORGNAME
	 */
	
	public void createorg(String ORGNAME)
	{
		orgnameEdt.sendKeys(ORGNAME);
		saveorgBtn.click();
	}
	/**
	 * this method will create organisation with organme and industry
	 * @param ORGNAME
	 * @param industry
	 */
	public void createorg(String ORGNAME,String industry)
	{
		orgnameEdt.sendKeys(ORGNAME);
	    handleDropdown(industryDropdwn,industry);
	    saveorgBtn.click();
	}
	
	

}
