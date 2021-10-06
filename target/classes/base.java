package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {

	public WebDriver driver1;
	protected String url1;

	public WebDriver initialBrowserInfo() throws IOException {
		Properties por = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\91866\\eclipse-workspace\\E2E\\src\\main\\java\\resources\\browserinfo.properties");
		por.load(fis);
		String bname = por.getProperty("broswer");
		url1 = por.getProperty("url");
		System.out.println(bname);
		if (bname.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Varun\\Selenium\\Downloads\\Browser Driver\\chromedriver_win32\\chromedriver.exe");
			driver1 = new ChromeDriver();
		} else if (bname.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Varun\\Selenium\\Downloads\\Browser Driver\\geckodriver-v0.30.0-win64\\geckodriver.exe");
			driver1 = new FirefoxDriver();
		}
		driver1.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver1;

	}

	public String getSS(String mname1,WebDriver driver1) throws IOException {

		File src = ((TakesScreenshot) driver1).getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "\\reports\\" + mname1 + ".png";
		FileUtils.copyFile(src, new File(dest));
		return dest;
	}

}
