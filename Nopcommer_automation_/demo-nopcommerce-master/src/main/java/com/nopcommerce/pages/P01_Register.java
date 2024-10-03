package com.nopcommerce.pages;

import com.nopcommerce.config.BaseConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;

public class P01_Register extends BaseConfig {

    By registerButton = By.xpath("//a[@class=\"ico-register\"]");
    By femaleGenderButton = By.xpath("//input[@value=\"F\"]");
    By firstNameField = By.xpath("//input[@data-val-required=\"First name is required.\"]");
    By lastNameField = By.xpath("//input[@data-val-required=\"Last name is required.\"]");
    By emailField = By.xpath("//input[@data-val-required=\"Email is required.\"]");
    By passwordField = By.xpath("//input[@id=\"Password\"]");
    By repassField = By.xpath("//input[@id=\"ConfirmPassword\"]");
    By registerSubmitButton = By.xpath("//button[@name=\"register-button\"]");
    By successMessageText = By.xpath("//div[@class=\"result\"]");
    public void clickOnRegisterButton() {
        driver.findElement(registerButton).click();
    }
    public void chooseGender (){
        driver.findElement(femaleGenderButton).click();
    }
    public void enterFirstName (String fName){
        driver.findElement(firstNameField).sendKeys(fName);
    }
    public void enterLastName (String lName){
        driver.findElement(lastNameField).sendKeys(lName);
    }

    public void SelectBirthDate (String day, String month, String year) {
        Select dropDownDay = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthDay\"]")));
        dropDownDay.selectByValue(day);
        Select dropDownMonth = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthMonth\"]")));
        dropDownMonth.selectByValue(month);
        Select dropDownYear = new Select(driver.findElement(By.xpath("//select[@name=\"DateOfBirthYear\"]")));
        dropDownYear.selectByValue(year);
    }
    public void enterValidEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }
    public void enterValidPass (String pass) {
        driver.findElement(passwordField).sendKeys(pass);
    }
    public void reEnterValidPass (String pass) {
        driver.findElement(repassField).sendKeys(pass);
    }
    public void clickOnSubmitRegisterButton () {
        driver.findElement(registerSubmitButton).click();
    }



    public String successMessage(){
        String successMsg = driver.findElement(successMessageText).getText();
        System.out.println(successMsg);
        return successMsg;
    }
    public String successMessageColor() {
        String color = driver.findElement(successMessageText).getCssValue("color");
        return Color.fromString(color).asHex();
    }




}
