package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterCommonPage;
import pages.ItemsPage;
import pages.LoginPage;
import utilites.BrowserUtils;
import utilites.DataReader;
import utilites.Driver;

public class ItemsManagmentSteps {

     LoginPage loginpage = new LoginPage();
     ItemsPage itemsPage = new ItemsPage();
     CraterCommonPage commonPage = new CraterCommonPage();
     BrowserUtils utils =new BrowserUtils();
     

	String itemName;

	@Given("As an entity user, I am logged in")
	public void as_an_entity_user_i_am_logged_in() {
		Driver.getDriver().get(DataReader.getProperty("appUrl"));
		loginpage.login();
	}

	@Given("I navigate to Items tab")
	public void i_navigate_to_items_tab() {
		commonPage.itemsLink.click();
		Assert.assertTrue(itemsPage.itemsPageHeaderText.isDisplayed());
	}

	@When("I click on the Add Item button")
	public void i_click_on_the_add_item_button() {
		itemsPage.addItemButton.click();
	}

	@Then("I should be on item input page")
	public void i_should_be_on_item_input_page() {
		Assert.assertTrue(itemsPage.addItemPageHeaderText.isDisplayed());
	}

	@When("I provide item information name {string}, price {int}, unit {string}, and description {string}")
	public void i_provide_item_information_name_price_unit_and_description(String name, Integer price, String unit,
			String description) {
		itemName = name;
		itemsPage.addItemName.sendKeys(name);
		itemsPage.addItemPrice.sendKeys(price.toString());
		itemsPage.addItemUnit.click();
		utils.waitUntilElementVisible(itemsPage.addItem_pc_unit);
		Driver.getDriver().findElement(By.xpath("//span[text()='" + unit + "']")).click();

		itemsPage.addItemDesciption.sendKeys(description);
	}

	@When("I click Save Item button")
	public void i_click_save_item_button() {
		itemsPage.saveItemButton.click();
	}

	@Then("The Item is added to the Item list table")
	public void the_item_is_added_to_the_item_list_table() {
		Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//a[text()='" + itemName + "']")).isDisplayed());
		
	}
	
@When("I select the item {string}")
public void i_select_the_item(String string) {
	Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//a[text()='" + itemName + "']")).isDisplayed());
	
}
@When("I should be on item details page")
public void i_should_be_on_item_details_page() {
Assert.assertTrue(false);
}
@When("I update the item price to {int} dollars")
public void i_update_the_item_price_to_dollars(Integer price) {
    itemsPage.addItemPrice.clear();
    //itemsPage.addItemPrice.sendKeys(price,toString());
}
@When("I click Update Item button")
public void i_click_update_item_button() {

}
@Then("the Item price is updated to {int} dollars")
public void the_item_price_is_updated_to_dollars(Integer int1) {
   
}
}
