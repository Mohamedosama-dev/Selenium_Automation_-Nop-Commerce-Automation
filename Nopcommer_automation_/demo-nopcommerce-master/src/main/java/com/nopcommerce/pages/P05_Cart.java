package com.nopcommerce.pages;

import com.nopcommerce.config.BaseConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;

public class P05_Cart extends BaseConfig {
    By productElement = By.xpath("/html/body/div[6]/div[3]/div/div/div/div/div[4]/div[2]/div[2]/div/div[2]/h2/a");
    By addToCartButton = By.xpath("(//button[@type=\"button\"])[4]");
    By addToCartButtonFromProductPage = By.xpath("//button[@id=\"add-to-cart-button-4\"]");
    By notificationBar = By.xpath("//*[@id=\"bar-notification\"]/div");
    By notificationBarMsg = By.xpath("//*[@id=\"bar-notification\"]/div/p");
    By xButton = By.xpath("//*[@id=\"bar-notification\"]/div/span");
    By cartQuantity = By.xpath("//*[@id=\"topcartlink\"]/a/span[2]");
    By shoppingCartLocator = By.xpath("//*[@id=\"topcartlink\"]/a");
    By shoppingCartGoButton = By.xpath("//*[@id=\"flyout-cart\"]/div/div[4]/button");
    By termsOfService = By.xpath("//input[@id=\"termsofservice\"]");
    By checkOutButton = By.xpath("//button[@id=\"checkout\"]");
    By checkOutAsGuestButton = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]");
    By firstNameLocator = By.xpath("//input[@id=\"BillingNewAddress_FirstName\"]");
    By lastNameLocator = By.xpath("//input[@id=\"BillingNewAddress_LastName\"]");
    By emailLocator = By.xpath("//input[@type=\"email\"]");
    By countryDropDownMenu = By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]");
    By cityLocator = By.xpath("//input[@id=\"BillingNewAddress_City\"]");
    By address1Locator = By.xpath("//input[@id=\"BillingNewAddress_Address1\"]");
    By postalCodeLocator = By.xpath("//input[@id=\"BillingNewAddress_ZipPostalCode\"]");
    By phoneNumberLocator = By.xpath("//input[@id=\"BillingNewAddress_PhoneNumber\"]");
    By billingContinueButtonLocator = By.xpath("//*[@id=\"billing-buttons-container\"]/button[4]");
    By airShippingLocator = By.xpath("//*[@id=\"shippingoption_1\"]");
    By shippingContinueButtonLocator = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button");
    By creditCardChoiceLocator = By.xpath("//*[@id=\"paymentmethod_1\"]");
    By paymentContinueButtonLocator = By.xpath("//*[@id=\"payment-method-buttons-container\"]/button");
    By cardHolderName = By.xpath("//*[@id=\"CardholderName\"]");
    By cardNumber = By.xpath("//*[@id=\"CardNumber\"]");
    By expiryMonthDropMenu = By.xpath("//*[@id=\"ExpireMonth\"]");
    By getExpiryYearDropMenu = By.xpath("//*[@id=\"ExpireYear\"]");
    By cardCode = By.xpath("//*[@id=\"CardCode\"]");
    By paymentConfirmationButtonLocator = By.xpath("//*[@id=\"payment-info-buttons-container\"]/button");
    By confirmationButton = By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button");
    By orderConfirmationMsg = By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong");
    public void scrollDownToProduct() {
        WebElement product = driver.findElement(productElement);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();", product);
    }
    public void clickOnAddToCart(){
        driver.findElement(addToCartButton).click();
    }
    public void clickOnProductAndAddProductToCart() {
        driver.findElement(productElement).click();
        driver.findElement(addToCartButtonFromProductPage).click();
    }
    public String verifyNotificationMsg() {
        return driver.findElement(notificationBarMsg).getText();
    }
    public String verifyBackgroundColor(){
        String color = driver.findElement(notificationBar).getCssValue("background-color");
        return Color.fromString(color).asHex();
    }
    public void clickOnXButton() {
        driver.findElement(xButton).click();
    }
    public String verifyWishListIncrease(){
        return driver.findElement(cartQuantity).getText();
    }
    public void hoverOverShoppingCart(){
        WebElement shoppingCart = driver.findElement(shoppingCartLocator);
        Actions actions = new Actions(driver);
        actions.moveToElement(shoppingCart).perform();
    }
    public void clickOnGoToCartButton() {
        driver.findElement(shoppingCartGoButton).click();
    }
    public void clickOnTermsAgreementMark() {
        driver.findElement(termsOfService).click();
    }
    public void clickOnCheckOutButton() {
        driver.findElement(checkOutButton).click();
    }
    public void clickOnCheckOutAsGuestButton() {
        driver.findElement(checkOutAsGuestButton).click();
    }
    public void fillValidBillingAddress(String fName, String lName, String email, String country,
                                        String city, String address1, String postalCode, String phoneNumber){
        driver.findElement(firstNameLocator).sendKeys(fName);
        driver.findElement(lastNameLocator).sendKeys(lName);
        driver.findElement(emailLocator).sendKeys(email);
        WebElement dropDown = driver.findElement(countryDropDownMenu);
        Select select = new Select(dropDown);
        select.selectByValue(country);
        driver.findElement(cityLocator).sendKeys(city);
        driver.findElement(address1Locator).sendKeys(address1);
        driver.findElement(postalCodeLocator).sendKeys(postalCode);
        driver.findElement(phoneNumberLocator).sendKeys(phoneNumber);
        driver.findElement(billingContinueButtonLocator).click();
    }
    public void chooseShippingMethod(){
        driver.findElement(airShippingLocator).click();
        driver.findElement(shippingContinueButtonLocator).click();

    }
    public void choosePaymentMethod(){
        driver.findElement(creditCardChoiceLocator).click();
        driver.findElement(paymentContinueButtonLocator).click();

    }
    public void paymentConfirmationMethod(String name, String number, String month,
                                          String year, String code) {
        driver.findElement(cardHolderName).sendKeys(name);
        driver.findElement(cardNumber).sendKeys(number);
        WebElement expiryMonth = driver.findElement(expiryMonthDropMenu);
        Select monthSelect = new Select(expiryMonth);
        monthSelect.selectByValue(month);
        WebElement expiryYear = driver.findElement(getExpiryYearDropMenu);
        Select yearSelect = new Select(expiryYear);
        yearSelect.selectByValue(year);
        driver.findElement(cardCode).sendKeys(code);
        driver.findElement(paymentConfirmationButtonLocator).click();
    }
    public void confirmOrderMethod(){
        driver.findElement(confirmationButton).click();
    }
    public String confirmationMsg() {
        return driver.findElement(orderConfirmationMsg).getText();
    }



}
