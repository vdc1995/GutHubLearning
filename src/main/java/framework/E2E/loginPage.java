package framework.E2E;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {

	public WebDriver driver1;

	By uname = By.cssSelector("#email");
	By pwd = By.cssSelector("#password");
	By login1 = By.xpath("//input[@value='Login']");
	
	public loginPage(WebDriver driver1) {
		// TODO Auto-generated constructor stub
		this.driver1=driver1;
	}

	
	
	

	public WebElement username()
	{
		return driver1.findElement(uname);
	}
	public WebElement password()
	{
		return driver1.findElement(pwd);
	}
	public WebElement login1()
	{
		return driver1.findElement(login1);
	}
	
		

	
}
