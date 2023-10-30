package com.Banking.Deposit;

import java.util.Map;

import org.testng.annotations.Test;

import com.Banking.PageFactory.DepositPage;
import com.Banking.PageFactory.LoginPage;
import com.Banking.PageFactory.WelcomePage;
import com.Banking.Utils.BaseClass;
import com.Banking.Utils.GetDataFromExcel;

public class TC001_DepositMoney extends BaseClass {

	@Test(priority = 1)
	public void login() {

		LoginPage lp = new LoginPage(driver);
		lp.login();
	}

	@Test(priority = 2)
	public void manager() {
		WelcomePage page = new WelcomePage(driver);
		page.getDepositLink().click();
		logger.info("Clicked on Deposit  Link");

	}

	@Test(priority = 3)
	public void Deposit()  {
		GetDataFromExcel data = new GetDataFromExcel();
		Map<String, String> mapData = data.readData("New Account", "TC001", "testCaseId");
		DepositPage page = new DepositPage(driver);
		page.enterInputIntoAccountNumberTextfield(mapData.get("Account_ID"));
		page.enterInputIntoAmountTextfield("10000");
		page.enterInputIntoDescriptionTextfield("Amount sending");
		page.clickOnSubmitButton();
		
		logger.info("Amount Deposited Successfuly");

	}

}
