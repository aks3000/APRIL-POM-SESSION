package org.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qa.opencart.util.ElementUtil;

public class LoginPage {
	
	//1.WebDriver driver
	
	private WebDriver driver;
	
	ElementUtil eleUtil= new ElementUtil(driver);
	
	//2.constructor
	public LoginPage( WebDriver driver) {
		this.driver=driver;
	}
	
	
	// 3. By locators
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By registerLink = By.linkText("Register");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	private By loginErrorMesg = By.cssSelector("div.alert.alert-danger.alert-dismissible");
	
	//Page actions
	public String getLoginPageTitle() {
		return eleUtil.doGetTitle();                 
	}
	
	public boolean isRegisterLinkExist() {
		return eleUtil.isElementExist(registerLink);
	}
	
	
	public boolean isForgotPwdLinkExist() {
		return eleUtil.doIsDisplayed(forgotPwdLink);
		//eleUtil.waitForElementsToBeVisible(forgotPwdLink, 10)
	}
	
	public AccountPage doLogin(String un, String pwd) {
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		
		return new AccountPage(driver);
	}
	
	
	
	public void gotoRegisterPage() {
		driver.findElement(registerLink).click();		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
