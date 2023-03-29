package testng;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class retryanalyserpractice {

	@Test(retryAnalyzer=vtiger.GenericUtilities.retryAnalyserImplementation.class)
	public void practice()
	{
		Assert.fail();
		System.out.println("hello");
		
	}
}
