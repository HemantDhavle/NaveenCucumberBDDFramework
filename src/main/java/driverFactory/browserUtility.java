package driverFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class browserUtility {
	public static ThreadLocal<WebDriver> lt= new ThreadLocal<WebDriver>();
	public WebDriver driver;
	public Properties prop;
	public static String highlight;
	
	
	public WebDriver init_driver(Properties prop)
	{
		
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		highlight = prop.getProperty("highlight");
		
		optionManager om = new optionManager(prop);
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			lt.set(new ChromeDriver(om.chromeOption()));
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			lt.set(new FirefoxDriver(om.firefoxOption()));
		}
		else if (browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			lt.set(new EdgeDriver(om.edgeOption()));
		}
		else if (browserName.equalsIgnoreCase("safari"))
		{
			WebDriverManager.safaridriver().setup();
			lt.set(new SafariDriver());
		}
		else
		{
			System.out.println("Please pass the correct browser "+browserName );
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().fullscreen();
		/**
		 * call the URL
		 */
		URL url;
		try {
			url = new URL(prop.getProperty("url"));
			openURL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver()
	{
		return lt.get();
	}
	
	public Properties init_property()
	{
		prop = new Properties();
		FileInputStream fs = null;
		String envName= System.getProperty("env");
		try {
		if(envName==null)
		{
			System.out.println("We are running on production environment");
				fs = new FileInputStream("./src/test/resources/config/prod_config.properties");
		}
		else
		{
			switch(envName)
			{
			case "qa":
			System.out.println("We are running on qa environment");
			fs = new FileInputStream("./src/test/resources/config/qa_config.properties");
			break;
			
			case "int":
			System.out.println("We are running on int environment");
			fs = new FileInputStream("./src/test/resources/config/int_config.properties");
			break;
			
			default:
				System.out.println("Please pass the correct environment name");
			}
		}
		}
				 
		catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		try {
			prop.load(fs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		}
	public String getScreenshot()
	{
		File src = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dr")+"/screenshot/"+System.currentTimeMillis()+".png";
		File des = new File(path);
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
	}
	/**
	 * 
	 * @param url
	 * Handelling URL
	 */
	public void openURL(String url)
	{
		try
		{if(url==null) 
		{
			throw new Exception("Incorrect URL");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		getDriver().get(url);
	}
	public void openURL(URL url)
	{
		try
		{if(url==null) 
		{
			throw new Exception("Incorrect URL");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		getDriver().navigate().to(url);
	}
	
	public void openURL(String baseURL, String path, String queryParam)
	{
		try
		{if(baseURL==null) 
		{
			throw new Exception("Incorrect URL");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		getDriver().get(baseURL+"/"+path+"?"+queryParam);
	}
	

}
