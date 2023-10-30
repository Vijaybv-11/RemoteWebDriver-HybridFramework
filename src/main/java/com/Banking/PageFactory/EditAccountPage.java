package com.Banking.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditAccountPage extends BasePage {

	public EditAccountPage(WebDriver driver) {
		super(driver);

	}
	@FindBy(xpath = "//p[text()='Edit Account Form']")
	public WebElement editAccountFormText;

	public boolean editAccountFormTextisDisplayed() {
		return editAccountFormText.isDisplayed();
	}

	@FindBy(xpath = "//input[@name='accountno']")
	public WebElement accountNumber_Textfield;

	public void enterInputintoAccountNumberTextfield(String accountNumber) {

		accountNumber_Textfield.sendKeys(accountNumber);
	}
	
	@FindBy(name = "AccSubmit")
	public WebElement submitButton;

	public void clickOnSubmitButton() {
		submitButton.click();
	}

}
