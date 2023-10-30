package com.Banking.LoginModule;

import org.testng.annotations.Test;

import com.Banking.PageFactory.LoginPage;
import com.Banking.Utils.BaseClass;

public class TC001_LogintoApplication extends BaseClass {
	
	
	@Test
	public void login() {
		LoginPage lp = new LoginPage(driver);
			 lp.login();
			 logger.info("Login Successfull");
			 
	}

}
