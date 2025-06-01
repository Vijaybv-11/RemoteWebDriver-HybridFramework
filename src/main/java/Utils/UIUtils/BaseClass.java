package Utils.UIUtils;

import Utils.LogUtils.LogUtils;
import Utils.dataUtils.PropertyUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class BaseClass {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();
    public WebDriverWait wait;
    public static String environmentValue;
    DesiredCapabilities capabilities = new DesiredCapabilities();

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    @BeforeClass(alwaysRun = true)
    @Parameters({"browser", "environment", "headless", "url", "remoteUrl", "browserStackExecution", "lambdaTestExecution", "platformName", "browserVersion"})
    public void setup(@Optional("chrome") String browserName, @Optional("QA") String environment, @Optional("false") boolean runHeadless, @Optional("https://dashboard-sandbox.hyperface.co/dashboard/cardProgram") String url, @Optional("localhost") String remoteUrl, @Optional("false") boolean browserStackExecution, @Optional("false") boolean lambdaTestExecution, @Optional("Windows 10") String platformName, @Optional("latest") String browserVersion) {
        environmentValue = environment;
        WebDriver driver = initializeDriver(browserName, runHeadless, remoteUrl, browserStackExecution, lambdaTestExecution, platformName, browserVersion);
        driverThreadLocal.set(driver);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
    }

    private WebDriver initializeDriver(String browserName, boolean runHeadless, String remoteUrl, boolean browserStackSetup, boolean lambdaTestSetup, String platformName, String browserVersion) {

        try {
            if (browserStackSetup) {
                return initializeBrowserStackDriver();
            } else if (lambdaTestSetup) {
                return initializeLambdaTestDriver(platformName, browserName, browserVersion);
            } else {
                switch (browserName.toLowerCase()) {
                    case "chrome":
                        setChromeOptions(runHeadless);
                        break;

                    case "firefox":
                        setFireFoxOptions(runHeadless);
                        break;

                    case "edge":
                        setEdgeOptions(runHeadless);
                        break;

                    case "safari":
                        capabilities.setBrowserName(browserName);
                        break;
                    default:
                        throw new IllegalArgumentException("Browser not found. Please use a valid browser name.");
                }
                LogUtils.logInfo("Opened " + browserName + " browser");
                return initializeRemoteDriver(remoteUrl, capabilities);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Invalid Remote WebDriver URL: " + remoteUrl, e);

        }

    }

    private void setChromeOptions(boolean runHeadless) {
        ChromeOptions options = new ChromeOptions();
        if (runHeadless) {
            options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
            LogUtils.logInfo("Setting capabilities for chrome headless");
        }
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        options.addArguments("start-maximized");
        capabilities.merge(options);
    }

    private void setFireFoxOptions(boolean runHeadless) {
        FirefoxOptions options = new FirefoxOptions();
        if (runHeadless) {
            options.addArguments("--headless");
            LogUtils.logInfo("Setting capabilities for firefox headless");

        }
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "firefox");
        options.addArguments("--kiosk");
        capabilities.merge(options);
    }

    private void setEdgeOptions(boolean runHeadless) {
        EdgeOptions options = new EdgeOptions();
        if (runHeadless) {
            options.addArguments("--headless");
            LogUtils.logInfo("Setting capabilities for edge headless");

        }
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "MicrosoftEdge");
        options.addArguments("--start-maximized");
        capabilities.merge(options);

    }

    private WebDriver initializeRemoteDriver(String remoteUrl, DesiredCapabilities capabilities) {
        try {
            if (!remoteUrl.isEmpty()) {
                return new RemoteWebDriver(new URL("http://" + remoteUrl + ":4444/wd/hub"), capabilities);
            } else {
                LogUtils.logFail("Remote URL is empty; please provide a valid remote WebDriver URL.");
                throw new IllegalArgumentException("Remote URL is empty; please provide a valid remote WebDriver URL.");
            }
        } catch (MalformedURLException e) {
            LogUtils.logException(e);
            throw new RuntimeException("Invalid Remote WebDriver URL: " + remoteUrl, e);
        }
    }

    private WebDriver initializeLambdaTestDriver(String platformName, String browserName, String browserVersion) throws MalformedURLException {
        LogUtils.logInfo("Setting LambdaTest Capabilities");
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(CapabilityType.BROWSER_NAME, browserName);
        capabilities.setCapability(CapabilityType.BROWSER_VERSION, browserVersion);
        capabilities.setCapability("LT:Options", PropertyUtility.loadLambdaTestConfig());
        LogUtils.logInfo("Capability for Platform name : " + platformName + " and browser name " + browserName + " and browser version " + browserVersion);
        return new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), capabilities);
    }

    private WebDriver initializeBrowserStackDriver() throws MalformedURLException {
        LogUtils.logInfo("Browser Stack Initialization done");

        return new RemoteWebDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"), capabilities);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        WebDriver driver = getDriver();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
            LogUtils.logInfo("Closed Browser");
        }
    }

}
