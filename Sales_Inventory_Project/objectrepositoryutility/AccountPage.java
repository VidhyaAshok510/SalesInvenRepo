package com.salesinventory.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class AccountPage  {
	WebDriver driver ;
	
	public AccountPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@data-target='#supplierModal']")
	private WebElement addUserBtn;
	@FindBy(name="empid")
	private WebElement employeeDrop;
	@FindBy(xpath="(//input[@name='username'])[2]")
	private WebElement usernameField;
	@FindBy(xpath="(//input[@name='password'])[2]")
	private WebElement pwdField;
	@FindBy(xpath = "(//button[@class='btn btn-success'])[5]")
	private WebElement saveBtn;
	public WebElement getAddUserBtn() {
		return addUserBtn;
	}
	public WebElement getEmployeeDrop() {
		return employeeDrop;
	}
	public WebElement getUsernameField() {
		return usernameField;
	}
	public WebElement getPwdField() {
		return pwdField;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void addUserAccount(String employee,String username, String pwd ) throws InterruptedException {
		addUserBtn.click();
		employeeDrop.click();
		Select selObj = new Select(employeeDrop);
		selObj.selectByVisibleText(employee);
		Thread.sleep(1000);
		usernameField.sendKeys(username);
		pwdField.sendKeys(pwd);
		saveBtn.click();
		
		
		
	}
	
	
	

}
