package com.nopcommerce.listener;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.nopcommerce.config.BaseConfig;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

import static com.nopcommerce.config.BaseConfig.CaptureScreenshot;

public class MyListener implements ITestListener{
    public void onTestStart(ITestResult iTestResult) {
    }
    public void onTestSuccess(ITestResult iTestResult) {
        BaseConfig.test.log(Status.PASS, MarkupHelper.createLabel(iTestResult.getName().
                toUpperCase()+" PASS", ExtentColor.GREEN));
    }
    public void onTestFailure(ITestResult iTestResult) {
        BaseConfig.test.log(Status.FAIL,iTestResult.getThrowable().getMessage());
        BaseConfig.test.log(Status.FAIL,MarkupHelper.createLabel(iTestResult.getName().
                toUpperCase()+" FAIL",ExtentColor.RED));
        try {
            BaseConfig.test.addScreenCaptureFromPath(CaptureScreenshot(BaseConfig.driver));
            BaseConfig.test.addScreencastFromPath(CaptureScreenshot(BaseConfig.driver));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onTestSkipped(ITestResult iTestResult) {
        BaseConfig.test.log(Status.SKIP,MarkupHelper.createLabel(iTestResult.getName().
                toUpperCase()+" SKIPPED",ExtentColor.PURPLE));
    }
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult)
    {
    }
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }
    public void onStart(ITestContext iTestContext) {
    }
    public void onFinish(ITestContext iTestCon){

    }
}
