package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.elementUtils;

public class accountPage 
{
	private WebDriver driver;
	private elementUtils elUtils;
	
	public accountPage(WebDriver driver)
	{
		this.driver=driver;
		elUtils = new elementUtils(driver);
	}
	
	private By accountPageHeader = By.xpath("//*[@id='center_column']/h1");
	private By accountSectionList = By.cssSelector("#center_column span");
	public String doValidateAccountSectionHeader()
	{
		return elUtils.getElement(accountPageHeader).getText();
	}
	
	public int getAccountSectionCount()
	{
		System.out.println(elUtils.getElements(accountSectionList).size());
		return elUtils.getElements(accountSectionList).size();
	}
	
	public List<String> getAccountSectionList()
	{
		List<WebElement> list=elUtils.getElements(accountSectionList);
		List<String> textList = new ArrayList<>();
		
		for(WebElement e:list)
		{
			String text = e.getText();
			
			textList.add(text);
			System.out.println(text);
		}
		return textList;
	}
}
