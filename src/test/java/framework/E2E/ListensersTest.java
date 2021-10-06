package framework.E2E;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.base;
import resources.extentReporting;

public class ListensersTest extends base implements ITestListener {
	ExtentReports extent1 = extentReporting.test2();
	ExtentTest test1;
	ThreadLocal<ExtentTest> et = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test1 = extent1.createTest(result.getMethod().getMethodName());
		et.set(test1);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		et.get().log(Status.PASS, "Passed!!");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		et.get().fail(result.getThrowable());
		WebDriver driver1=null;
		try {
			driver1=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver1").get(result.getInstance());
		} catch(Exception e)
		{
			
		}
		String mname = result.getMethod().getMethodName();
		try {
			et.get().addScreenCaptureFromPath(getSS(mname,driver1), result.getMethod().getMethodName());
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent1.flush();
	}

}
