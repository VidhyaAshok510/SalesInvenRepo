package com.salesinventory.generic.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SupplierPage {
	WebDriver driver ;
	public SupplierPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@data-target='#supplierModal']")
	private WebElement addSupplierBtn;
	@FindBy(name="companyname")
	private WebElement companynameField;
	@FindBy(xpath="//select[@name='province']")
	private WebElement provinceDrop;
	@FindBy(xpath="//select[@id='city']")
	private WebElement cityDrop;
	
	@FindBy(xpath="//input[@name='phonenumber']")

	private WebElement phNoField;
	@FindBy(xpath = "//button[@class='btn btn-success']")
	private WebElement saveBtn;
	public WebElement getAddSupplierBtn() {
		return addSupplierBtn;
	}
	public WebElement getCompanynameFieldd() {
		return companynameField;
	}
	public WebElement getProvinceDrop() {
		return provinceDrop;
	}
	public WebElement getPhNoField() {
		return phNoField;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebElement getCompanynameField() {
		return companynameField;
	}
	public WebElement getCityDrop() {
		return cityDrop;
	}
	public void addSupplier(String company, String province,String city, String phnNo) {
		addSupplierBtn.click();
		companynameField.sendKeys(company);
		provinceDrop.click();
		Select selObj = new Select(provinceDrop);
		selObj.selectByVisibleText(province);
		cityDrop.click();
		Select selObj2 = new Select(cityDrop);
		selObj2.selectByVisibleText(city);
		phNoField.sendKeys(phnNo);
		saveBtn.click();
		
	}
}


	