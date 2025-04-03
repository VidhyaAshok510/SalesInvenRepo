package com.salesinventory.generic.objectrepositoryutility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.salesinventory.generic.webdriverutility.WebDriverUtility;


public class LoginPage extends WebDriverUtility {
	WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="user")
	private WebElement usernameText;
	@FindBy(name="password")
	private WebElement pwdText;
	@FindBy(name="btnlogin")
	private WebElement loginBtn;
	public WebElement getUsernameText() {
		return usernameText;
	}
	public WebElement getPwdText() {
		return pwdText;
	}
	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public void loginToApp(String url,String username,String pwd) throws AWTException {
		
		driver.manage().window().maximize();
		waitForPageToLOad(driver);
		driver.get(url);
		usernameText.sendKeys(username);
		pwdText.sendKeys(pwd);
		loginBtn.click();
		Robot robot = new Robot();
		 robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
	
	
	
	

}
