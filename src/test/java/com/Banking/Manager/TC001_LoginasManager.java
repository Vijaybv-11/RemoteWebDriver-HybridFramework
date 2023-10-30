package com.Banking.Manager;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.Banking.PageFactory.LoginPage;
import com.Banking.PageFactory.WelcomePage;
import com.Banking.Utils.BaseClass;
import com.Banking.Utils.ReadConfig;

public class TC001_LoginasManager extends BaseClass{
	
	@Test(priority = 1)
	public void login() {
		LoginPage page = new LoginPage(driver);
		ReadConfig config = new ReadConfig();
		page.login();
	}
	
	@Test(priority = 2)
	public void mangager() {
		WelcomePage page = new WelcomePage(driver);
		Assert.assertEquals( page.getNewCustomerLink().isDisplayed(), true);
		Assert.assertEquals( page.getEditAccountLink().isDisplayed(), true);
		Assert.assertEquals( page.getEditCustomerLink().isDisplayed(), true);
		Assert.assertEquals( page.getDeleteCustomerLink().isDisplayed(), true);
		Assert.assertEquals( page.getDeleteAccountLink().isDisplayed(), true);
		Assert.assertEquals( page.getDepositLink().isDisplayed(), true);
		Assert.assertEquals( page.getWithdrawlLink().isDisplayed(), true);

	}

}
