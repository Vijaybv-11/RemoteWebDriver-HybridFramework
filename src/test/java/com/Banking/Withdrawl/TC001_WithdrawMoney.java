package com.Banking.Withdrawl;

import java.util.Map;

import org.testng.annotations.Test;

import com.Banking.PageFactory.LoginPage;
import com.Banking.PageFactory.WelcomePage;
import com.Banking.PageFactory.WithdrawPage;
import com.Banking.Utils.BaseClass;
import com.Banking.Utils.GetDataFromExcel;

public class TC001_WithdrawMoney extends BaseClass {
	
	@Test(priority = 1)
	public void login() {

		LoginPage lp = new LoginPage(driver);
		lp.login();
	}

	@Test(priority = 2)
	public void manager() {
		WelcomePage page = new WelcomePage(driver);
		page.getWithdrawlLink().click();
		logger.info("Clicked on Withdraw  Link");

	}
	
	@Test(priority = 3)
	public void withdraw() {
		GetDataFromExcel data = new GetDataFromExcel();
		Map<String, String> mapData = data.readData("New Account", "TC001", "testCaseId");
		WithdrawPage page = new WithdrawPage(driver);
		page.enterInputIntoAccountNumberTextfield(mapData.get("Account_ID"));
		page.enterInputIntoAmountTextfield("10000");
		page.enterInputIntoDescriptionTextfield("Withdrawing Money");
		page.clickOnSubmitButton();
		logger.info("Amount Withdrawed Successfuly");
		
	}

}
