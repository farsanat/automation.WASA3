package vtiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtiger.GenericUtilities.WebDriverUtility;

public class homePage extends WebDriverUtility
{
	//rule1:create pom class for every web page
	//rule2:identify the webelements with @findBy,@findAll and findBys
@FindBy(id="appnavigator") private WebElement conlink;
@FindBy(xpath="//div[@class='menu-item app-item dropdown-toggle app-item-color-MARKETING']")
private WebElement marketingLnk;
//contacts
@FindBy(xpath="//a[@href='index.php?module=Contacts&view=List&app=MARKETING']")
private WebElement contactLnk;
//organisation
@FindBy(xpath="//a[@href='index.php?module=Accounts&view=List&app=MARKETING']")
private WebElement organisationLnk;
//campaigns
@FindBy(xpath="//a[@href='index.php?module=Campaigns&view=List&app=MARKETING']")
private WebElement campaignslnk;
//sign out
@FindBy(xpath="//span[@class='fa fa-user']")
private WebElement signLnk;

@FindBy(linkText="Sign Out") 
private WebElement signoutBtn;

//rule3:create a constructor to initialize these web elements
public homePage(WebDriver driver) 
{
PageFactory.initElements(driver,this);
}
//rule4:provide getters to access these elements

public WebElement getConlink() {
	return conlink;
}

public WebElement getMarketingLnk() {
	return marketingLnk;
}

public WebElement getContactLnk() {
	return contactLnk;
}

public WebElement getOrganisationLnk() {
	return organisationLnk;
}


public WebElement getCampaignslnk() {
	return campaignslnk;
}

public WebElement getSignLnk() {
	return signLnk;
}

public WebElement getSignoutBtn() {
	return signoutBtn;
}
//buisness libraries
public void clickonconLnk()
{
	conlink.click();
}
public void clickonmarketngLnk()
{
	marketingLnk.click();
}
public void clickoncontactsLnk()
{
	contactLnk.click();
}
public void clickorganisationLnk()
{
	organisationLnk.click();
}
public void clickoncampaignslnk()
{
	campaignslnk.click();
}
public void clicksignLnk()
{
	signLnk.click();
}
public void clicksignoutBtn()
{
	signoutBtn.click();
}


}
