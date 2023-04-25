package utilites;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class  BrowserUtils{
 
	
	Actions action;
	Actions act;
	WebDriverWait wait;
	Select letsSelect;
	public void waitUntilElementVisible(WebElement element) {
		wait = new WebDriverWait(Driver.getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void actionsSendKeys(WebElement element, String text) {
		action = new Actions(Driver.getDriver());
		action.sendKeys(element, text).build().perform();
		
		
		
	}
	
	// using action class to click on an element
	public void actionsClick(WebElement element) {
		act = new Actions(Driver.getDriver());
		
	}
	// select by visible text
	public void selectByVisibleText(WebElement selectElement, String tobeSelectedOptionText) {
		letsSelect = new Select(selectElement);
		letsSelect.selectByVisibleText(tobeSelectedOptionText);
	}

	// select by value
		public void selectByValue(WebElement selectElement, String value) {
			letsSelect = new Select(selectElement);
			letsSelect.selectByValue(value);
		}
		
		// select by index
		public void selectByIndex(WebElement selectElement, int index) {
			letsSelect = new Select(selectElement);
			letsSelect.selectByIndex(index);
		}
	// return the selected option from the dropdown
	public String getSelectedOption(WebElement selectElement) {
		letsSelect = new Select(selectElement);
		String option = letsSelect.getFirstSelectedOption().getText();
		return option;
	}
	public int randomNumber() {
		Random rand = new Random();
		int randomNum = rand.nextInt((999 - 100) + 1) + 100;
		return randomNum;
	}
	
}
