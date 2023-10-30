package com.Banking.FundTransfer;

import java.util.Map;

import org.testng.annotations.Test;

import com.Banking.PageFactory.FundTransferPage;
import com.Banking.PageFactory.LoginPage;
import com.Banking.PageFactory.WelcomePage;
import com.Banking.Utils.BaseClass;
import com.Banking.Utils.GetDataFromExcel;

public class TC001_FundTransfer extends BaseClass {

	@Test(priority = 1)
	public void login() {
		LoginPage page = new LoginPage(driver);
		page.login();
	}

	@Test(priority = 2)
	public void manager() {

		WelcomePage page = new WelcomePage(driver);
		page.getFund_TransferLink().click();
		logger.info("Clicked on Fund Transfer Link");

	}

	@Test(priority = 3)
	public void fundTransfer() {
		GetDataFromExcel data = new GetDataFromExcel();
		Map<String, String> mapData = data.readData("New Account", "TC001", "testCaseId");
		Map<String, String> mapData1 = data.readData("New Account", "TC002", "testCaseId");
		FundTransferPage page = new FundTransferPage(driver);
		page.enterInputIntoPayeeAcoount(mapData1.get("Account_ID"));
		page.enterInputIntoPayerAcoount(mapData.get("Account_ID"));
		page.enterInputIntoAmountTextfield("5000");
		page.enterInputIntoDescriptionTextfield("HiBye");

		logger.info("Fund transfered Succesfully");

	}

}
