package vtiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/*
 * *
 * this class provides implementation for iretryanalyser interface of testng
 */

public class retryAnalyserImplementation implements IRetryAnalyzer {
	int count=0;
	int retrycount=3;
	/**
	 * this method retry for 3 times
	 */
	public boolean retry(ITestResult result)
	{
		while(count<retrycount)
		{
			count++;
		return true;
		
		}
		return false;
		
	}
	
	

}
