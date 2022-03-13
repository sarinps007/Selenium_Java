package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LoginPage;


public class Base {
	// better practice is initialising webdriver here
	public WebDriver driver;
	public Properties prop;
	public WebDriver callDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Nithin\\eclipse-workspace\\LiveProj\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");
		String url = prop.getProperty("url");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\skillup\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\skillup\\geckodriver.exe");
			driver = new FirefoxDriver();
			 driver.get(url);
		} else if (browserName.equalsIgnoreCase("IE")) {

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;	

	}
	


	//login method
	public WebDriver login() throws IOException
	{
		driver = callDriver();
		
		LoginPage lg = new LoginPage(driver);
		try {
		lg.username().sendKeys(prop.getProperty("username"));
		lg.password().sendKeys(prop.getProperty("password"));
		lg.login().click();
		return driver;
		}
		catch(Exception e)
		{
	    return driver;
		}
		
	}

		public String getScreenshot(String TestcaseName, WebDriver driver) throws IOException {
		
			// TODO Auto-generated constructor stub
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+TestcaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;

	}

}
