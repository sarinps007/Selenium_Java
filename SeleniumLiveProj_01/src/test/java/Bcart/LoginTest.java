package Bcart;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.Base;

public class LoginTest extends Base{
	
public WebDriver driver;

	@BeforeTest
	public void initialise() throws IOException
	{
		driver = callDriver();
		
	}		
	
	@Test(dataProvider="getData")
	public void login(String Username,String Password) throws IOException
	{
		  LoginPage lg = new LoginPage(driver);
		  lg.username().sendKeys(Username);
		  lg.password().sendKeys(Password);
		  lg.login().click();
		 
		  
	}
	
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
	
	@DataProvider
	public Object[][] getData()
	{
		
		Object[][] data=new Object[1][2];
		//0th row
		data[0][0]="Admin";
		data[0][1]="admin123";
		return data;
			
	}
	

}
