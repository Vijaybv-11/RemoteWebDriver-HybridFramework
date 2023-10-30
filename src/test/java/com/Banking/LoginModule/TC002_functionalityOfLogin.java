package com.Banking.LoginModule;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import com.Banking.PageFactory.LoginPage;
import com.Banking.Utils.BaseClass;
import com.Banking.Utils.UtilityMethods;

public class TC002_functionalityOfLogin extends BaseClass {

	@Test
	public void loginfunctionality()  {

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername("1234");
		loginpage.enterPassword("1234");
		loginpage.clickOnLogin();
		Wait.until(ExpectedConditions.alertIsPresent());
			UtilityMethods um = new UtilityMethods();
		 String alertMessage=	um.getAlertMessage();
		 System.out.println(alertMessage);
		 um.acceptAlert();
		
	}

}
