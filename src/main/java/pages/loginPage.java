package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.elementUtils;

public class loginPage {

	private WebDriver driver;
	private elementUtils elUtils;

	public loginPage(WebDriver driver) 
	{
		this.driver = driver;
		elUtils = new elementUtils(driver);
	}
	
	private By userName = By.xpath("//*[@id='email']");
	private By password = By.xpath("//*[@id='passwd']");
	private By forgotLink = By.xpath("//*[@id='login_form']/div/p[1]/a");
	private By loginButton = By.xpath("//*[@id='SubmitLogin']");
	
	public String getPagetitle()
	{
		return elUtils.doGetPageTitle();
	}
	
	public Boolean doValidateForgotLink()
	{
		return elUtils.getElement(forgotLink).isDisplayed();
	}
	
	public void enterUserName(String userName)
	{
		elUtils.doSendKeys(this.userName, userName);
	}
	
	public void enterPassword(String password)
	{
		elUtils.doSendKeys(this.password, password);
	}
	
	public void clickLogin()
	{
		elUtils.doClick(loginButton);
	}
	
	public accountPage doLogin(String userName, String password)
	{
		elUtils.doSendKeys(this.userName, userName);
		elUtils.doSendKeys(this.password, password);
		elUtils.doClick(loginButton);
		return new accountPage(driver);
	}
}
