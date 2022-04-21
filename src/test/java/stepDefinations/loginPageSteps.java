package stepDefinations;

import org.testng.Assert;

import driverFactory.browserUtility;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginPage;

public class loginPageSteps 
{
	private loginPage login = new loginPage(browserUtility.getDriver());
	private String pageTitle; 
	@Given("User is on login page")
	public void user_is_on_login_page() {
		
		pageTitle = login.getPagetitle();
		System.out.println(pageTitle);   
	}

	@When("User gets the title of the page")
	public void user_gets_the_title_of_the_page() {
	    pageTitle = login.getPagetitle();
	    System.out.println("title of the page is "+pageTitle);
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
		pageTitle = login.getPagetitle();
		Assert.assertTrue(pageTitle.contains(title));
	}

	@Then("Forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
	    Assert.assertTrue(login.doValidateForgotLink(), "ForgotPassword link is visible");
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
	    login.enterUserName(username);
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		login.enterPassword(password);
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
	    login.clickLogin();
	}



}
