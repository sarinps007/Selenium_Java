package Bcart;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pageObjects.Menu;
import resources.Base;


public class validateTitleTest extends Base{
  
	
	public WebDriver driver;
	
	@Test
	public void Validation() throws IOException, InterruptedException
	{
		  driver=login();
		  Menu m = new Menu(driver);
		  Assert.assertEquals(m.get_dashtitle().getText(),"Dashboard");
		 //Assert.assertTrue(m.get_dashtitle().isDisplayed());		  
	}	
	@AfterTest
	public void close()
	{
		driver.close();
	}
}
