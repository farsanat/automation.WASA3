package vtiger.OrganizationTests;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtiger.GenericUtilities.BaseClass;
import vtiger.ObjectRepository.createNewOrganisationpage;
import vtiger.ObjectRepository.createOrgInformationpage;
import vtiger.ObjectRepository.createOrganisationpage;
import vtiger.ObjectRepository.homePage;
@Listeners(vtiger.GenericUtilities.ListnersImplementation.class)
public class createorgTest extends BaseClass
{
	@Test()


	public void createorgTest() throws IOException 
	{
		
/* Read data from excel sheet - Test data */
		String ORGNAME = eutil.readDataFromExcel("organisation", 1, 2)+jutil.getRandomNumber();

//step 3: Navigate to Organizations link
homePage hp=new homePage(driver);
hp.clickonconLnk();
hp.clickonmarketngLnk();
hp.clickorganisationLnk();

//click on Create Organization look Up Image
createOrganisationpage cop=new createOrganisationpage(driver);
cop.clickonOrglookup();
Reporter.log("Create Organization look Up Image succesful");
 //Create Organization with Mandatory fields
createNewOrganisationpage cno=new createNewOrganisationpage(driver);
cno.createorg(ORGNAME);
Reporter.log("Create Organization with Mandatory fields succesful");

// Step 8: Validate
createOrgInformationpage coip=new createOrgInformationpage(driver);
String orgHeader = coip.getorgheader();
Assert.assertTrue(orgHeader.contains(ORGNAME));
System.out.println(orgHeader+" --- Organization created");

    }

}
