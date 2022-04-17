package org.qa.opencart.test;

import java.util.Random;

import org.qa.opencart.util.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationPageTest extends BaseTest {
	
	@BeforeClass
	public void gotoRegisterPageSetUp() {
		loginPage.gotoRegisterPage();
		
	}
	
	public String randomMailGenerator() {
		Random random = new Random();
		
		String mail= "aprilpom"+ random.nextInt(1000) +"@gamil.com";
		
		return mail;
				
	}
	
//	@DataProvider
//	public Object[][] regTestData() {
//		
//		return new Object[][] {
//				{"Selenium","Testing",
//				"564546466","test@1234","yes"}	
//				
//		};
//		
//	}
	
	@DataProvider
    public Object[][] regTestData() {
		
	return ExcelUtil.testData("registration");	
				
		
	}
	
	
	
	@Test(dataProvider="regTestData")
	public void regTest(String firstName, String lastname,
			 String telephone,String password, String subscribe)  {
		boolean flag=registrationPage.accountRegistration(firstName,lastname,randomMailGenerator(),
				telephone,password,subscribe);
		Assert.assertTrue(flag);
	}

	
	
		
	
}


