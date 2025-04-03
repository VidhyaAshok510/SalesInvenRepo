package com.salesinventory.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage {
	WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-target='#aModal']")
	private WebElement addProductBtn;
	@FindBy(name = "prodcode")
	private WebElement productcodeText;
	@FindBy(name = "name")
	private WebElement productNameText;  
	@FindBy(xpath = "//textarea[@placeholder='Description']")
	private WebElement productDescText;
	@FindBy(name = "quantity")
	private WebElement productQuantText;
	@FindBy(name = "onhand")
	private WebElement productOnHandText;
	@FindBy(name = "price")
	private WebElement productPriceText;
	@FindBy(name = "category")
	private WebElement productCateogyDrop;
	@FindBy(name = "supplier")
	private WebElement productSupplierDrop;
	@FindBy(xpath = "//input[@placeholder='Date Stock In']")
	private WebElement dateInStockText;
	@FindBy(xpath = "(//button[@class='btn btn-success'])[5]")
	private WebElement saveBtn;
	@FindBy(xpath = "(//span[@aria-hidden='true'])[8]")
	private WebElement closeWindow;
	

	public WebElement getCloseWindow() {
		return closeWindow;
	}

	public WebElement getAddProductBtn() {
		return addProductBtn;
	}

	public WebElement getProductcodeText() {
		return productcodeText;
	}

	public WebElement getProductNameText() {
		return productNameText;
	}

	public WebElement getProductDescText() {
		return productDescText;
	}

	public WebElement getProductQuantText() {
		return productQuantText;
	}

	public WebElement getProductOnHandText() {
		return productOnHandText;
	}

	public WebElement getProductPriceText() {
		return productPriceText;
	}

	public WebElement getProductCateogyDrop() {
		return productCateogyDrop;
	}

	public WebElement getProductSupplierDrop() {
		return productSupplierDrop;
	}

	public WebElement getDateInStockText() {
		return dateInStockText;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public void addProduct(String code, String name, String descript, String quant, String onhand, String price,
			String category, String supplier, String date) throws InterruptedException {
		addProductBtn.click();
		productcodeText.sendKeys(code);
		productNameText.sendKeys(name);
		Thread.sleep(2000);
		productDescText.sendKeys(descript);
		productQuantText.sendKeys(quant);
		productOnHandText.sendKeys(onhand);
		productPriceText.sendKeys(price);
		productCateogyDrop.click();
		Select obj1 = new Select(productCateogyDrop);
		obj1.selectByVisibleText(category);
		productSupplierDrop.click();
		Select obj2 = new Select(productSupplierDrop);
		obj2.selectByVisibleText(supplier);
		Thread.sleep(2000);
		dateInStockText.click();
		System.out.println("date");
		
		dateInStockText.sendKeys(date);
		System.out.println("date2");
		saveBtn.click();

	}

}
