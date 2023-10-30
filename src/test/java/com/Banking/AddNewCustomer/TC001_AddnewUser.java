package com.Banking.AddNewCustomer;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Banking.PageFactory.AddNewCustomerPage;
import com.Banking.PageFactory.LoginPage;
import com.Banking.PageFactory.WelcomePage;
import com.Banking.Utils.BaseClass;
import com.Banking.Utils.FakerData;
import com.Banking.Utils.ReadConfig;

public class TC001_AddnewUser extends BaseClass {

	@Test(priority = 1)
	public void login() {

		LoginPage lp = new LoginPage(driver);
		lp.login();
	}

	@Test(priority = 2)
	public void manager() {
		WelcomePage page = new WelcomePage(driver);
		page.getNewCustomerLink().click();
		logger.info("Clicked on New Customer Link");

	}

	@Test(priority = 3)
	public void addNewCustomer() throws InterruptedException {
		AddNewCustomerPage page = new AddNewCustomerPage(driver);
		Assert.assertEquals(page.AddNewCustomerTitle(), true);
		FakerData fakeData = new FakerData();
		page.customerName(fakeData.name());
		page.clickonMaleRadio();
		page.dateOfBirth("10-10-1999");
		page.address(fakeData.streetAddress());
		page.city(fakeData.city());
		page.stateName(fakeData.state());
		page.pincode(fakeData.zipCode());
		page.telephone(fakeData.cellNumber());
		page.emailID(fakeData.email());
		page.password(fakeData.password());
		page.clickonSubmit();
		Wait.until(ExpectedConditions.visibilityOf(page.getCustomerRegisteredSuccesfully()));
		Assert.assertEquals(page.getCustomerRegisteredSuccesfully().isDisplayed(), true,
				"New Customer Added Succesfully");
		logger.info("New Customer Added Succesfully");
		ReadConfig config = new ReadConfig();
		config.writeProperty("customerId", page.getCustomerID());

	}
}
