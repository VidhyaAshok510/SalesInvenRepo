package com.salesinventory.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.salesinventory.generic.webdriverutility.WebDriverUtility;


public class HomePage extends WebDriverUtility {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		waitForPageToLOad(driver);
		System.out.println("pom");
		PageFactory.initElements( driver,this);
		System.out.println("sucess");
	}
	@FindBy(xpath="//span[text()='Customer']")
	private WebElement customerLink;
	@FindBy(linkText="Employee")
	private WebElement employeeLink;
	@FindBy(linkText="Product")
	private WebElement productLink;
	@FindBy(linkText="Inventory")
	private WebElement inventoryLink;
	@FindBy(linkText="Transaction")
	private WebElement transactionLink;
	@FindBy(linkText="Supplier")
	private WebElement supplierLink;
	@FindBy(linkText="Accounts")
	private WebElement accountLink;
	@FindBy(xpath ="//img[contains(@class,'rounded-circle')]")
	private WebElement logoutImg;
	@FindBy(xpath="//a[@data-target='#logoutModal']")
	private WebElement logoutBtn;
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logoutConf;
	@FindBy(xpath="(//span[@class='mr-2 d-none d-lg-inline text-gray-600 small'] )[2]")
	private WebElement usernameVerify;
	
	
	public WebElement getUsernameVerify() {
		return usernameVerify;
	}
	public WebElement getCustomerLink() {
		return customerLink;
	}
	public WebElement getEmployeeLink() {
		return employeeLink;
	}
	public WebElement getProductLink() {
		return productLink;
	}
	public WebElement getInventoryLink() {
		return inventoryLink;
	}
	public WebElement getTransactionLink() {
		return transactionLink;
	}
	public WebElement getSupplierLink() {
		return supplierLink;
	}
	public WebElement getAccountLink() {
		return accountLink;
	}
	public WebElement getLogoutImg() {
		return logoutImg;
	}
	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	public WebElement getLogoutConf() {
		return logoutConf;
	}
	public void logoutApp() {
		logoutImg.click();
		logoutBtn.click();
		
		logoutConf.click();
		
	}

}
