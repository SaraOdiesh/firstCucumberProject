package step_definitions;



import org.junit.Assert;
import org.openqa.selenium.Keys;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AmazonHomePage;
import utilites.BrowserUtils;
import utilites.Driver;

public class AmazonDepartmentsSteps {

	
	AmazonHomePage ahomepage = new AmazonHomePage();
	BrowserUtils utils = new BrowserUtils();
	String searchCriteria;
	@Given("I am on the amazon homepage")
	public void i_am_on_the_amazon_homepage() {
		Driver.getDriver().get("https://amazon.com");
		String homepageTitle = Driver.getDriver().getTitle();
		Assert.assertEquals(homepageTitle, "Amazon.com. Spend less. Smile more.");
	}

	@Given("The departments dropdown is {string}")
	public void the_departments_dropdown_is(String defaultOption) {
//	   Select letsSelect = new Select(ahomepage.departmentsDropdown);
//	   Assert.assertEquals(letsSelect.getFirstSelectedOption(), defaultOption);

		Assert.assertEquals(utils.getSelectedOption(ahomepage.departmentsDropdown), defaultOption);

	}

	@When("I select the department {string}")
	public void i_select_the_department(String optionToSelected) {
		utils.selectByVisibleText(ahomepage.departmentsDropdown, optionToSelected);
	}

	@When("I search {string}")
	public void i_search(String searchItem) {
		ahomepage.searchField.sendKeys(searchItem, Keys.ENTER);
	}

	@Then("I should be on {string} search result page")
	public void i_should_be_on_search_result_page(String searchedItem) {
		String searchPageTitle = Driver.getDriver().getTitle();
		Assert.assertTrue(searchPageTitle.contains(searchedItem));
	}

	

@When("I search {string} and click search")
public void i_search_and_click_search(String searchTerm) {
  ahomepage.searchField.sendKeys(searchTerm);
  ahomepage.searchButton.click();
	
}
@When("I wait for the search result page to load")
public void i_wait_for_the_search_result_page_to_load() {
	utils.waitUntilElementVisible(ahomepage.searchField);
}
@Then("I verify the search criteria text element matches")
public void i_verify_the_search_criteria_text_element_matches() {
	Assert.assertTrue(ahomepage.searchField.isDisplayed());
}
}
