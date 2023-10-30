package com.Banking.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteCustomer extends BasePage {

	public DeleteCustomer(WebDriver driver) {
		super(driver);

	}

	@FindBy(name = "cusid")
	public WebElement customerIdTextfield;

	public void enterCustomerID(String customerId) {
		customerIdTextfield.sendKeys(customerId);
	}

	@FindBy(name = "AccSubmit")
	public WebElement submitButton;

	public void clickonSubmit() {
		submitButton.click();
	}

	@FindBy(xpath = "//p[text()='Delete Customer Form']")
	public WebElement deleteCustomerFormText;

	public boolean deleteCustomerFormTextisDisplayed() {
		return deleteCustomerFormText.isDisplayed();
	}
}
