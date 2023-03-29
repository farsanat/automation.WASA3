package vtiger.OrganizationTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.createNewOrganisationpage;
import vtiger.ObjectRepository.createOrgInformationpage;
import vtiger.ObjectRepository.createOrganisationpage;
import vtiger.ObjectRepository.homePage;
//@Listeners(vtiger.GenericUtilities.ListnersImplementation.class)
public class organizusingdataproviderTest extends BaseClass{
	
	@Test(dataProvider = "getData")
	public void createMultipleOrgTest(String Org, String industry)
	{
		String ORGNAME = Org+jutil.getRandomNumber();
		//home page
		homePage hp=new homePage(driver);
		hp.clickonconLnk();
		hp.clickonmarketngLnk();
		hp.clickorganisationLnk();
		//click on Create Organization look Up Image
		createOrganisationpage cop=new createOrganisationpage(driver);
		cop.clickonOrglookup();
		//Create Organization with Mandatory fields
		createNewOrganisationpage cno=new createNewOrganisationpage(driver);
		cno.createorg(ORGNAME,industry);
		//validate
		createOrgInformationpage coip=new createOrgInformationpage(driver);
		String orgHeader = coip.getorgheader();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
	}
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		Object[][] data = eutil.readMultipleData("Multiples");
		return data;
	}
}
