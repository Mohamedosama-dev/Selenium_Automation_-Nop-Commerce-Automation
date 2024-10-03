package com.nopcommerce.pages;

import com.nopcommerce.config.BaseConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class P03_Search extends BaseConfig {

    By searchTextBox = By.xpath("//input[@class=\"search-box-text ui-autocomplete-input\"]");
    By searchButton = By.xpath("//button[@class=\"button-1 search-box-button\"]");
    By searchResultLocator = By.xpath("//div[@class=\"product-item\"]");

    By suggestWords = By.xpath("//li[@class=\"ui-menu-item\"]");
    public void SearchWithData(String data) {
        driver.findElement(searchTextBox).sendKeys(data);
    }

    public void clickOnSearchButton() {
        driver.findElement(searchButton).click();
    }

    public List<WebElement> getSearchResult() {
        return driver.findElements(searchResultLocator);
    }
    public Boolean verifySearchResult (String word) {
        List<WebElement> searchResults = getSearchResult();
        int size = driver.findElements(By.xpath("//div[@class=\"product-item\"]")).size();
        for (int i = 0; i < size; i++) {
            String text = searchResults.get(i).getText();
            if (!text.contains(word))
                return false;
        }
        return true;
    }
    public Boolean verifySuggestions (String word) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(suggestWords));
        List<WebElement> suggestionsElements = driver.findElements(suggestWords);
        int size = suggestionsElements.size();
        for (int i = 0; i < size; i++) {
            String text = suggestionsElements.get(i).getText();
            if (!text.contains(word))
                return false;
        }
        return true;

    }

}
