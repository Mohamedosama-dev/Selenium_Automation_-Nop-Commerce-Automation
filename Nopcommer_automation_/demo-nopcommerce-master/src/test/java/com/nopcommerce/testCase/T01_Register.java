package com.nopcommerce.testCase;

import com.aventstack.extentreports.Status;
import com.nopcommerce.base.BaseTest;
import com.nopcommerce.pages.P01_Register;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.nopcommerce.utilities.PropertyFileReader.getProperty;

public class T01_Register extends BaseTest {
    P01_Register registerPage = new P01_Register();
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void RegisterWithValidData() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "Register with valid data");
        test.log(Status.INFO, "starting");
        test.assignCategory("Register");

        Assert.assertEquals(driver.getCurrentUrl(), getProperty("application_url"));
        registerPage.clickOnRegisterButton();
        registerPage.chooseGender();
        registerPage.enterFirstName(getProperty("firstName"));
        registerPage.enterLastName(getProperty("lastName"));
        registerPage.SelectBirthDate(getProperty("birthDay"), getProperty("birthMonth"), getProperty("birthYear"));
        registerPage.enterValidEmail(getProperty("email"));
        registerPage.enterValidPass(getProperty("password"));
        registerPage.reEnterValidPass(getProperty("rePassword"));
        registerPage.clickOnSubmitRegisterButton();
        softAssert.assertTrue(registerPage.successMessage().contains(getProperty("successMessage")));
        softAssert.assertTrue(registerPage.successMessageColor().contains(getProperty("successMessageColor")));
        softAssert.assertAll();

    }
}
