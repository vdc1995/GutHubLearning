package framework.E2E;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import resources.base;

public class landingTest extends base {


	public WebDriver driver1;
	@BeforeTest
	public void firstStep() throws IOException
	{
		driver1=initialBrowserInfo();
		driver1.get(url1);
	}
	
	
	
	
	@Test
	public void login1() throws IOException {
		
		landingPage l1 = new landingPage(driver1);
//Hello
		//Hey
		Assert.assertTrue(l1.nav().isDisplayed());
		Assert.assertEquals(l1.title().getText(), "Featured 12Courses");
	}
	
	@AfterTest
	public void lastStep()
	{
		driver1.close();
	}

}