package Utils.LogUtils;

import Utils.UIUtils.UtilityMethods;
import com.epam.reportportal.listeners.LogLevel;
import com.epam.reportportal.message.ReportPortalMessage;
import com.epam.reportportal.service.ReportPortal;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.openqa.selenium.NoSuchElementException;

import org.testng.ITestContext;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;


import static Utils.UIUtils.UtilityMethods.captureScreenshotAsBase64;

public class CustomReportPortalListener extends ReportPortalTestNGListener {

    @Override
    public void onTestStart(ITestResult result) {
        super.onTestStart(result);
        logToReportPortal("Starting test: " + result.getName(), LogLevel.INFO.name());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        super.onTestSuccess(result);
        logToReportPortal("Test passed: " + result.getName(), LogLevel.INFO.name());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logToReportPortal("Test failed: " + result.getName(), LogLevel.ERROR.name());
        // Capture screenshot if there is a NoSuchElementException
        Throwable exception = result.getThrowable();
        if (exception instanceof NoSuchElementException) {
            String base64Screenshot = captureScreenshotAsBase64();
            logScreenshotToReportPortal(base64Screenshot, "Test Failure Screenshot");
        }
        //logToReportPortal("Exception: " + result.getThrowable().getMessage(), LogLevel.ERROR.name());
        super.onTestFailure(result);

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        super.onTestSkipped(result);
        logToReportPortal("Test skipped: " + result.getName(), LogLevel.WARN.name());
    }

    @Override
    public void onStart(ITestContext context) {
        super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        super.onFinish(context);
    }

    private void logToReportPortal(String message, String level) {
        ReportPortal.emitLog(message, level, Calendar.getInstance().getTime());
    }


    private void logScreenshotToReportPortal(String base64Screenshot, String message) {
        // Save the Base64 string to a file
        File screenshotFile = UtilityMethods.saveBase64ToFile(base64Screenshot, "screenshot.png");
        // Log the screenshot to ReportPortal
        try {
            ReportPortalMessage rpMessage = new ReportPortalMessage(screenshotFile, message);
            ReportPortal.emitLog(rpMessage, LogLevel.ERROR.name(), Calendar.getInstance().getTime());
        } catch (IOException e) {
            ReportPortal.emitLog("Failed to attach screenshot: " + e.getMessage(), LogLevel.ERROR.name(), Calendar.getInstance().getTime());
        }
    }

}
