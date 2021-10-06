package framework.E2E;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.LogManager;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import resources.base;

public class HomeTest extends base{

	public static Logger log1 = LogManager.getLogger(base.class.getName());

	public WebDriver driver1;
	
	@BeforeMethod
	public void firstMethod() throws IOException
	{
		driver1=initialBrowserInfo();
		log1.info("Browser Initialised");
		driver1.get(url1);
		log1.info("URL Loaded into the Browser");
	}
	
	
	@Test(dataProvider="getData")
	public void loginHome(String username, String password1, String User) throws IOException
	{
		landingPage l1 = new landingPage(driver1);
		l1.login().click();
		log1.info("Login Link Clicked");
		loginPage l2 = new loginPage(driver1);
		log1.info(User);
		l2.username().sendKeys(username);
		log1.info("Username Entered");
		l2.password().sendKeys(password1);
		log1.info("Password Entered");
		l2.login1().click();
		log1.info("Sign In");
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][3];
		data[0][0] = "nonrestricteduser@gmail.com";
		data[0][1] = "123456";
		data[0][2] = "Non-Restricted USer";
		data[1][0] = "restricteduser@gmail.com";
		data[1][1] = "123456";
		data[1][2] = "Restricted User";
		return data;
	}
	
	@AfterMethod
	public void lastMethod()
	{
		driver1.close();
	}
	
}
