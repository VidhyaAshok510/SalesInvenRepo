package com.salesinventory.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
	WebDriver driver ;
	public CustomerPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@data-target='#customerModal']")
	private WebElement addCustomerBtn;
	@FindBy(xpath="//td[@class='sorting_1']")
	private WebElement firstNameVerf;
	@FindBy(xpath="//input[@class='form-control form-control-sm']")
	private WebElement searchBox;
	@FindBy(xpath="//a[@data-toggle='dropdown']")
	private WebElement ecllipseBtn;
	@FindBy(xpath="//i[@class='fas fa-fw fa-edit']")
	private WebElement editeBtn;
	@FindBy(name="firstname")
	private WebElement firstnameField;
	@FindBy(name="lastname")
	private WebElement lastnameField;
	@FindBy(name="phonenumber")
	private WebElement phnNoField;
	@FindBy(xpath="//button[@class='btn btn-success']")
	private WebElement saveBtn;
	@FindBy(name="firstname")
	private WebElement edtFirstnameText;
	@FindBy(name="lastname")
	private WebElement edtLastnameText;
	@FindBy(xpath="//button[text()='Update']")
	private WebElement updateBtn;
	
	public WebElement getEdtFirstnameText() {
		return edtFirstnameText;
	}
	public WebElement getEdtLastnameText() {
		return edtLastnameText;
	}
	public WebElement getUpdateBtn() {
		return updateBtn;
	}
	public WebElement getFirstnameField() {
		return firstnameField;
	}
	public WebElement getLastnameField() {
		return lastnameField;
	}
	public WebElement getPhnNoField() {
		return phnNoField;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getAddCustomerBtn() {
		return addCustomerBtn;
	}
	public WebElement getFirstNameVerf() {
		return firstNameVerf;
	}
	public WebElement getSearchBox() {
		return searchBox;
	}
	public WebElement getEcllipseBtn() {
		return ecllipseBtn;
	}
	public WebElement getEditeBtn() {
		return editeBtn;
	}
	public void addCustomer(String firstName, String lastName,String mobileNo) {
		addCustomerBtn.click();
		firstnameField.sendKeys(firstName);
		lastnameField.sendKeys(lastName);
		phnNoField.sendKeys(mobileNo);
		saveBtn.click();
		
	}
	public void editCustomer(String name,String firstName, String lastName) {
		searchBox.sendKeys(name);
		ecllipseBtn.click();
		editeBtn.click();
		edtFirstnameText.sendKeys(firstName);
		edtLastnameText.sendKeys(lastName);
		updateBtn.click();
		
	}
	
	
	

}
