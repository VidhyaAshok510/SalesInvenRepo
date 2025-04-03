package com.salesinventory.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionPage {
	WebDriver driver ;
	public TransactionPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//input[@class='form-control form-control-sm']")
	private WebElement searchField;
	@FindBy(xpath="//td[@class='sorting_1']/../td[2]")
	private WebElement nameField;
	@FindBy(xpath="//a[contains(text(),'View')]")
	private WebElement viewButton;
	@FindBy(xpath="//th[text()='Products']/../../..//td[1]")
	private WebElement prodtNameHeader;
	@FindBy(xpath="//td[@class='font-weight-bold text-right text-primary']")
	private WebElement prodtPriceHeader;
	public WebElement getSearchField() {
		return searchField;
	}
	public WebElement getNameField() {
		return nameField;
	}
	public WebElement getViewButton() {
		return viewButton;
	}
	public WebElement getProdtNameHeader() {
		return prodtNameHeader;
	}
	public WebElement getProdtPriceHeader() {
		return prodtPriceHeader;
	}
	
	
}
