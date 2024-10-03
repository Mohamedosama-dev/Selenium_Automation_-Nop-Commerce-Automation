package com.nopcommerce.testCase;

import com.aventstack.extentreports.Status;
import com.nopcommerce.base.BaseTest;
import com.nopcommerce.pages.P02_Login;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.nopcommerce.utilities.PropertyFileReader.getProperty;

public class T02_Login extends BaseTest {
    P02_Login loginPage = new P02_Login();
    SoftAssert softAssert = new SoftAssert();

    @Test(priority = 2)
    public void loginWithValidData() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "Login with Valid Data");
        test.log(Status.INFO, "starting");
        test.assignCategory("Login");

        loginPage.clickOnLogin();
        loginPage.enterEmail(getProperty("email"));
        loginPage.enterPassword(getProperty("password"));
        loginPage.clickOnLoginButton();
        softAssert.assertEquals(loginPage.verifyMyaccount(), getProperty("myAccountText"));
        softAssert.assertEquals(loginPage.verifyLogOutText(), getProperty("logOutText"));
    }

    @Test(priority = 1)
    public void loginWithInvalidData () {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "Login With Invalid Data");
        test.log(Status.INFO, "starting");
        test.assignCategory("Login");

        loginPage.clickOnLogin();
        loginPage.enterEmail(getProperty("wrongEmail"));
        loginPage.enterPassword("wrongPass");
        loginPage.clickOnLoginButton();
        softAssert.assertTrue(loginPage.errorMessageText().contains(getProperty("errorMsg")));
        softAssert.assertTrue(loginPage.errorMessageColor().contains(getProperty("errorMsgColor")));
        softAssert.assertAll();

    }

}
