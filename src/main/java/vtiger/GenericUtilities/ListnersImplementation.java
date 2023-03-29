package vtiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
/**
 * this class contains implementation of itestlistners  interface testng
 * @author farsana
 *
 */

public class ListnersImplementation implements ITestListener {

	ExtentReports report;
 	ExtentTest test;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		
		System.out.println(methodname+"..........excution started");
		test = report.createTest(methodname);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
String methodname = result.getMethod().getMethodName();
		
test.log(Status.PASS, methodname+" --- PASS");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		WebDriverUtility wutil=new WebDriverUtility();
		javaUtility jutil=new javaUtility();
String methodname = result.getMethod().getMethodName();
test.log(Status.FAIL, methodname+" --- FAIL");
test.log(Status.INFO, result.getThrowable());
		
		
		String scrshot = methodname+"-"+jutil.getSystemDateInFormat();
		
         try
         {
        	 String path =wutil.screenshot(BaseClass.ddriver, scrshot);
			test.addScreenCaptureFromPath(path);
		} 
         catch (IOException e) 
         {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		
String methodname = result.getMethod().getMethodName();

test.log(Status.SKIP, methodname+" --- SKIP" );
test.log(Status.INFO, result.getThrowable());

		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("pgm exicuted");
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(".//ExtentReports//Report-"+new javaUtility().getSystemDateInFormat()+".html");
		htmlReport.config().setDocumentTitle("Vtiger Execution Reports");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("VTIGER EXECUTION REPORT");
		
		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base URL", "https://demo.vtiger.com/vtigercrm/index.php");
		report.setSystemInfo("Base Browser", "chrome");
		report.setSystemInfo("Reporter Name", "farsana");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
System.out.println("finished");
report.flush();
	}
	
	

}
