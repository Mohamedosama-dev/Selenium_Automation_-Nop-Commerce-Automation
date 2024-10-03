package com.nopcommerce.testCase;

import com.aventstack.extentreports.Status;
import com.nopcommerce.base.BaseTest;
import com.nopcommerce.pages.P04_Wishlist;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.nopcommerce.utilities.PropertyFileReader.getProperty;

public class T04_Wishlist extends BaseTest {
    P04_Wishlist wishlist = new P04_Wishlist();
    @Test
    public void addProductToWishList() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "add prduct to wish list");
        test.log(Status.INFO, "starting");
        test.assignCategory("WishList");

        wishlist.scrollDownToProduct();
        wishlist.clickOnProduct();
        wishlist.clickOnAddToWishList();
        Assert.assertTrue(wishlist.verifyMessage(getProperty("notificationMessage")));
        Assert.assertTrue(wishlist.verifyBackgroundColor().contains(getProperty("wishlistMsgBackgroundColor")));
        wishlist.clickOnXButton();
        Assert.assertEquals(wishlist.verifyWishListIncrease(),"(1)");
        wishlist.clickOnWishList();
        Assert.assertTrue(wishlist.verifyProductInWishlist(getProperty("expectedProduct")));
    }

}
