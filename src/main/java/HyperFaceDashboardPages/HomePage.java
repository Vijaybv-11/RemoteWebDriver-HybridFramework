package HyperFaceDashboardPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='large_logo']")
    private WebElement hyperface_Logo;





    public void isHyperFaceLogoDisplayed(){
        Assert.assertTrue(hyperface_Logo.isDisplayed());
    }


}
