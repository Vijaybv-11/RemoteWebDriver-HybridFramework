package com.Banking.Utils;

import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass implements FrameworkConstants {
	private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>(); // Thread-local storage for WebDriver
	public static WebDriverWait Wait;
	public static Logger logger;
	public WebDriver driver;

	public static WebDriver getDriver() {
		return driverThreadLocal.get();

	}

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void setup(@Optional("chrome") String browserName) {
		logger = LogManager.getLogger(this.getClass());
		logger.debug(
				"==================================================================================================*============================================================================================");
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			logger.info("Opened Chrome Browser");
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			logger.info("Opened FireFox Browser");
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			logger.info("Opened Edge Browser");
		} else {
			logger.info("Failed to Open Browser");
		}

		driver.manage().window().maximize();
		logger.info("Browser window Maximized");

		ReadConfig config = new ReadConfig();
		String URL = config.getValueProperty("url");
		driver.get(URL);
		logger.info("Navigated to Url " + URL);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driverThreadLocal.set(driver); // Store the WebDriver instance in the thread-local storage
		Wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	

	@AfterClass(alwaysRun = true)
	public void teardown() {
		WebDriver driver = getDriver();
		driver.quit();
		// if (driver != null) {
		driverThreadLocal.remove(); // Remove the WebDriver instance from thread-local storage
		logger.info("Closed Browser");
		logger.debug(
				"=========================================================================*============================================================");

	}
}
