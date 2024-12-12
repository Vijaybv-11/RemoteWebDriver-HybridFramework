package Utils.UIUtils;

import Utils.LogUtils.LogUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

/***
 *
 * @author Vijay
 *
 */
public class JavaScriptUtil extends BaseClass {

    public JavascriptExecutor javaScript = (JavascriptExecutor) getDriver();


    /**
     * This method is used to perform Click operation using JavascriptExecutor
     *
     * @param element pass the web element on which click action has to be performed
     */
    public void clickOnElement(WebElement element) {
        javaScript.executeScript("arguments[0].click();", element);
        LogUtils.logInfo("Clicked on Element using Javascript Executor");
    }

    /**
     * This method is used to send the data to a text filed using JavascriptExecutor
     *
     * @param element pass the text box element in which data has to be passed
     */
    public void enterInputToElement(String data, WebElement element) {
        javaScript.executeScript("arguments[0].value='" + data + "';", element);
        LogUtils.logInfo("Entered " + data + " into Textbox");

    }

    /**
     * This method is used to perform scrolling action in X and Y direction using
     * JavascriptExecutor
     *
     * @param X pass the X pixels value (distance in X direction)
     * @param Y pass the Y pixels value (distance in Y direction)
     */
    public void scrollUsingCoordinates(int X, int Y) {
        javaScript.executeScript("window.scrollBy(" + X + "," + Y + ")");
        LogUtils.logInfo("Scrolled using co-ordinates " + X + " & " + Y);

    }


    /**
     * This method is used to scroll upto an element
     *
     * @param bool    if given true it will match the top of the element to top of
     *                the page and vice versa
     * @param element upto which you want to scroll
     */
    public void scrollUntilElementIsVisible(boolean bool, WebElement element) {
        javaScript.executeScript("arguments[0].scrollIntoView(" + bool + ")", element);
        LogUtils.logInfo("Scrolled until Element is Visible ");

    }

    /**
     * Used to scroll to the bottom of the page
     */
    public void jsScrollToBottomOfThePage() {
        javaScript.executeScript("arguments[0].scrollBy(0,document.body.scrollHeight')");
        LogUtils.logInfo("Scrolled till the bottom");
    }

    /**
     * This method is used to put a red border for the given element
     *
     * @param element
     */
    public void putBorderOnElement(WebElement element) {
        javaScript.executeScript("arguments[0].style.border='3px solid red';", element);
        LogUtils.logInfo("Added border on Element");

    }

    /**
     * This method is used to apply given color on the given element
     *
     * @param color   send rgb values [ rgb(0,225,0) ]
     * @param element
     */

    public void changeColorOfElement(String color, WebElement element) {
        javaScript.executeScript("arguments[0].style.backgroundColor = '" + color + "';", element);
        LogUtils.logInfo("Changing color to " + color + " of an element ");

    }

    /**
     * Used to get the value present in the text box using JavascriptExecutor
     *
     * @param element text box element
     * @return the text present in the text box
     */
    public String fetchValue(WebElement element) {
        return (String) javaScript.executeScript("return arguments[0].value", element);

    }

    /**
     * Used to refresh the page
     */
    public void refreshPage() {
        javaScript.executeScript("history.go(0)");
        LogUtils.logInfo("Refreshed Page");
    }

    /**
     * Used to clear the content in the text area using JavascriptExecutor
     *
     * @param element text box element
     */
    public void clearText(WebElement element) {
        javaScript.executeScript("arguments[0].value='';", element);
        LogUtils.logInfo("Cleared Text from an Element");

    }
}