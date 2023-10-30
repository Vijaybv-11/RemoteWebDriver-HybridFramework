package com.Banking.AddNewAccount;


import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Banking.PageFactory.AddNewCustomerPage;
import com.Banking.PageFactory.LoginPage;
import com.Banking.PageFactory.NewAccountPage;
import com.Banking.PageFactory.WelcomePage;
import com.Banking.Utils.BaseClass;
import com.Banking.Utils.ExcelWriter;
import com.Banking.Utils.FakerData;
import com.Banking.Utils.GetDataFromExcel;
import com.Banking.Utils.ReadConfig;

public class TC002_CreateCurrentAccount extends BaseClass {
	ReadConfig config = new ReadConfig();

	@Test(priority = 1)
	public void login() {
		LoginPage lp = new LoginPage(driver);
		lp.login();
		logger.info("Login Successfull");

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

		config.writeProperty("customerId", page.getCustomerID());

	}

	@Test(priority = 4,dependsOnMethods = {"addNewCustomer"})
	public void addNewSavingsAccount() {
		
		WelcomePage wpage = new WelcomePage(driver);
           wpage.newAccountLink();
           logger.info("Clicked on New Account Link");

		GetDataFromExcel data = new GetDataFromExcel();
		Map<String, String> excelData = data.readData("New Account", "TC002", "testCaseId");
		String AccountType = excelData.get("AccountType");
		String initialDeposit = excelData.get("Initial Deposit");

		NewAccountPage page = new NewAccountPage(driver);
		page.enterInputIntoCustomerTextfield(config.getValueProperty("customerId"));
		page.SelectAccountTypeDropdown(AccountType);
		page.enterInputIntoInitialDeposit(initialDeposit);
		page.clickOnSubmit();
		Wait.until(ExpectedConditions.visibilityOf(page.getAccountGeneratedSuccesfully_Text()));
		Assert.assertEquals(page.getAccountGeneratedSuccesfully_Text().isDisplayed(), true,
				"Account Generated Successfully is displayed");
		logger.info("Current Account Generated Succesfully is Displayed ");
		ExcelWriter writer = new ExcelWriter();
		writer.updateCell("New Account","Account_ID", "TC002", page.getAccountId());
		writer.updateCell("New Account","Customer_ID", "TC002", page.getCustomerId());
		writer.updateCell("New Account","Customer_Name", "TC002", page.getCustomerName());
		writer.updateCell("New Account","Email", "TC002", page.getEmailId());
		writer.updateCell("New Account","Current_Amount", "TC002", page.getCurrentAmount());
		logger.info("Data has been written to Excel Succesfully");

	}

}

