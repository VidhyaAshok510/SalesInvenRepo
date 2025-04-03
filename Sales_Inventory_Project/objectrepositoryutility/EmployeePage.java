package com.salesinventory.generic.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeePage {
	WebDriver driver ;
	public EmployeePage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@data-target='#employeeModal']")
	private WebElement addCustomerBtn;
	@FindBy(xpath="(//input[@placeholder='First Name'])[3]")
	private WebElement firstnameField;
	
	@FindBy(xpath="(//input[@placeholder='Last Name'])[3]")
	private WebElement lastnameField;
	@FindBy(xpath="(//select[@name='gender'])[1]")
	private WebElement genderDrop;
	@FindBy(xpath="(//input[@name='email'])[1]")
	private WebElement emailText ;
	@FindBy(xpath="(//input[@name='phonenumber'])[3]")
	private WebElement phnText ;
	@FindBy(name="jobs")
	private WebElement jobDrop ;
   /* @FindBy(xpath="(//input[@name='hireddate'])[1]")
	private WebElement hiredText ;*/
	@FindBy(id="province")
	private WebElement provinceDrop ;
	@FindBy(name="city")
	private WebElement cityDrop ;
	@FindBy(xpath="(//button[text()='Save'])[3]")
	private WebElement saveBtn ;
	public WebElement getAddCustomerBtn() {
		return addCustomerBtn;
	}
	public WebElement getFirstnameField() {
		return firstnameField;
	}
	public WebElement getLastnameField() {
		return lastnameField;
	}
	public WebElement getGenderDrop() {
		return genderDrop;
	}
	public WebElement getEmailText() {
		return emailText;
	}
	public WebElement getPhnText() {
		return phnText;
	}
	public WebElement getJobDrop() {
		return jobDrop;
	}
	/*public WebElement getHiredText() {
		return hiredText;
	}*/
	public WebElement getProvinceDrop() {
		return provinceDrop;
	}
	public WebElement getCityDrop() {
		return cityDrop;
	}
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void addEmployee(String firstname, String lastname,String gender,String email, String phnNo,
			String job,String province, String city) throws InterruptedException {
	
	 addCustomerBtn.click();
	
	firstnameField.sendKeys(firstname);
	
	 
	
	lastnameField.sendKeys(lastname);
	
	 genderDrop.click();
	 Select obj1 = new Select(genderDrop);
	 obj1.selectByVisibleText(gender);
	 
	 emailText.sendKeys(email);
	 
	 phnText.sendKeys(phnNo);
	 
	 
	 jobDrop.click();
	 Select obj2 = new Select(jobDrop);
	 obj2.selectByVisibleText(job);
	 Thread.sleep(2000);
	// hiredText.sendKeys(hireDate);
	 Thread.sleep(2000);
	 provinceDrop.click();
	 Select obj3 = new Select(provinceDrop);
	 obj3.selectByVisibleText(province);
	 Thread.sleep(2000);
	 cityDrop.click();
	 Select obj4 = new Select(cityDrop);
	 obj4.selectByVisibleText(city);
	 
	 saveBtn.click();
}
}
