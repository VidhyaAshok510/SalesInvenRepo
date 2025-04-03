package com.salesinventory.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
	WebDriver driver;

	public InventoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@class='form-control form-control-sm']")
	private WebElement searchText;
	@FindBy(xpath = "//td[@class='sorting_1']/../td[2]")
	private WebElement productNameBox;
	@FindBy(xpath = "//td[@class='sorting_1']/../td[3]")
	private WebElement productQuantityBox;

	public WebElement getSearchText() {
		return searchText;
	}

	public WebElement getProductNameBox() {
		return productNameBox;
	}

	public WebElement getProductQuantityBox() {
		return productQuantityBox;
	}

}
