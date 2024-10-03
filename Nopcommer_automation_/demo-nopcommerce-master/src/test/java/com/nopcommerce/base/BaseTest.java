package com.nopcommerce.base;

import com.nopcommerce.config.BaseConfig;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

import static com.nopcommerce.utilities.PropertyFileReader.getProperty;
public class BaseTest extends BaseConfig {
    @BeforeTest
    public void startReport() {
        initializeReport();
    }

    @BeforeMethod
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.navigate().to(getProperty("application_url"));
        Assert.assertEquals(driver.getCurrentUrl(), getProperty("application_url"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @AfterTest()
    public void endReport() {
        extent.flush();
    }
}