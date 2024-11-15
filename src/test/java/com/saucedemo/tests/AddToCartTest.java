package com.saucedemo.tests;

import com.saucedemo.base.testBase;
import org.json.simple.parser.ParseException;
import org.testng.annotations.*;

import java.io.IOException;

public class AddToCartTest extends testBase {

    @BeforeClass
    public void setUp() throws IOException, ParseException {
        getData.dataReader("1");
        loginPage.loginScenarios(getData.getEmails().get(0), getData.getPasswords().get(0));
    }

    @Test(priority = 1)
    public void addSingleProduct() {
        addToCartPage.addSingleProductToCart();
        softAssert.assertEquals(addToCartPage.getCartItemCount(), 1, "Single product not added to cart!");
    }

    @Test(priority = 2)
    public void addMultipleProducts() {
        addToCartPage.addMultipleProductsToCart(3);
        softAssert.assertEquals(addToCartPage.getCartItemCount(), 4, "Not all products were added to the cart!");
    }

    @Test(priority = 3)
    public void removeSingleProduct() {
        addToCartPage.openCart();
        int initialCount = addToCartPage.getCartItemsCount();
        addToCartPage.removeSingleProduct();
        softAssert.assertEquals(addToCartPage.getCartItemsCount(), initialCount - 1, "Product not removed from the cart!");
    }

    @Test(priority = 4)
    public void clearAllItems() {
        addToCartPage.clearAllItemsFromCart();
        softAssert.assertEquals(addToCartPage.getCartItemsCount(), 0, "Cart is not empty after clearing all items!");
    }


}
