package com.Banking.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteAccountPage extends BasePage {

	public DeleteAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(name = "accountno")
	public WebElement AccountNumberTextfield;

	public void enterInputIntoAccountNumberTextfield(String AccountNumber) {

		AccountNumberTextfield.sendKeys(AccountNumber);
	}

	@FindBy(name = "AccSubmit")
	public WebElement SubmitButton;

	public void clickonSubmitButton() {

		SubmitButton.click();
	}

}
