package com.nopcommerce.testCase;

import com.aventstack.extentreports.Status;
import com.nopcommerce.base.BaseTest;
import com.nopcommerce.pages.P03_Search;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import static com.nopcommerce.utilities.PropertyFileReader.getProperty;

public class T03_Search extends BaseTest {
    P03_Search searchPage = new P03_Search();
    SoftAssert softAssert = new SoftAssert();

    @Test(priority = 2)
    public void SearchWithValidData() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "search with valid data");
        test.log(Status.INFO, "starting");
        test.assignCategory("Search");


        searchPage.SearchWithData(getProperty("searchWord1"));
        searchPage.clickOnSearchButton();
        Assert.assertTrue(searchPage.verifySearchResult(getProperty("searchWord1")));
        searchPage.SearchWithData(getProperty("searchWord2"));
        searchPage.clickOnSearchButton();
        Assert.assertTrue(searchPage.verifySearchResult(getProperty("searchWord2")));
        Assert.assertFalse(searchPage.verifySearchResult(getProperty("searchWord1")));
    }
    @Test(priority = 1)
    public void ViewSuggestionFromSearchWithValidData(){
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, ": View Suggestion from Search With Valid data");
        test.log(Status.INFO, "starting");
        test.assignCategory("Search");

        searchPage.SearchWithData(getProperty("searchWord1"));
        softAssert.assertTrue(searchPage.verifySuggestions(getProperty("searchWord1")));
    }
}
