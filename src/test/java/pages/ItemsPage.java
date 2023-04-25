package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.BrowserUtils;
import utilites.Driver;

public class ItemsPage {

	
	public ItemsPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy (xpath = "//h3[text()='Items']")
	public WebElement itemsPageHeaderText;

	@FindBy (xpath = "//button[text()=' Add Item']")
	public WebElement addItemButton;

	@FindBy (xpath = "//h3[text()='New Item']")
	public WebElement addItemPageHeaderText;

	@FindBy (xpath = "(//input[@type='text'])[2]")
	public WebElement addItemName;

	@FindBy (xpath = "//div[text()='Price ']//parent::label//following-sibling::div/input")
	public WebElement addItemPrice;

	@FindBy (xpath = "//div[text()='select unit']//preceding::input[1]")
	public WebElement addItemUnit;

	@FindBy (xpath = "//span[text()='pc']")
	public WebElement addItem_pc_unit;

	@FindBy (name = "description")
	public WebElement addItemDesciption;

	@FindBy (xpath = "//button[text()=' Save Item']")
	public WebElement saveItemButton;

	//a[text()='Soccer']
	
	
	@FindBy (xpath = "//h3[text()='Edit Item']")
	public WebElement editItemHeaderText;
	
	@FindBy (xpath = "//button[text()=' Update Item']")
	public WebElement updateButton;
	
	
	@FindBy (xpath = "//input[@class='font-base block w-full sm:text-sm border-gray-200 rounded-md text-black focus:ring-primary-400 focus:border-primary-400']")
	public WebElement filterNameBox;
	
	@FindBy (xpath = "//h3[text()='%s']")
	public WebElement itemNameInItemsTable;
	
	@FindBy (xpath = "(//div[@class='relative inline-block h-full text-left'])[3]")
	public WebElement topItemThreeDots;
	
	
	//@FindBy (xpath = "//a[text()=' Delete']")
	//public WebElement filter3dotDeleteBtn;
	
	
	@FindBy (xpath = "(//a[normalize-space()='Delete'])[1]")
	public WebElement deleteButton;
	
	@FindBy (xpath = "//button[text()='Ok']")
	public WebElement deleteButtonConfirm;
	
	@FindBy (xpath = "//span[text()='No Results Found']")
	public WebElement filterNoResultsFoundMessage;
	
	
	@FindBy (xpath = "//th[contains(text(),'Name')]")
	public WebElement nameDisplays;
	
	@FindBy (xpath =  "//th[contains(text(),'Unit')])")
	public WebElement unitDisplays;
	
	@FindBy (xpath = "//th[contains(text(),'Price')]")
	public WebElement priceDisplays;
	
	@FindBy (xpath = " //th[contains(text(),'Added On')]")
	public WebElement addOnDisplays;  
	
	
	
	BrowserUtils utils = new BrowserUtils();
	public void createItem(String itemName, String itemPrice, String itemUnit, String itemDescription) {
		addItemName.sendKeys(itemName);
		addItemPrice.sendKeys(itemPrice);
		addItemUnit.click();
		utils.waitUntilElementVisible(addItem_pc_unit);
	    Driver.getDriver().findElement(By.xpath("//span[text()='"+itemUnit+"']")).click();
	    addItemDesciption.sendKeys(itemDescription);
	}
	

}
