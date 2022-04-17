package org.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
	
	
	@Test
	public void getLoginPageTitleTest() {
		String actTitle=loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, "Account Login");
	}
	
	@Test
	public void isRegisterLinkExistTest() {
		boolean flag=loginPage.isRegisterLinkExist();
		Assert.assertTrue(flag);
	}
	
	

}
