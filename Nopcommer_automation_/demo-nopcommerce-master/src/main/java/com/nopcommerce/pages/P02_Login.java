package com.nopcommerce.pages;

import com.nopcommerce.config.BaseConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;

import java.awt.*;

public class P02_Login extends BaseConfig {

    By login = By.xpath("//a[@class=\"ico-login\"]");
    By emailField = By.xpath("//input[@class=\"email\"]");
    By passwordField = By.xpath("//input[@class=\"password\"]");
    By loginButton = By.xpath("(//button[@type=\"submit\"])[2]");
    By myAccount = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a");
    By logOutText = By.xpath("//a[@href=\"/logout\"]");
    By errorMessage = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]");

    public void clickOnLogin () {
        driver.findElement(login).click();
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    public void enterPassword(String pass) {
        driver.findElement(passwordField).sendKeys(pass);
    }
    public void clickOnLoginButton () {
        driver.findElement(loginButton).click();
    }
    public String verifyMyaccount() {
        return driver.findElement(myAccount).getText();
    }
    public String verifyLogOutText () {
        return driver.findElement(logOutText).getText();
    }
    public String errorMessageText () {
        return driver.findElement(errorMessage).getText();
    }
    public String errorMessageColor() {
        String color = driver.findElement(errorMessage).getCssValue("color");
        return Color.fromString(color).asHex();

    }

}
