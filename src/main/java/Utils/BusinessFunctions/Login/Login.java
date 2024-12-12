package Utils.BusinessFunctions.Login;

import HyperFaceDashboardPages.HomePage;
import HyperFaceDashboardPages.LoginPage;
import Utils.LogUtils.LogUtils;
import org.openqa.selenium.WebDriver;

public class Login {

    WebDriver driver;

   public Login(WebDriver driver){
        this.driver=driver;
    }

    public void loginToDashBoard(){
        LogUtils.logInfo("Logging into Dashboard");
        LoginPage loginPage= new LoginPage(driver);
        loginPage.loginToDashboard("testing@hyperface.co","Hyperface@2026");
        LogUtils.logPass("User logged in successfully");
        new HomePage(driver).isHyperFaceLogoDisplayed();
    }
}
