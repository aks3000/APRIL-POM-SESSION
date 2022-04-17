package org.qa.opencart.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.qa.opencart.driverfactory.DriverFactory;
import org.qa.opencart.pages.AccountPage;
import org.qa.opencart.pages.LoginPage;
import org.qa.opencart.pages.ProductResult;
import org.qa.opencart.pages.RegistrationPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;


public class BaseTest {
	
	DriverFactory df;
	Properties prop;
	WebDriver driver;
	LoginPage loginPage;
	AccountPage accountPage;
	ProductResult productResult;
	
	RegistrationPage registrationPage;
	SoftAssert 	softAssert;
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop=df.init_prop();
		driver=df.init_driver(prop);
		loginPage=new LoginPage(driver);
		registrationPage = new RegistrationPage(driver);
		accountPage=new AccountPage(driver);
		productResult = new ProductResult(driver);
		softAssert = new SoftAssert();
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	

}
