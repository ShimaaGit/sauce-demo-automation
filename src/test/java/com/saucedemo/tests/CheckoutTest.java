package com.saucedemo.tests;

import com.saucedemo.base.testBase;
import org.json.simple.parser.ParseException;
import org.testng.annotations.*;


import java.io.IOException;

public class CheckoutTest extends testBase {

    @BeforeClass
    public void setUp() throws IOException, ParseException {
        getData.dataReader("1");
        loginPage.loginScenarios(getData.getEmails().get(0), getData.getPasswords().get(0));
    }

    @Test
    public void CheckoutWithoutItems() {
        checkoutPage.navigateToCheckout();
        checkoutPage.enterCheckoutDetails("Shimaa", "Mostafa", "123456");
        checkoutPage.finishCheckout();
        softAssert.assertEquals(checkoutPage.getSuccessMessage(), "Thank you for your order!",
                "Success message after valid checkout is incorrect.");
    }

    @Test
    public void InvalidCheckoutInformation() {
        checkoutPage.navigateToCheckout();
        checkoutPage.enterCheckoutDetails("", "Mostafa", "123456"); // Missing first name
        softAssert.assertTrue(checkoutPage.getErrorMessage().contains("First Name is required"),
                "Error message for missing first name is incorrect.");
    }

    @Test
    public void ValidCheckoutInformation() {
        checkoutPage.navigateToCheckout();
        checkoutPage.enterCheckoutDetails("Shimaa", "Mostafa", "123456");
        checkoutPage.finishCheckout();
        softAssert.assertEquals(checkoutPage.getSuccessMessage(), "Thank you for your order!",
                "Success message after valid checkout is incorrect.");
    }

}
