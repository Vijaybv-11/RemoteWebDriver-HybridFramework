package DashboardTests;

import Utils.BusinessFunctions.Login.Login;
import Utils.UIUtils.BaseClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    Login login;

    @BeforeClass
    public void setupCredentials() {
        login = new Login(getDriver());
    }

    @Test
    public void login(){
       login.loginToDashBoard();
    }

}
