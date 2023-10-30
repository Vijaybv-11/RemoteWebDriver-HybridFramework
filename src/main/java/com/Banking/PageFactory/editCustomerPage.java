package com.Banking.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class editCustomerPage extends BasePage {

	public editCustomerPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(name = "cusid")
	public WebElement customerIDTextField;

	public void enterCustomerId(String customerId) {
		customerIDTextField.sendKeys(customerId);
	}

	@FindBy(xpath = "//p[text()='Edit Customer Form']")
	public WebElement editCustomerForm;

	public boolean editCustomerId() {
		return editCustomerForm.isDisplayed();
	}
	
	@FindBy(name = "AccSubmit")
	public WebElement Submit_Button;

	public void clickonSubmit() {
		 Submit_Button.click();
	}
	
	@FindBy(xpath = "//p[text()='Edit Customer']")
	public WebElement editCustomer;

	public boolean editCustomerisDisplayed() {
		return editCustomer.isDisplayed();
	}
	

}
