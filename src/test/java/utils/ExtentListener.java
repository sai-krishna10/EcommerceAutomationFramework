package utils;

import base.BaseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class ExtentListener implements ITestListener {

    ExtentReports extent = ExtentManager.getExtentReport();
    ExtentTest test;

    WebDriver driver;

    public void onTestStart(ITestResult result) {
        Object testClass = result.getInstance();
        driver = ((BaseTest)testClass).driver;
        try {
            test = extent.createTest(result.getMethod().getMethodName()).addScreenCaptureFromPath(CommonUtils.getScreenshot(driver,result.getMethod().getMethodName()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onTestSuccess(ITestResult result) {
        Object testClass = result.getInstance();
        driver = ((BaseTest)testClass).driver;
        try {
            test.pass("Test Passed").addScreenCaptureFromPath(CommonUtils.getScreenshot(driver,result.getMethod().getMethodName()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        driver = ((BaseTest)testClass).driver;
        try {
            test.fail(result.getThrowable()).addScreenCaptureFromPath(CommonUtils.getScreenshot(driver,result.getMethod().getMethodName()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onFinish(ITestContext context) {
        extent.flush();
    }
}