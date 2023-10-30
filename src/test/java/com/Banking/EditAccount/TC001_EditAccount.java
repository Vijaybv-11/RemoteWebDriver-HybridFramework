package com.Banking.EditAccount;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Banking.PageFactory.EditAccountPage;
import com.Banking.PageFactory.LoginPage;
import com.Banking.PageFactory.WelcomePage;
import com.Banking.Utils.BaseClass;
import com.Banking.Utils.GetDataFromExcel;

public class TC001_EditAccount extends BaseClass {

	@Test(priority = 1)
	public void login() {

		LoginPage lp = new LoginPage(driver);
		lp.login();
	}

	@Test(priority = 2)
	public void manager() {
		WelcomePage page = new WelcomePage(driver);
		page.getEditAccountLink().click();
		logger.info("Clicked on Edit Account Link");

	}

	@Test(priority = 3)
	public void editAccount() {

		GetDataFromExcel data = new GetDataFromExcel();
		Map<String, String> excelData = data.readData("New Account", "TC002", "testCaseId");
		String accountId=excelData.get("Account_ID");
		EditAccountPage page = new EditAccountPage(driver);
		Assert.assertEquals(page.editAccountFormTextisDisplayed(), true, "Edit Account Form is Displayed");
		page.enterInputintoAccountNumberTextfield(accountId);
		page.clickOnSubmitButton();

	}

}
