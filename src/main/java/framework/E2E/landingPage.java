package framework.E2E;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {

	public WebDriver driver1;

	By login = By.cssSelector(".theme-btn.register-btn");
	By titl1 = By.xpath("//h2[contains(text(),'Featured Courses')]");
	By navigation1 = By.xpath("//header/div[2]/div[1]/div[1]/div[2]");
	
	public landingPage(WebDriver driver1) {
		// TODO Auto-generated constructor stub
		this.driver1=driver1;
	}

	
	
	

	public WebElement login()
	{
		return driver1.findElement(login);
	}
	public WebElement title()
	{
		return driver1.findElement(titl1);
	}
	public WebElement nav()
	{
		return driver1.findElement(navigation1);
	}
}
