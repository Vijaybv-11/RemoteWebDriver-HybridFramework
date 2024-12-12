package HyperFaceDashboardPages;

import Utils.LogUtils.LogUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "username")
    private WebElement userName_Textfield;

    @FindBy(name = "password")
    private WebElement password_Textfield;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    private WebElement submit_Button;

    public void loginToDashboard(String userName, String password) {
        userName_Textfield.sendKeys(userName);
        LogUtils.logInfo("Entered " + userName + " into username text field");
        password_Textfield.sendKeys(password);
        LogUtils.logInfo("Entered " + password + " into password Textfield");
        submit_Button.click();
        LogUtils.logInfo("Clicked on Submit Button");
    }
}
