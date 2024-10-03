package com.nopcommerce.testCase;

import com.aventstack.extentreports.Status;
import com.nopcommerce.base.BaseTest;
import com.nopcommerce.pages.P05_Cart;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.nopcommerce.utilities.PropertyFileReader.getProperty;

public class T05_Cart extends BaseTest {
    P05_Cart cart = new P05_Cart();
    @Test
    public void AddProductToCartAndThenCheckout() {
        String methodName = new Exception().getStackTrace()[0].getMethodName();
        test = extent.createTest(methodName, "add product to cart and then checkout");
        test.log(Status.INFO, "starting");
        test.assignCategory("Cart");

        cart.scrollDownToProduct();
        cart.clickOnAddToCart();
        cart.clickOnProductAndAddProductToCart();
        Assert.assertTrue(cart.verifyNotificationMsg().contains(getProperty("notificationMessage")));
        Assert.assertTrue(cart.verifyBackgroundColor().contains(getProperty("cartMsgBackgroundColor")));
        cart.clickOnXButton();
        Assert.assertEquals(cart.verifyWishListIncrease(), "(2)");
        cart.hoverOverShoppingCart();
        cart.clickOnGoToCartButton();
        cart.clickOnTermsAgreementMark();
        cart.clickOnCheckOutButton();
        cart.clickOnCheckOutAsGuestButton();
        cart.fillValidBillingAddress(getProperty("firstName"), getProperty("lastName"), getProperty("email"),
                getProperty("countryValue"), getProperty("city"), getProperty("address1"), getProperty("postalCode"),
                getProperty("phoneNumber"));
        cart.chooseShippingMethod();
        cart.choosePaymentMethod();
        cart.paymentConfirmationMethod(getProperty("cardHolderName"), getProperty("cardNumber"),
                getProperty("expiryMonth"), getProperty("expiryYear"), getProperty("cardCode"));
        cart.confirmOrderMethod();
        Assert.assertTrue(cart.confirmationMsg().contains(getProperty("orderConfirmationMsg")));
    }
}
