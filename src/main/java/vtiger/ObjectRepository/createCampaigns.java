package vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createCampaigns {
	//rule1:create pom class for every web page
	//rule2:identify the webelements with @findBy,@findAll and findBys
@FindBy(id="Campaigns_listView_basicAction_LBL_ADD_RECORD")
private WebElement campaignsbtn;
//rule3:create a constructor to initialize these web elements
	public createCampaigns(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	//rule4:provide getters to access these elements
	public WebElement getCampaignsbtn() {
		return campaignsbtn;
	}
	//business libraries
	public void clickoncampaignsbtn()
	{
		campaignsbtn.click();
	}
		

}
