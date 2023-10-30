package com.Banking.DeleteAccount;

import java.util.Map;

import org.testng.annotations.Test;

import com.Banking.PageFactory.DeleteAccountPage;
import com.Banking.PageFactory.LoginPage;
import com.Banking.PageFactory.WelcomePage;
import com.Banking.Utils.BaseClass;
import com.Banking.Utils.GetDataFromExcel;

public class TC001_DeleteAccount extends BaseClass {
	
	
	@Test(priority = 1)
	public void login() {

		LoginPage lp = new LoginPage(driver);
		lp.login();
	}

	@Test(priority = 2)
	public void manager() {
		WelcomePage page = new WelcomePage(driver);
		page.getDeleteAccountLink().click();
		logger.info("Clicked on Delete Account Link");

	}
	
	@Test(priority =3)
	public void deleteAccount() {
		DeleteAccountPage page = new DeleteAccountPage(driver);
		GetDataFromExcel data = new GetDataFromExcel();
		Map<String , String> mapdata =data.readData("New Account", "TC002", "testCaseId");
		page.enterInputIntoAccountNumberTextfield(mapdata.get("Account_ID"));
		page.clickonSubmitButton();
		
	}


}
