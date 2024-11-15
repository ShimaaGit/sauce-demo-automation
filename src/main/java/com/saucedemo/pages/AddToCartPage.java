package com.saucedemo.pages;

import org.openqa.selenium.*;

import java.util.List;

public class AddToCartPage {
     WebDriver driver;

    // Locators
     By addToCartButtons = By.cssSelector(".inventory_item button");
     By cartBadge = By.cssSelector(".shopping_cart_badge");
     By cartItems = By.cssSelector(".cart_item");
     By removeButtons = By.cssSelector(".cart_item button");
     By cartLink = By.cssSelector(".shopping_cart_link");

    // Constructor
    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void addSingleProductToCart() {
        driver.findElements(addToCartButtons).get(0).click(); // Add the first product
    }

    public void addMultipleProductsToCart(int count) {
        List<WebElement> buttons = driver.findElements(addToCartButtons);
        for (int i = 0; i < count && i < buttons.size(); i++) {
            buttons.get(i).click();
        }
    }

    public int getCartItemCount() {
        WebElement badge = driver.findElement(cartBadge);
        return badge.isDisplayed() ? Integer.parseInt(badge.getText()) : 0;
    }

    public void openCart() {
        driver.findElement(cartLink).click();
    }

    public int getCartItemsCount() {
        return driver.findElements(cartItems).size();
    }

    public void removeSingleProduct() {
        List<WebElement> removeBtns = driver.findElements(removeButtons);
        if (!removeBtns.isEmpty()) {
            removeBtns.get(0).click(); // Remove the first product
        }
    }

    public void clearAllItemsFromCart() {
        List<WebElement> removeBtns = driver.findElements(removeButtons);
        for (WebElement btn : removeBtns) {
            btn.click();
        }
    }
}
