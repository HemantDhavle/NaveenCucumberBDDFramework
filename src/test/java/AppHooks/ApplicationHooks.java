package AppHooks;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driverFactory.browserUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks 
{
	private Properties prop;
	private WebDriver driver;
	private browserUtility bUtility;
	
	@Before
	public void setUp()
	{
		bUtility = new browserUtility();
		prop = bUtility.init_property();
		driver = bUtility.init_driver(prop);
	}
	
	//this code for to take screenshot when tc failed
	@After(order=1)
	public void takeScreenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
		
			String screenshotName= scenario.getName().replaceAll(" ", "_");
			byte[] srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(srcFile, "image/png", screenshotName);
		}
	}
	
	@After(order=0)
	public void tearDown()
	{
		driver.quit();
	}

}
