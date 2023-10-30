package com.Banking.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DepositPage extends BasePage {

	public DepositPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(name = "accountno")
	public WebElement AccountNumberTextfield;
	
	public void enterInputIntoAccountNumberTextfield(String AccountNumber) {
		AccountNumberTextfield.sendKeys(AccountNumber);
	}
	
	@FindBy(name = "balance")
	public WebElement AmountTextfield;
	

	public void enterInputIntoAmountTextfield(String Amount) {
		AmountTextfield.sendKeys(Amount);
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
