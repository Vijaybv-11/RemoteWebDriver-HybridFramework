package com.Banking.Utils;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author Vijay
 *
 */
public class UtilityMethods extends BaseClass{

	
	Alert alert;
	public static String name() {
		LocalDateTime sysdate = LocalDateTime.now();
		String name = sysdate.toString().replace(":", "-");
		
		return name;
	}

	public void getTitle() {
		String title = getDriver().getTitle();
		logger.info("Current Page Tilte is " + title);
	}

	public void getUrl() {
		String CurrentURL = getDriver().getCurrentUrl();
		logger.info("Current Page URL is " + CurrentURL);

	}

	public void clickAction(WebElement element_To_Click) {
		element_To_Click.click();
		logger.info("Clicked on  Element " + element_To_Click);

	}

	public void enterInput(WebElement TextField, String value) {
		TextField.sendKeys(value);
		logger.info("Entered " + value + " to " + TextField);

	}

	public Select selectOptions(WebElement DropDown) {
		Select select = new Select(DropDown);
		return select;
	}

	public Actions actions(WebDriver driver) {
		Actions action = new Actions(driver);
		return action;

	}

	public void switchToASpecificUrlWindow(String url) {
		String parentWindowId = driver.getWindowHandle();

		Set<String> allWindowIds = getDriver().getWindowHandles();
		allWindowIds.remove(parentWindowId);
		for (String windowId : allWindowIds) {
			getDriver().switchTo().window(windowId);
			if (getDriver().getCurrentUrl().equalsIgnoreCase(url)) {
				break;

			}
		}
		//logger.info("Switched to Specific URL Window ");
	}

	public void switchToASpecificWindow(WebElement element) {

		String parent = getDriver().getWindowHandle();
		Set<String> allWid = getDriver().getWindowHandles();
		allWid.remove(parent);
		for (String sessionID : allWid) {
			getDriver().switchTo().window(sessionID);

			if (element.isDisplayed()) {
				break;
			}
		}
		//logger.info("Switched to Specific Window ");
	}

	public void switchToFrame(WebElement element) {

		getDriver().switchTo().frame(element);
		logger.info("Switched to Frame");
	}

	public static String getScreenShot(WebDriver driver) {

		String imgPath = screenshotPath + name() + ".png";
		File takeScreenShot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		File destination = new File(imgPath);
		try {
			FileHandler.copy(takeScreenShot, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  imgPath;
	}

	public void acceptAlert() {

		 alert = getDriver().switchTo().alert();
		alert.accept();
		logger.info("Alert Accepted");

	}

	public void declineAlert() {

		 alert = getDriver().switchTo().alert();
		alert.dismiss();
		logger.info("Alert Dismissed");

	}
	public void enterInputintoAlert(String alertInput) {

		 alert = getDriver().switchTo().alert();
		alert.sendKeys(alertInput);
		logger.info("Alert Dismissed");

	}
	public String getAlertMessage() {

		 alert = getDriver().switchTo().alert();
		return alert.getText();
		
	}
	
}
