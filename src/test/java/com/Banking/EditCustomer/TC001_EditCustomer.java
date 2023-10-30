package com.Banking.EditCustomer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Banking.PageFactory.LoginPage;
import com.Banking.PageFactory.WelcomePage;
import com.Banking.PageFactory.editCustomerPage;
import com.Banking.Utils.BaseClass;
import com.Banking.Utils.ReadConfig;

public class TC001_EditCustomer extends BaseClass {

	@Test(priority = 1)
	public void login() {
		LoginPage page = new LoginPage(driver);
		page.login();
	}

	@Test(priority = 2)
	public void manager() {

		WelcomePage page = new WelcomePage(driver);
		page.EditCustomerLink();

	}

	@Test(priority = 3)
	public void editCustomer() {
		ReadConfig config = new ReadConfig();
		String customerId =config.getValueProperty("customerId");
		editCustomerPage page = new editCustomerPage(driver);
		page.enterCustomerId(customerId);
		page.clickonSubmit();
	Assert.assertEquals(page.editCustomerisDisplayed(), true);	
	
		

	}

}
