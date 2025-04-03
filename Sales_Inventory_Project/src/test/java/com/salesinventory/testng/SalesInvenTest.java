package com.salesinventory.testng;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesinventory.generic.baseutility.BaseClass;
import com.salesinventory.generic.objectrepositoryutility.AccountPage;
import com.salesinventory.generic.objectrepositoryutility.CustomerPage;
import com.salesinventory.generic.objectrepositoryutility.EmployeePage;
import com.salesinventory.generic.objectrepositoryutility.HomePage;
import com.salesinventory.generic.objectrepositoryutility.InventoryPage;
import com.salesinventory.generic.objectrepositoryutility.LoginPage;
import com.salesinventory.generic.objectrepositoryutility.ProductPage;
import com.salesinventory.generic.objectrepositoryutility.SupplierPage;
import com.salesinventory.generic.objectrepositoryutility.TransactionPage;
import com.salesinventory.generic.objectrepositoryutility.UserAccountPage;

public class SalesInvenTest extends BaseClass {
	@Test(groups = {"smoketest"})
	public void editCustomerButtonTest() throws Throwable {
		wLib.waitForPageToLOad(driver);
		LoginPage lp = new LoginPage(driver);
		String URL = fLib.getDataFromPropertiesFile("url");
		String ADMINUSER = fLib.getDataFromPropertiesFile("admin_username");
		String ADMINPASS = fLib.getDataFromPropertiesFile("admin_password");
		lp.loginToApp(URL, ADMINUSER, ADMINPASS);
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		System.out.println("homepage");

		HomePage hp = new HomePage(driver);
		hp.getCustomerLink().click();
		Thread.sleep(2000);
		CustomerPage cp = new CustomerPage(driver);
		cp.getEcllipseBtn().click();
		Thread.sleep(2000);
		System.out.println(cp.getEditeBtn().isEnabled());
		Thread.sleep(2000);
		hp.logoutApp();
	}

	@Test(groups = {"smoketest"})
	public void productCreateTest() throws Throwable {
		UserAccountPage up = new UserAccountPage(driver);
		System.out.println("User");
		String URL = fLib.getDataFromPropertiesFile("url");
		driver.get(URL);
		up.loginUserToApp();
		boolean prodtCate = driver.findElement(By.linkText("Processor")).isEnabled();
		System.out.println(prodtCate);
		Thread.sleep(2000);
		up.logoutApp();
	}

	@Test(groups = {"integrationtest"})
	public void newCustomerTest() throws Throwable {
		UserAccountPage up = new UserAccountPage(driver);
		wLib.waitForPageToLOad(driver);
		String URL = fLib.getDataFromPropertiesFile("url");
		driver.get(URL);
		up.loginUserToApp();
		String category = eLib.getDataFromExcel("Customer", 7, 4);
		driver.findElement(By.xpath("//a[text()='" + category + "']")).click();
		String product = eLib.getDataFromExcel("Customer", 7, 5);
		/*Actions action = new Actions(driver);
		action.scrollByAmount(589, 1059).perform();*/
		wLib.scrollByAmount(driver, 589, 1059);
		driver.findElement(By.xpath("//input[@value='" + product + "']/following-sibling::input[@value='Add']"))
				.click();
		String firstname = eLib.getDataFromExcel("Customer", 7, 1);
		String lastname = eLib.getDataFromExcel("Customer", 7, 2);
		String phNum = eLib.getDataFromExcel("Customer", 7, 3);
		String customer = firstname + " " + lastname;
		up.newCustomerOrder(firstname, lastname, phNum);
		Thread.sleep(2000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
		up.logoutApp();
		wLib.waitForPageToLOad(driver);
		LoginPage lp = new LoginPage(driver);
		String URL1 = fLib.getDataFromPropertiesFile("url");
		String ADMINUSER = fLib.getDataFromPropertiesFile("admin_username");
		String ADMINPASS = fLib.getDataFromPropertiesFile("admin_password");
		lp.loginToApp(URL1, ADMINUSER, ADMINPASS);

		System.out.println("homepage");
		wLib.waitForPageToLOad(driver);
		HomePage hp = new HomePage(driver);
		hp.getCustomerLink().click();
		CustomerPage cp = new CustomerPage(driver);
		cp.getSearchBox().sendKeys(firstname);
		Thread.sleep(2000);
		String actFirstName = cp.getFirstNameVerf().getText();
		Assert.assertEquals(actFirstName, firstname);
		hp.logoutApp();
	}

	@Test(groups = {"integrationtest"})
	public void createSupplierTest() throws Throwable {
		wLib.waitForPageToLOad(driver);
		String URL = fLib.getDataFromPropertiesFile("url");
		String ADMINUSER = fLib.getDataFromPropertiesFile("admin_username");
		String ADMINPASS = fLib.getDataFromPropertiesFile("admin_password");

		LoginPage lp = new LoginPage(driver);

		lp.loginToApp(URL, ADMINUSER, ADMINPASS);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		HomePage hp = new HomePage(driver);
		hp.getSupplierLink().click();
		SupplierPage sp = new SupplierPage(driver);
		String company = eLib.getDataFromExcel("Customer", 9, 1);
		String province = eLib.getDataFromExcel("Customer", 9, 2);
		String city = eLib.getDataFromExcel("Customer", 9, 3);
		String phNo = eLib.getDataFromExcel("Customer", 9, 4);
		sp.addSupplier(company, province, city, phNo);
		Thread.sleep(2000);
		hp.getProductLink().click();
		
		ProductPage pp = new ProductPage(driver);
		pp.getAddProductBtn().click();
		pp.getProductSupplierDrop().click();

		Select obj2 = new Select(pp.getProductSupplierDrop());
		Thread.sleep(2000);
		obj2.selectByVisibleText(company);
		String actdrop = pp.getProductSupplierDrop().getText();
		boolean result = actdrop.contains(company);
		System.out.println(result);
		Assert.assertEquals(result, true);
		Thread.sleep(2000);
		pp.getCloseWindow().click();
		hp.logoutApp();
	}

	@Test(groups = {"systemtest"})
	public void createEmployeeTest() throws Throwable {
		wLib.waitForPageToLOad(driver);
		String URL = fLib.getDataFromPropertiesFile("url");
		String ADMINUSER = fLib.getDataFromPropertiesFile("admin_username");
		String ADMINPASS = fLib.getDataFromPropertiesFile("admin_password");

		LoginPage lp = new LoginPage(driver);

		lp.loginToApp(URL, ADMINUSER, ADMINPASS);
		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		HomePage hp = new HomePage(driver);

		hp.getEmployeeLink().click();
		EmployeePage ep = new EmployeePage(driver);
		Thread.sleep(2000);
		String firstName = eLib.getDataFromExcel("Customer", 3, 1);
		String lastName = eLib.getDataFromExcel("Customer", 3, 2);
		String gender = eLib.getDataFromExcel("Customer", 3, 3);
		String email = eLib.getDataFromExcel("Customer", 3, 4);
		String phno = eLib.getDataFromExcel("Customer", 3, 5) + jLib.GetRandomNum();
		String job = eLib.getDataFromExcel("Customer", 3, 6);
		String hiredate = eLib.getDataFromExcel("Customer", 3, 7);
		String province = eLib.getDataFromExcel("Customer", 3, 8);
		String city = eLib.getDataFromExcel("Customer", 3, 9);
		String employee = lastName + ", " + firstName + " - " + job;
		ep.addEmployee(firstName, lastName, gender, email, phno, job, province, city);

		hp.getAccountLink().click();
		AccountPage ap = new AccountPage(driver);
		String username = eLib.getDataFromExcel("Customer", 3, 10);
		String password = eLib.getDataFromExcel("Customer", 3, 11);
		ap.addUserAccount(employee, username, password);
		Thread.sleep(2000);
		hp.getLogoutImg().click();
		hp.getLogoutBtn().click();
		hp.getLogoutConf().click();

		wLib.waitForPageToLOad(driver);
		LoginPage lgp = new LoginPage(driver);
		lgp.getUsernameText().sendKeys(username);
		lgp.getPwdText().sendKeys(password);
		lgp.getLoginBtn().click();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		UserAccountPage uap = new UserAccountPage(driver);
		uap.logoutApp();

	}

	@Test(groups = {"systemtest"})
	public void newProductTest() throws Throwable {
		wLib.waitForPageToLOad(driver);
		String URL = fLib.getDataFromPropertiesFile("url");
		String ADMINUSER = fLib.getDataFromPropertiesFile("admin_username");
		String ADMINPASS = fLib.getDataFromPropertiesFile("admin_password");

		LoginPage lp = new LoginPage(driver);

		lp.loginToApp(URL, ADMINUSER, ADMINPASS);
		
		HomePage hp = new HomePage(driver);
		hp.getProductLink().click();
		ProductPage pp = new ProductPage(driver);
		String code = eLib.getDataFromExcel("Customer", 5, 1) + jLib.GetRandomNum();
		String name = eLib.getDataFromExcel("Customer", 5, 2) + jLib.GetRandomNum();
		String descript = eLib.getDataFromExcel("Customer", 5, 3);
		String quant = eLib.getDataFromExcel("Customer", 5, 4);
		String onhand = eLib.getDataFromExcel("Customer", 5, 5);
		String price = eLib.getDataFromExcel("Customer", 5, 6);
		String category = eLib.getDataFromExcel("Customer", 5, 7);
		String supplier = eLib.getDataFromExcel("Customer", 5, 8);
		String date = eLib.getDataFromExcel("Customer", 5, 9);
		pp.addProduct(code, name, descript, quant, onhand, price, category, supplier, date);
		Thread.sleep(2000);
		hp.getInventoryLink().click();
		InventoryPage ip = new InventoryPage(driver);
		ip.getSearchText().sendKeys(name);
		String actProduct = ip.getProductNameBox().getText();
		Assert.assertEquals(actProduct, name);
		hp.logoutApp();

	}
	@Test(groups = {"systemtest"})
	public void orderTest() throws Throwable {
		
		wLib.waitForPageToLOad(driver);
		LoginPage lp = new LoginPage(driver);
		String URL = fLib.getDataFromPropertiesFile("url");
		String ADMINUSER = fLib.getDataFromPropertiesFile("admin_username");
		String ADMINPASS = fLib.getDataFromPropertiesFile("admin_password");
		lp.loginToApp( URL,ADMINUSER, ADMINPASS);
		Robot robot = new Robot();
		 robot.keyPress(KeyEvent.VK_ENTER);
         robot.keyRelease(KeyEvent.VK_ENTER);
		
		System.out.println("homepage");
		
		HomePage hp = new HomePage(driver);
		hp.getCustomerLink().click();
				CustomerPage cp = new CustomerPage(driver);
		String firstName= eLib.getDataFromExcel("Customer", 1, 1);
		String lastName= eLib.getDataFromExcel("Customer", 1, 2);
		String phNum= eLib.getDataFromExcel("Customer", 1, 3);
		cp.addCustomer(firstName, lastName, phNum);
		String customer= firstName +" "+lastName;
		System.out.println(customer);
		System.out.println("Admin");
		hp.logoutApp();
		
		UserAccountPage up = new UserAccountPage(driver);
		System.out.println("User");
		up.loginUserToApp();
		String category= eLib.getDataFromExcel("Customer", 1, 4);
		driver.findElement(By.xpath("//a[text()='"+category+"']")).click();
		String product= eLib.getDataFromExcel("Customer", 1, 5);
		Actions action = new Actions(driver);
		action.scrollByAmount(3574, 2659).perform();
		driver.findElement(By.xpath("//input[@value='"+product+"']/following-sibling::input[@value='Add']")).click();
		Thread.sleep(2000);
		up.productOrder(customer);
	
		Thread.sleep(2000);
		up.logoutApp();
		
	}
	@Test(groups = {"systemtest"})
	public void transactionValidateTest() throws Throwable {
		wLib.waitForPageToLOad(driver);
		String URL = fLib.getDataFromPropertiesFile("url");
		String ADMINUSER = fLib.getDataFromPropertiesFile("admin_username");
		String ADMINPASS = fLib.getDataFromPropertiesFile("admin_password");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.loginToApp( URL,ADMINUSER, ADMINPASS);
		Robot robot = new Robot();
		 robot.keyPress(KeyEvent.VK_ENTER);
         robot.keyRelease(KeyEvent.VK_ENTER);
		HomePage hp = new HomePage(driver);
		hp.getProductLink().click();
		ProductPage pp= new ProductPage(driver);
		String code= eLib.getDataFromExcel("Customer", 11, 1)+ jLib.GetRandomNum();
		String name= eLib.getDataFromExcel("Customer", 11, 2);
		String descript= eLib.getDataFromExcel("Customer", 11, 3);
		String quant= eLib.getDataFromExcel("Customer", 11, 4);
		String onhand= eLib.getDataFromExcel("Customer", 11, 5);
		String  price= eLib.getDataFromExcel("Customer", 11, 6);
		String category= eLib.getDataFromExcel("Customer", 11, 7);
		String  supplier= eLib.getDataFromExcel("Customer", 11, 8);
		String date= eLib.getDataFromExcel("Customer", 11, 9);
		pp.addProduct(code,  name,  descript, quant, onhand,  price, category,  supplier,date );
		Thread.sleep(2000);
		hp.logoutApp();
		UserAccountPage up = new UserAccountPage(driver);
		driver.get(URL);
		up.loginUserToApp();	
		driver.findElement(By.xpath("//a[text()='"+category+"']")).click();		
		wLib.scrollByAmount(driver, 3574, 2659);
		driver.findElement(By.xpath("//input[@value='"+name+"']/following-sibling::input[@value='Add']")).click();
		String firstname= eLib.getDataFromExcel("Customer",11, 10);
		String lastname= eLib.getDataFromExcel("Customer",11, 11);
		String phNum= eLib.getDataFromExcel("Customer",11, 12);
		String customer = firstname+" "+ lastname;
		up.newCustomerOrder(firstname, lastname, phNum);
		Thread.sleep(2000);
		
		 robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
		up.productOrder(customer);
		up.logoutApp();
		lp.loginToApp(URL, ADMINUSER, ADMINPASS);
		hp.getTransactionLink().click();
		TransactionPage tp = new TransactionPage(driver);
		tp.getSearchField().sendKeys(customer);
		tp.getViewButton().click();
		
		String actProd=tp.getProdtNameHeader().getText();
		boolean result=actProd.contains(name);
		String actPrice=tp.getProdtPriceHeader().getText();
		
		Assert.assertEquals(result, true);
		Assert.assertEquals(actPrice, price);
		hp.logoutApp();
		
	}



}
