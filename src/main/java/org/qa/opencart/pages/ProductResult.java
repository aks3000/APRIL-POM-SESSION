package org.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.qa.opencart.util.ElementUtil;

public class ProductResult {
	private WebDriver driver;
	
	public ElementUtil eleUtil;
	
	public ProductResult(WebDriver driver) {
		this.driver=driver;
		eleUtil= new ElementUtil(driver);
	}
	
	private By productCount=By.xpath("//div[@class='caption']");
	
	private By searchFiled= By.name("search");
	private By searchBtn = By.xpath("//*[@id=\"search\"]/span/button");
	
	
	public int doProductResultCount(String productName) {
		//WebElement element=driver.findElement(searchFiled);
		eleUtil.doSendKeys(searchFiled, productName);
		eleUtil.doClick(searchBtn);
//		//element.sendKeys(productName);
//		driver.findElement(searchBtn).click();
//		driver.navigate().refresh();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		List<WebElement> productNum=driver.findElements(productCount);
//		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOfAllElements(productNum));
		
		
		return productNum.size();
	}
	
	

}
