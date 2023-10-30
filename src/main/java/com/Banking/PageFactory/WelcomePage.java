package com.Banking.PageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WelcomePage extends BasePage {

	public WelcomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[@class='barone']")
	private WebElement BankTitle;

	public void BankTitle() {
		BankTitle.isDisplayed();
	}

	@FindBy(linkText = "Manager")
	private WebElement ManagerLink;

	public WebElement getBankTitle() {
		return BankTitle;
	}

	public void setBankTitle(WebElement bankTitle) {
		BankTitle = bankTitle;
	}

	public WebElement getManagerLink() {
		return ManagerLink;
	}

	public void setManagerLink(WebElement managerLink) {
		ManagerLink = managerLink;
	}

	public WebElement getNewCustomerLink() {
		return NewCustomerLink;
	}

	public void setNewCustomerLink(WebElement newCustomerLink) {
		NewCustomerLink = newCustomerLink;
	}

	public WebElement getEditCustomerLink() {
		return EditCustomerLink;
	}

	public void setEditCustomerLink(WebElement editCustomerLink) {
		EditCustomerLink = editCustomerLink;
	}

	public WebElement getDeleteCustomerLink() {
		return DeleteCustomerLink;
	}

	public void setDeleteCustomerLink(WebElement deleteCustomerLink) {
		DeleteCustomerLink = deleteCustomerLink;
	}

	public WebElement getNewAccountLink() {
		return NewAccountLink;
	}

	public void setNewAccountLink(WebElement newAccountLink) {
		NewAccountLink = newAccountLink;
	}

	public WebElement getEditAccountLink() {
		return EditAccountLink;
	}

	public void setEditAccountLink(WebElement editAccountLink) {
		EditAccountLink = editAccountLink;
	}

	public WebElement getDeleteAccountLink() {
		return DeleteAccountLink;
	}

	public void setDeleteAccountLink(WebElement deleteAccountLink) {
		DeleteAccountLink = deleteAccountLink;
	}

	public WebElement getWithdrawlLink() {
		return WithdrawlLink;
	}

	public void setWithdrawlLink(WebElement withdrawlLink) {
		WithdrawlLink = withdrawlLink;
	}

	public WebElement getDepositLink() {
		return DepositLink;
	}

	public void setDepositLink(WebElement depositLink) {
		DepositLink = depositLink;
	}

	public WebElement getFund_TransferLink() {
		return Fund_TransferLink;
	}

	public void setFund_TransferLink(WebElement fund_TransferLink) {
		Fund_TransferLink = fund_TransferLink;
	}

	public WebElement getMiniStatementLink() {
		return MiniStatementLink;
	}

	public void setMiniStatementLink(WebElement miniStatementLink) {
		MiniStatementLink = miniStatementLink;
	}

	public WebElement getCustomised_StatementLink() {
		return Customised_StatementLink;
	}

	public void setCustomised_StatementLink(WebElement customised_StatementLink) {
		Customised_StatementLink = customised_StatementLink;
	}

	public WebElement getBalanceEnquiryLink() {
		return BalanceEnquiryLink;
	}

	public void setBalanceEnquiryLink(WebElement balanceEnquiryLink) {
		BalanceEnquiryLink = balanceEnquiryLink;
	}

	public WebElement getLogoutLink() {
		return LogoutLink;
	}

	public void setLogoutLink(WebElement logoutLink) {
		LogoutLink = logoutLink;
	}

	public void ManagerLink() {
		ManagerLink.click();
	}

	@FindBy(xpath = "//a[text()='New Customer']")
	private WebElement NewCustomerLink;

	public void NewCustomerLink() {
		NewCustomerLink.click();
	}

	@FindBy(linkText = "Edit Customer")
	private WebElement EditCustomerLink;

	public void EditCustomerLink() {
		EditCustomerLink.click();
	}

	@FindBy(linkText = "Delete Customer")
	private WebElement DeleteCustomerLink;

	public void deleteCustomerLink() {
		DeleteCustomerLink.click();
	}

	@FindBy(linkText = "New Account")
	private WebElement NewAccountLink;

	public void newAccountLink() {
		NewAccountLink.click();
	}

	@FindBy(linkText = "Edit Account")
	private WebElement EditAccountLink;

	public void editAccountLink() {
		EditAccountLink.click();
	}

	@FindBy(linkText = "Delete Account")
	private WebElement DeleteAccountLink;

	public void deleteAccountLink() {
		DeleteAccountLink.click();
	}

	@FindBy(linkText = "Withdrawal")
	private WebElement WithdrawlLink;

	public void withdrawlLink() {
		WithdrawlLink.click();
	}

	@FindBy(linkText = "Deposit")
	private WebElement DepositLink;

	public void depositLink() {
		DepositLink.click();
	}

	@FindBy(linkText = "Fund Transfer")
	private WebElement Fund_TransferLink;

	public void fundTransferLink() {
		Fund_TransferLink.click();
	}

	@FindBy(linkText = "Mini Statement")
	private WebElement MiniStatementLink;

	public void miniStatementLink() {
		MiniStatementLink.click();
	}

	@FindBy(linkText = "Customised Statement")
	private WebElement Customised_StatementLink;

	public void customisedStatementLink() {
		Customised_StatementLink.click();
	}

	@FindBy(linkText = "Balance Enquiry")
	private WebElement BalanceEnquiryLink;

	public void balanceEnquiryLink() {
		BalanceEnquiryLink.click();
	}

	@FindBy(linkText = "Log out")
	private WebElement LogoutLink;

	public void logoutLink() {
		LogoutLink.click();
	}

}
