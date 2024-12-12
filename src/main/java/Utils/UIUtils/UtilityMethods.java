package Utils.UIUtils;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Set;

import Utils.LogUtils.LogUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Vijay
 */
public class UtilityMethods extends BaseClass {


    Alert alert;
    Actions actions;
    Select select;


    public String getTitle() {
        String title = getDriver().getTitle();
        LogUtils.logInfo("Title of the Page is " + title);
        return title;
    }

    public String getUrl() {
        String CurrentURL = getDriver().getCurrentUrl();
        LogUtils.logInfo("Current URL of the Page is " + CurrentURL);
        return CurrentURL;


    }

    public void clickOnElementUsingActions(WebElement element) {
        actions = new Actions(getDriver());
        actions.click(element).perform();
        LogUtils.logInfo("Clicked on Element using Actions");
    }

    public void enterInput(WebElement element, String value) {
        actions = new Actions(getDriver());
        actions.sendKeys(element, value).perform();
        LogUtils.logInfo("Entered " + value + " to TextField using Actions");

    }


    public void switchToASpecificUrlWindow(String url) {
        String parentWindowId = getDriver().getWindowHandle();

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

    public void switchToFrameUsingElement(WebElement element) {

        getDriver().switchTo().frame(element);
    }

    public static String getScreenShot(String testName) {
        TakesScreenshot ts = (TakesScreenshot) getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String destination = System.getProperty("user.dir") + "/Screenshots/" + testName + " - " + timeStamp + ".png";
        try {
            File finalDestination = new File(destination);
            finalDestination.getParentFile().mkdirs();
            Files.copy(source.toPath(), finalDestination.toPath());
        } catch (IOException e) {
            LogUtils.logException(e);

        }
        return destination;
    }

    public static String getScreenShotAsBase64() {
        TakesScreenshot ts = (TakesScreenshot) getDriver();
        String source = ts.getScreenshotAs(OutputType.BASE64);
        return source;
    }


    public void acceptAlert() {

        alert = getDriver().switchTo().alert();
        alert.accept();

    }

    public void declineAlert() {

        alert = getDriver().switchTo().alert();
        alert.dismiss();

    }

    public void enterInputIntoAlert(String alertInput) {

        alert = getDriver().switchTo().alert();
        alert.sendKeys(alertInput);

    }

    public String getAlertMessage() {

        alert = getDriver().switchTo().alert();
        return alert.getText();

    }

    public static String captureScreenshotAsBase64() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);
    }

    public static File saveBase64ToFile(String base64String, String fileName) {
        // Decode the Base64 string
        byte[] imageBytes = Base64.getDecoder().decode(base64String);

        // Create a file to save the image
        File imageFile = new File(fileName);
        try (FileOutputStream fos = new FileOutputStream(imageFile)) {
            fos.write(imageBytes);
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
        return imageFile;
    }

    public void selectByVisibleText(WebElement DropDown, String visibleText) {
        select = new Select(DropDown);
        select.selectByVisibleText(visibleText);
    }

    public void selectByIndex(WebElement dropdown, int i) {
        select = new Select(dropdown);
        select.selectByIndex(i);
    }


}
