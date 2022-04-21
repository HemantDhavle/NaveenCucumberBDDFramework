package utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class elementUtils 
{
	private WebDriver driver;
	public elementUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	public By getBy(String locatorType, String locatorValue)
	{
		By locator = null;
		switch (locatorType) {
		case "id":
			locator = By.id(locatorValue);
			break;
		case "name":
			locator = By.name(locatorValue);
			break;
		case "class":
			locator = By.className(locatorValue);
			break;
		case "xpath":
			locator = By.xpath(locatorValue);
			break;
		case "cssselector":
			locator = By.cssSelector(locatorValue);
			break;
		case "tagname":
			locator = By.tagName(locatorValue);
			break;
		case "partiallinktext":
			locator = By.partialLinkText(locatorValue);
			break;
		default:
			System.out.println("Please pass the correct locator");
			break;
		}
		return locator;
	}
	//handle single web element
	public WebElement getElement(String locatorType, String locatorValue)
	{
		return driver.findElement(getBy(locatorType, locatorValue));
	}
	
	public WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	
	//handle multiple web elements
	public List<WebElement> getElements(By locator)
	{
		return driver.findElements(locator);
	}
	
	public List<WebElement> getElements(String locatorType, String locatorValue)
	{
		return driver.findElements(getBy(locatorType, locatorValue));
	}
	
	//get text
	public String getText(By locator)
	{
		return driver.findElement(locator).getText();
	}
	
	public String getText(String locatorType, String locatorValue)
	{
		return driver.findElement(getBy(locatorType, locatorValue)).getText();
	}
	
	//click on web element
	public void doClick(By locator)
	{
		driver.findElement(locator).click();
	}
	public void doClick(String locatorType, String locatorValue)
	{
		driver.findElement(getBy(locatorType, locatorValue)).click();
	}
	
	//enter value into the text field
	public void doSendKeys(By locator, String value)
	{
		driver.findElement(locator).sendKeys(value);
	}
	
	public void doSendKeys(String locatorType, String locatorValue, String value)
	{
		driver.findElement(getBy(locatorType, locatorValue)).sendKeys(value);
	}
	
	//handle select drop down
	/**
	 * selecting value from a drop down using
	 * @param locator
	 * @param visibleText
	 */
	public void doSelectByVisibleText(By locator, String visibleText)
	{
		WebElement drop = getElement(locator);
		Select sel = new Select(drop);
		sel.selectByVisibleText(visibleText);
	}
	/**
	 * selecting value from a drop down using
	 * @param locator
	 * @param value
	 */
	public void doSelectByValue(By locator, String value)
	{
		WebElement drop = getElement(locator);
		Select sel = new Select(drop);
		sel.selectByValue(value);
	}
	
	/**
	 * selecting value from drop down using
	 * @param locator
	 * @param indexValue
	 */
	public void doSelectByIndex(By locator, int indexValue)
	{
		WebElement drop = getElement(locator);
		Select sel = new Select(drop);
		sel.selectByIndex(indexValue);
	}
	
	/**
	 * 
	 * @param locator
	 * @return
	 */
	public String doSelectDropDownAllOptions(By locator)
	{
		WebElement drop = getElement(locator);
		Select sel = new Select(drop);
		List<WebElement> options=sel.getOptions();
		String getOptions = null;
		for(WebElement e: options)
		{
			getOptions= e.getText();
		}
		return getOptions;
	}
	
	public boolean doElementDisplayed(By locator)
	{
		return getElement(locator).isDisplayed();
	}
	
	//Get attribute value
	public String getElementAttribute(By locator, String attName)
	{
		return getElement(locator).getAttribute(attName);
	}
	
	public String doGetPageTitle()
	{
		return driver.getTitle();
	}

}
