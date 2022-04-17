package org.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
	
	//1.driver
	private WebDriver driver;
			
	//2.constructor
	public AccountPage(WebDriver driver) {
		this.driver=driver;
	}
			
	//3.By locators
			
			private By header = By.cssSelector("div#logo a");
			private By accountsSections = By.cssSelector("div#content h2");
			private By searchField = By.name("search");
			private By searchButton = By.cssSelector("div#search button");
			private By logoutLink = By.linkText("Logout");
			
			public String getAccountPageTitle() {
				return driver.getTitle();
			}
			
			public String getAccountsPageHeader() {
				return driver.findElement(header).toString();
			}
			
			public boolean isLogoutLinkExist() {
				return driver.findElement(logoutLink).isDisplayed();
			}
			
			public void logout() {
				if(isLogoutLinkExist()) {
					driver.findElement(logoutLink).click();
				}
			}

}
