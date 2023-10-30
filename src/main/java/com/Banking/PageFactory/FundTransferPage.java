package com.Banking.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FundTransferPage extends BasePage {

	public FundTransferPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(name = "payersaccount")
	public WebElement PayersAccountTextfield;

	public void enterInputIntoPayerAcoount(String AccountNumber) {
		PayersAccountTextfield.sendKeys(AccountNumber);
	}

	@FindBy(name = "payeeaccount")
	public WebElement PayeeAccountTextfield;

	public void enterInputIntoPayeeAcoount(String AccountNumber) {
		PayeeAccountTextfield.sendKeys(AccountNumber);
	}

	@FindBy(name = "ammount")
	public WebElement amountTextfield;

	public void enterInputIntoAmountTextfield(String AmountNumber) {
		amountTextfield.sendKeys(AmountNumber);
	}

	@FindBy(name = "desc")
	public WebElement DescriptionTextfield;

	public void enterInputIntoDescriptionTextfield(String Description) {
		DescriptionTextfield.sendKeys(Description);
	}

	@FindBy(name = "AccSubmit")
	public WebElement SubmitButton;

	public void clickOnSubmitButton() {
		SubmitButton.click();
	}

}
