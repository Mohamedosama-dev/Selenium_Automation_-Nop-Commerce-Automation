package com.nopcommerce.config;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class BaseConfig {
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;
    public static WebDriver driver;
    public void initializeReport(){
        htmlReporter = new
                ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/extentReport.html")
        ;
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("report");
        htmlReporter.config().setTheme(Theme.DARK);
        extent =new ExtentReports();
        extent.attachReporter(htmlReporter);
    }
    public static String CaptureScreenshot(WebDriver driver) throws IOException
    {
        String FileSeparator = System.getProperty("file.separator");
        String Extent_report_path = "."+FileSeparator+"Reports";
        String ScreenshotPath = Extent_report_path+FileSeparator+"screenshots";
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String screenshotName = "screenshot"+Math.random()+".png";
        String screenshotpath = ScreenshotPath+FileSeparator+screenshotName;
        FileUtils.copyFile(src,new File(screenshotpath));
        return "."+FileSeparator+"screenshots"+FileSeparator+screenshotName;
    }

}
