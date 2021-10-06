package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReporting {
	static ExtentReports extent1;
	public static ExtentReports test2()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter report1 = new ExtentSparkReporter(path);
		report1.config().setDocumentTitle("Test Results");
		report1.config().setReportName("Automation Test Result");		
		extent1 = new ExtentReports();
		extent1.attachReporter(report1);
		extent1.setSystemInfo("QA", "Varun Dilip Changede");
		return extent1;
	}
}
