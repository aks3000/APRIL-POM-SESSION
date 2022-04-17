package org.qa.opencart.test;

import org.qa.opencart.util.ConstantUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductSearchTest extends BaseTest {
	
	@DataProvider
	public Object[][] productData() {
		return new Object[][] {
			{"mac","Samsung","xiomi"}
			
		};
	}
//	
	
	@Test(dataProvider="productData")
	public void productCountTest(String pname) {
		
		softAssert.assertFalse(productResult.doProductResultCount(pname)==ConstantUtil.MAC_PRODUCT_COUNT);//1st is filed 
		softAssert.assertFalse(productResult.doProductResultCount(pname)==ConstantUtil.SAMSUNG_PRODUCT_COUNT);
		softAssert.assertFalse(productResult.doProductResultCount(pname)==ConstantUtil.XIOMI_PRODUCT_COUNT);
		softAssert.assertAll();
		//Assert.assertTrue(pCount==ConstantUtil.MAC_PRODUCT_COUNT);

	
	}
	
	
	
	

}
