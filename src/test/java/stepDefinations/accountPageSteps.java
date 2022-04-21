package stepDefinations;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import driverFactory.browserUtility;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.accountPage;
import pages.loginPage;

public class accountPageSteps 
{
	loginPage login = new loginPage(browserUtility.getDriver());
	accountPage account;
	@Given("user already logged into the application")
	public void user_already_logged_into_the_application(DataTable dataTable) {
		List<Map<String, String>> credentials = dataTable.asMaps();
		String username = credentials.get(0).get("username");
		String password = credentials.get(0).get("password");
		account =login.doLogin(username, password);
		
	}

	@Given("user is on Account page")
	public void user_is_on_account_page() {
		String accountPageheader = account.doValidateAccountSectionHeader();
		System.out.println(accountPageheader);
	}


	@When("user gets the accounts section")
	public void user_gets_the_accounts_section(DataTable dataTable) 
	{
		List<String> actualListOfSections = dataTable.asList();
		List<String> expectedListOfSections = account.getAccountSectionList();
		Assert.assertTrue(actualListOfSections.containsAll(expectedListOfSections));
		
	}

	@Then("account section count should be {int}")
	public void account_section_count_should_be(Integer expectedSectionCount) {
		Integer actualSectionCount = account.getAccountSectionCount();
		Assert.assertTrue(actualSectionCount==expectedSectionCount);
	}

}
