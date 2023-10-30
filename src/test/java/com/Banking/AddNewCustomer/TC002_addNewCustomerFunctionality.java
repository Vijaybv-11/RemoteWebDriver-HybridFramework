package com.Banking.AddNewCustomer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Banking.PageFactory.AddNewCustomerPage;
import com.Banking.PageFactory.LoginPage;
import com.Banking.PageFactory.WelcomePage;
import com.Banking.Utils.BaseClass;
import com.Banking.Utils.JavaScriptUtil;

public class TC002_addNewCustomerFunctionality extends BaseClass {
	
	JavaScriptUtil util = new JavaScriptUtil(driver);

	@Test(priority = 1)
	public void login() {
		LoginPage lp = new LoginPage(driver);
		lp.login();
	}

	@Test(priority=2)
	public void manager() {	
		WelcomePage page = new WelcomePage(driver);
		page.NewCustomerLink();
	}
	
	@Test(priority = 3)
	public void addNewUser() {
		AddNewCustomerPage page = new AddNewCustomerPage(driver);
		page.getCustomerName_Textfield().click();
		page.getAddressTextarea().click();
		Assert.assertEquals(page.customerNameErrorMessageIsDisplayed(), true,"Customer name must not be blank is displayed");
		logger.info("Customer name must not be blank is displayed");
		page.getDateOfBirth_Textfield().click();
		page.getAddressTextarea().click();
		Assert.assertEquals(page.dateFieldErrorMessageIsDisplayed(), true,"Date Field must not be blank");
		logger.info("Date Field must not be blank is Displayed");
		Assert.assertEquals(page.addressFieldErrorMessageIsDisplayed(), true,"Address Field must not be blank");
		logger.info("Address Field must not be blank is displayed");
		page.getCityTextField().click();
		page.getStateTextField().click();
		Assert.assertEquals(page.getCityTextField().isDisplayed(), true,"City Field must not be blank");
		logger.info("City Field must not be blank is Displayed");
		page.getPinnoTextField().click();
		Assert.assertEquals(page.getStateTextField().isDisplayed(), true,"State Field must not be blank");
		logger.info("State Field must not be blank is displayed");
		page.getTelephonenoTextField().click();
		Assert.assertEquals(page.getPinnoTextField().isDisplayed(), true,"Pin Field must not be blank");
		logger.info("Pin Field must not be blank is displayed");
		page.getEmailidTextField().click();
		Assert.assertEquals(page.mobilenoFieldErrorMessageIsDisplayed(), true,"Mobile No Field must not be blank");
		logger.info("Mobile Number Field must not be blank is displayed");
		page.getPasswordTextField().click();
		Assert.assertEquals(page.emailIdFieldErrorMessageIsDisplayed(), true,"Email ID  Field must not be blank");
		logger.info("Email Id  Field must not be blank is displayed");
		page.getEmailidTextField().click();
		Assert.assertEquals(page.passwordFieldErrorMessageIsDisplayed(), true,"Password  Field must not be blank");
		logger.info("Password  Field must not be blank is displayed");
		
	}

}
