package com.nopcommerce.pages;

import com.nopcommerce.config.BaseConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class P04_Wishlist extends BaseConfig {
    By productElement = By.xpath("//a[@href=\"/htc-one-m8-android-l-50-lollipop\"]");
    By addToWishListButtonLocator = By.xpath("//*[@id=\"add-to-wishlist-button-18\"]");
    By notificationMsg = By.xpath("//*[@id=\"bar-notification\"]/div/p");
    By notificationBar = By.xpath("//*[@id=\"bar-notification\"]/div");
    By xButton = By.xpath("//*[@id=\"bar-notification\"]/div/span");

    By wishListQuantity = By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[3]/a/span[2]");
    By wishList = By.xpath("//a[@href=\"/wishlist\"]");
    By wishListProduct = By.xpath("//td[@class=\"product\"]");
    public void scrollDownToProduct() {
        WebElement product = driver.findElement(productElement);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView();", product);
    }
    public void clickOnProduct(){
        driver.findElement(productElement).click();
    }
    public void clickOnAddToWishList(){
        driver.findElement(addToWishListButtonLocator).click();
    }

    public Boolean verifyMessage(String word) {
        String message = driver.findElement(notificationMsg).getText();
        if (message.contains(word)){
            return true;
        }
        return false;
    }
    public String verifyBackgroundColor(){
        String color = driver.findElement(notificationBar).getCssValue("background-color");
        return Color.fromString(color).asHex();
    }
    public void clickOnXButton(){
        driver.findElement(xButton).click();
    }
    public String verifyWishListIncrease(){
        return driver.findElement(wishListQuantity).getText();
    }
    public void clickOnWishList(){
        driver.findElement(wishList).click();
    }
    public boolean verifyProductInWishlist(String expectedProductName) {
        String actualProductName = driver.findElement(wishListProduct).getText();
        return actualProductName.equals(expectedProductName);
    }

}
