package com.Banking.PageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.Banking.Utils.ReadConfig;

public class LoginPage extends BasePage{



    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy(name = "uid")
    WebElement user_textfield;

    @FindBy(name = "password")
    WebElement password_textfield;

    @FindBy(name = "btnLogin")
    WebElement login_button;


    public void enterUsername(String username){
        user_textfield.sendKeys(username);

    }
    public void enterPassword(String password){
        password_textfield.sendKeys(password);

    }
    public void clickOnLogin(){
        login_button.click();

    }
    public void login( ){
    	ReadConfig config = new ReadConfig();
		String username =config.getValueProperty("username");
		String Password=config.getValueProperty("password");
		enterUsername(username);
		enterPassword(Password);
		clickOnLogin();
        logger.info("Login into the application using username :"+username +" and password :"+Password );
    }

}
