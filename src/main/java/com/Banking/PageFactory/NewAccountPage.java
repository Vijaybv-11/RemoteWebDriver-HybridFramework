package com.Banking.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage  extends BasePage{
	
	public NewAccountPage(WebDriver driver ) {
		super(driver);
		
	}
	
	@FindBy(xpath = "//p[text()='Add new account form']")
	public WebElement AddNewAccountTitle;
	
	public boolean AddNewAccountTitleisDisplayed() {
		return AddNewAccountTitle.isDisplayed();
	}
	
	
	@FindBy(xpath = "//input[@name='cusid']")
	public WebElement cutomerID_Textfield;
	

	public void enterInputIntoCustomerTextfield(String customerID) {
		 cutomerID_Textfield.sendKeys(customerID);
	}
	
	@FindBy(xpath = "//select[@name='selaccount']")
	public WebElement AccountType_Dropdown;
	
	public void SelectAccountTypeDropdown(String accountType) {
		 Select select = new Select(AccountType_Dropdown);
		 select.selectByVisibleText(accountType);
	}
	
	@FindBy(xpath = "//input[@name='inideposit']")
	public WebElement InitialDeposit_Textfield;
	
	public void enterInputIntoInitialDeposit(String deposit) {
		InitialDeposit_Textfield.sendKeys(deposit);
	}
	
	@FindBy(xpath = "//input[@name='button2']")
	public WebElement submit_Button;
	
	public void clickOnSubmit() {
		submit_Button.click();
	}
	
	@FindBy(xpath = "//p[text()='Account Generated Successfully!!!']")
	private WebElement accountGeneratedSuccesfully_Text;
	
	public WebElement getAccountGeneratedSuccesfully_Text() {
		return accountGeneratedSuccesfully_Text;
	}

	public void setAccountGeneratedSuccesfully_Text(WebElement accountGeneratedSuccesfully_Text) {
		this.accountGeneratedSuccesfully_Text = accountGeneratedSuccesfully_Text;
	}

	public boolean acoountGeneratedisDisplayed() {
		return accountGeneratedSuccesfully_Text.isDisplayed();
	}
	
	@FindBy(xpath = "//td[text()='Account ID']/following-sibling::td")
	public WebElement accountId_Text;
	
	public String getAccountId() {
		return accountId_Text.getText();
	}
	

	@FindBy(xpath = "//td[text()='Customer ID']/following-sibling::td")
	public WebElement customerId_Text;
	
	public String getCustomerId() {
		return customerId_Text.getText();
	}
	
	

	@FindBy(xpath = "//td[text()='Customer Name']/following-sibling::td")
	public WebElement customerName_Text;
	
	public String getCustomerName() {
		return customerName_Text.getText();
	}
	
	

	@FindBy(xpath = "//td[text()='Email']/following-sibling::td")
	public WebElement Email_Text;
	
	public String getEmailId() {
		return Email_Text.getText();
	}
	

	@FindBy(xpath = "//td[text()='Account Type']/following-sibling::td")
	public WebElement AccountType_Text;
	
	public String getAccountType() {
		return AccountType_Text.getText();
	}
	

	@FindBy(xpath = "//td[text()='Date of Opening']/following-sibling::td")
	public WebElement DateofOpening_Text;
	
	public String getdateOfOpening() {
		return DateofOpening_Text.getText();
	}

	@FindBy(xpath = "//td[text()='Current Amount']/following-sibling::td")
	public WebElement CurrentAmount_Text;
	
	public String getCurrentAmount() {
		return CurrentAmount_Text.getText();
	}
	
	
	

}
