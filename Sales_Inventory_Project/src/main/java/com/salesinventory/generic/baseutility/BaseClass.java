package com.salesinventory.generic.baseutility;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.salesinventory.generic.databaseutility.DatabaseUtility;
import com.salesinventory.generic.fileutility.ExcelUtility;
import com.salesinventory.generic.fileutility.FileUtility;
import com.salesinventory.generic.objectrepositoryutility.HomePage;
import com.salesinventory.generic.objectrepositoryutility.LoginPage;
import com.salesinventory.generic.webdriverutility.JavaUtility;
import com.salesinventory.generic.webdriverutility.UtilityClassObject;
import com.salesinventory.generic.webdriverutility.WebDriverUtility;


public class BaseClass extends WebDriverUtility{
	public DatabaseUtility dLib = new DatabaseUtility();
	public FileUtility fLib= new FileUtility();
	public ExcelUtility eLib= new ExcelUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public JavaUtility jLib= new JavaUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	
	@BeforeSuite(groups= {"smoketest","integrationtest","systemtest"})
	public void configBS() throws SQLException {
		System.out.println("===Connect to dB===");
		
		
	}

	@AfterSuite(groups= {"smoketest","integrationtest","systemtest"})
	public void configAS() throws Throwable {
		System.out.println("===Close dB===");
		dLib.closeDbConnection();
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups= {"smoketest","integrationtest","systemtest"})
	public void configBC(/*String browser*/) throws Throwable {
		System.out.println("===Launch Browser===");
		String BROWSER= fLib.getDataFromPropertiesFile("browser");
		//String BROWSER= browser;
		
		
		if(BROWSER.equals("chrome")){
			
			driver = new ChromeDriver();
		}
		else if(BROWSER.equals("edge")){
			
			driver = new EdgeDriver();
		}
		else if(BROWSER.equals("firefox")){
			
			driver = new FirefoxDriver();
		}
		else{
			
			driver = new ChromeDriver();
		}
		sdriver = driver;
		UtilityClassObject.setDriver(driver);
		System.out.println("done");
		wLib.waitForPageToLOad(driver);
	}
	
	@AfterClass(groups= {"smoketest","integrationtest","systemtest"})
	public void configAC() {
		System.out.println("===Close Browser===");
		driver.quit();
	}
	@BeforeMethod(groups= {"smoketest","integrationtest","systemtest"})
	public void configBM() throws Throwable {
		System.out.println("===Login to app===");
		System.out.println("done.......");
		
	
	}
	@AfterMethod(groups= {"smoketest","integrationtest","systemtest"})
	public void configAM() {
		System.out.println("====Logout===");
		
		
		
	}

}


