package org.qa.opencart.test;

import org.qa.opencart.util.ConstantUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyAccountPageTest extends BaseTest {
	
	@BeforeClass
	public void doLogin() {
		String un=prop.getProperty("username");
		String pwd=prop.getProperty("password");
		loginPage.doLogin(un,pwd);
	}
	
	@Test
	public void getAccountPageTitleTest() {
		String actitle=accountPage.getAccountPageTitle();
		Assert.assertEquals(actitle,ConstantUtil.ACCOUNT_PAGE_TITLE );
	}
	
	@Test(priority=1)
	public void getAccountsPageHeaderTest() {
		String pageheader=accountPage.getAccountsPageHeader();
		Assert.assertEquals(pageheader, ConstantUtil.ACCOUNT_PAGE_HEADER);
	}
	
	@Test(priority=2)
	public void isLogoutLinkExistTest() {
		boolean flag=accountPage.isLogoutLinkExist();
		Assert.assertTrue(flag);
	}
	
	
	
	
}
