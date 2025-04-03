package com.salesinventory.generic.objectrepositoryutility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.salesinventory.generic.databaseutility.DatabaseUtility;
import com.salesinventory.generic.fileutility.ExcelUtility;
import com.salesinventory.generic.fileutility.FileUtility;
import com.salesinventory.generic.webdriverutility.JavaUtility;
import com.salesinventory.generic.webdriverutility.WebDriverUtility;


public class UserAccountPage extends WebDriverUtility {
	public DatabaseUtility dLib = new DatabaseUtility();
	public FileUtility fLib= new FileUtility();
	public ExcelUtility eLib= new ExcelUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public JavaUtility jLib= new JavaUtility();
	WebDriver driver ;
	 public UserAccountPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="customer")
	private WebElement customerDrop;
	@FindBy(xpath="//a[@data-target='#poscustomerModal']")
	private WebElement addCustomerBtn;
	@FindBy(xpath="(//input[@name='firstname'])[2]")
	private WebElement firstnameField;
	@FindBy(xpath="(//input[@name='lastname'])[2]")
	private WebElement lastnameField;
	@FindBy(xpath="(//input[@name='phonenumber'])[2]")
	private WebElement phnNoField;
	@FindBy(xpath="(//button[@class='btn btn-success'])[2]")
	private WebElement saveBtn;
	@FindBy(xpath="//button[@data-target='#posMODAL']")
	private WebElement submitBtn;
	@FindBy(xpath ="//img[contains(@class,'rounded-circle')]")
	private WebElement logoutImg;
	@FindBy(xpath="//a[@data-target='#logoutModal']")
	private WebElement logoutBtn;
	@FindBy(xpath="(//span[@class='mr-2 d-none d-lg-inline text-gray-600 small'] )[2]")
	private WebElement usernameVerify;
	@FindBy(id="txtNumber")
	private WebElement paymentField;
	@FindBy(xpath="//button[text()='PROCEED TO PAYMENT']")
	private WebElement paymentBtn;
	@FindBy(xpath="(//a[text()='Logout'])[1]")
	private WebElement logoutConf;
	@FindBy(xpath="//a[contains(@class,'scroll-to-top')]")
	private WebElement scrollBtn;
	
	public WebElement getScrollBtn() {
		return scrollBtn;
	}
	public WebElement getLogoutConf() {
		return logoutConf;
	}
	public WebElement getPaymentBtn() {
		return paymentBtn;
	}
	
	
	public WebElement getLogoutImg() {
		return logoutImg;
	}
	public WebElement getLogoutBtn() {
		return logoutBtn;
	}
	public WebElement getUsernameVerify() {
		return usernameVerify;
	}
	public WebElement getPaymentField() {
		return paymentField;
	}
	public WebElement getCustomerDrop() {
		return customerDrop;
	}
	public WebElement getAddCustomerBtn() {
		return addCustomerBtn;
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
	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	public void loginUserToApp() throws Throwable {
		driver.manage().window().maximize();
		waitForPageToLOad(driver);
		
		//String URL = fLib.getDataFromPropertiesFile("url");
		String USER = fLib.getDataFromPropertiesFile("user_username");
		String USERPASS = fLib.getDataFromPropertiesFile("user_password");
		LoginPage lp= new LoginPage(driver);
		System.out.println("UserLogin");
		LoginPage lg= new LoginPage(driver);
		lg.getUsernameText().sendKeys(USER);
		lg.getPwdText().sendKeys(USERPASS);
		lg.getLoginBtn().click();
		
		Thread.sleep(2000);
		Robot robot = new Robot();
		 robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
	
		System.out.println("UserSucceess");
		
		//driver.switchTo().alert().accept();
		
		
	}
	
	public void newCustomerOrder(String firstName, String lastName, String Phno) throws AWTException, InterruptedException {
		addCustomerBtn.click();
		firstnameField.sendKeys(firstName);
		lastnameField.sendKeys(lastName);
		System.out.println("phn");
		Thread.sleep(2000);
		//phnNoField.click();
		phnNoField.sendKeys(Phno);
		System.out.println("phn66677");
		
		saveBtn.click();
		Robot robot = new Robot();
		 robot.keyPress(KeyEvent.VK_ENTER);
      robot.keyRelease(KeyEvent.VK_ENTER);
		
		//submitBtn.click();
		
	}
	public void productOrder(String customer) throws InterruptedException, Throwable {
		customerDrop.click();
		Select selObj = new Select(customerDrop);
		selObj.selectByVisibleText(customer);
		Actions action = new Actions(driver);
		action.click().perform();
		//action.scrollToElement(scrollBtn).perform();
		System.out.println(submitBtn.isEnabled());
		action.scrollByAmount(2310, 958).perform();
		Thread.sleep(2000);
		System.out.println("scroll");
		submitBtn.click();
		Thread.sleep(2000);
		
       paymentField.sendKeys("1000");
        paymentBtn.click();
        Thread.sleep(2000);
        Robot robot = new Robot();
		 robot.keyPress(KeyEvent.VK_ENTER);
       robot.keyRelease(KeyEvent.VK_ENTER);
	
		
	}
	public void logoutApp() {
		logoutImg.click();
		logoutBtn.click();
		logoutConf.click();
		
	}
	
	
	
}
