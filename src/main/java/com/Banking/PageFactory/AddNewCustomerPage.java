package com.Banking.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddNewCustomerPage extends BasePage {

	public AddNewCustomerPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	


	@FindBy(xpath = "//p[@class='heading3']")
	private WebElement AddNewCustomerTitle;

	public boolean AddNewCustomerTitle() {
		return AddNewCustomerTitle.isDisplayed();
	}
	
	@FindBy(xpath="//p[text()='Customer Registered Successfully!!!']")
private WebElement customerRegisteredSuccesfully;
	
	
	
	public WebElement getCustomerRegisteredSuccesfully() {
		return customerRegisteredSuccesfully;
	}

	public void setCustomerRegisteredSuccesfully(WebElement customerRegisteredSuccesfully) {
		this.customerRegisteredSuccesfully = customerRegisteredSuccesfully;
	}



	@FindBy(name = "name")
	private WebElement customerName_Textfield;

	public void customerName(String customerName) {
		customerName_Textfield.sendKeys(customerName);
	}
	
	@FindBy(name = "dob")
	private WebElement dateOfBirth_Textfield;

	public void dateOfBirth(String dob) {
		dateOfBirth_Textfield.sendKeys(dob);
	}

	@FindBy(xpath = "//input[@value='m']")
	private WebElement maleradioButton;

	public void clickonMaleRadio() {
		maleradioButton.click();
	}

	@FindBy(xpath = "//input[@value='f']")
	private WebElement femalemaleradioButton;

	public void clickonfemaleRadio() {
		femalemaleradioButton.click();
	}

	@FindBy(name = "addr")
	private WebElement addressTextarea;

	public void address(String address) {
		addressTextarea.sendKeys(address);
	}

	@FindBy(name = "city")
	private WebElement cityTextField;

	public void city(String cityName) {
		cityTextField.sendKeys(cityName);
	}

	@FindBy(name = "state")
	private WebElement stateTextField;

	public void stateName(String stateName) {
		stateTextField.sendKeys(stateName);
	}

	@FindBy(name = "pinno")
	private WebElement pinnoTextField;

	public void pincode(String pincode) {
		pinnoTextField.sendKeys(pincode);
	}

	@FindBy(name = "telephoneno")
	private WebElement telephonenoTextField;

	public void telephone(String mobileNumber) {
		telephonenoTextField.sendKeys(mobileNumber);
	}

	@FindBy(name = "emailid")
	private WebElement emailidTextField;

	public void emailID(String emailID) {
		emailidTextField.sendKeys(emailID);
	}

	@FindBy(name = "password")
	private WebElement passwordTextField;

	public void password(String password) {
		passwordTextField.sendKeys(password);
	}

	@FindBy(name = "sub")
	private WebElement submitButton;

	public void clickonSubmit() {
		submitButton.click();
	}

	@FindBy(name = "res")
	private WebElement resetButton;

	public void clickonReset() {
		resetButton.click();
	}
	
	@FindBy(xpath = "//label[text()='Customer name must not be blank']")
	public WebElement customerNameErrorMessage;
	
	public boolean customerNameErrorMessageIsDisplayed() {
		return customerNameErrorMessage.isDisplayed();
	}
	
	@FindBy(xpath = "//label[text()='Date Field must not be blank']")
	public WebElement dateFieldErrorMessage;
	
	public boolean dateFieldErrorMessageIsDisplayed() {
		return dateFieldErrorMessage.isDisplayed();
	}
	
	@FindBy(xpath = "//label[text()='Address Field must not be blank']")
	public WebElement addressFieldErrorMessage;
	
	public boolean addressFieldErrorMessageIsDisplayed() {
		return addressFieldErrorMessage.isDisplayed();
	}
	

	@FindBy(xpath = "//label[text()='City Field must not be blank']")
	public WebElement cityFieldErrorMessage;
	
	public boolean cityFieldErrorMessageIsDisplayed() {
		return addressFieldErrorMessage.isDisplayed();
	}

	
	@FindBy(xpath = "//label[text()='State must not be blank']")
	public WebElement stateFieldErrorMessage;
	
	public boolean stateFieldErrorMessageIsDisplayed() {
		return stateFieldErrorMessage.isDisplayed();
	}

	@FindBy(xpath = "//label[text()='PIN Code must not be blank']")
	public WebElement pincodeFieldErrorMessage;
	
	public boolean pincodeFieldErrorMessageIsDisplayed() {
		return pincodeFieldErrorMessage.isDisplayed();
	}
	
	@FindBy(xpath = "//label[text()='Mobile no must not be blank']")
	public WebElement mobilenumberFieldErrorMessage;
	
	public boolean mobilenoFieldErrorMessageIsDisplayed() {
		return mobilenumberFieldErrorMessage.isDisplayed();
	}
	
	@FindBy(xpath = "//label[text()='Email-ID must not be blank']")
	public WebElement emailFieldErrorMessage;
	
	public boolean emailIdFieldErrorMessageIsDisplayed() {
		return emailFieldErrorMessage.isDisplayed();
	}

	@FindBy(xpath = "//label[text()='Password must not be blank']")
	public WebElement passwordFieldErrorMessage;
	
	public boolean passwordFieldErrorMessageIsDisplayed() {
		return passwordFieldErrorMessage.isDisplayed();
	}
	@FindBy(xpath = "//td[text()='Customer ID']/following-sibling::td")
	public WebElement customerId;
	
	public String getCustomerID() {
		return customerId.getText();
	}
	


	public WebElement getAddNewCustomerTitle() {
		return AddNewCustomerTitle;
	}

	public void setAddNewCustomerTitle(WebElement addNewCustomerTitle) {
		AddNewCustomerTitle = addNewCustomerTitle;
	}

	public WebElement getCustomerName_Textfield() {
		return customerName_Textfield;
	}

	public void setCustomerName_Textfield(WebElement customerName_Textfield) {
		this.customerName_Textfield = customerName_Textfield;
	}

	public WebElement getMaleradioButton() {
		return maleradioButton;
	}

	public void setMaleradioButton(WebElement maleradioButton) {
		this.maleradioButton = maleradioButton;
	}

	public WebElement getDateOfBirth_Textfield() {
		return dateOfBirth_Textfield;
	}

	public void setDateOfBirth_Textfield(WebElement dateOfBirth_Textfield) {
		this.dateOfBirth_Textfield = dateOfBirth_Textfield;
	}

	public WebElement getFemalemaleradioButton() {
		return femalemaleradioButton;
	}

	public void setFemalemaleradioButton(WebElement femalemaleradioButton) {
		this.femalemaleradioButton = femalemaleradioButton;
	}

	public WebElement getAddressTextarea() {
		return addressTextarea;
	}

	public void setAddressTextarea(WebElement addressTextarea) {
		this.addressTextarea = addressTextarea;
	}

	public WebElement getCityTextField() {
		return cityTextField;
	}

	public void setCityTextField(WebElement cityTextField) {
		this.cityTextField = cityTextField;
	}

	public WebElement getStateTextField() {
		return stateTextField;
	}

	public void setStateTextField(WebElement stateTextField) {
		this.stateTextField = stateTextField;
	}

	public WebElement getPinnoTextField() {
		return pinnoTextField;
	}

	public void setPinnoTextField(WebElement pinnoTextField) {
		this.pinnoTextField = pinnoTextField;
	}

	public WebElement getTelephonenoTextField() {
		return telephonenoTextField;
	}

	public void setTelephonenoTextField(WebElement telephonenoTextField) {
		this.telephonenoTextField = telephonenoTextField;
	}

	public WebElement getEmailidTextField() {
		return emailidTextField;
	}

	public void setEmailidTextField(WebElement emailidTextField) {
		this.emailidTextField = emailidTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public void setPasswordTextField(WebElement passwordTextField) {
		this.passwordTextField = passwordTextField;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public void setSubmitButton(WebElement submitButton) {
		this.submitButton = submitButton;
	}

	public WebElement getResetButton() {
		return resetButton;
	}

	public void setResetButton(WebElement resetButton) {
		this.resetButton = resetButton;
	}

}
