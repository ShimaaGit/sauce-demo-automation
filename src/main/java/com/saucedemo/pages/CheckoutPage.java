package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;

    By cartIcon = By.className("shopping_cart_link");
    By checkoutButton = By.id("checkout");
    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By postalCodeField = By.id("postal-code");
    By continueButton = By.id("continue");
    By finishButton = By.id("finish");
    By errorMessage = By.cssSelector("h3[data-test='error']");
    By successMessage = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToCheckout() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(cartIcon).click();
        driver.findElement(checkoutButton).click();
    }

    public void enterCheckoutDetails(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameField).clear();
        driver.findElement(firstNameField).sendKeys(firstName);

        driver.findElement(lastNameField).clear();
        driver.findElement(lastNameField).sendKeys(lastName);

        driver.findElement(postalCodeField).clear();
        driver.findElement(postalCodeField).sendKeys(postalCode);

        driver.findElement(continueButton).click();
    }

    public void finishCheckout() {

        driver.findElement(finishButton).click();
    }

    public String getErrorMessage() {

        return driver.findElement(errorMessage).getText();
    }

    public String getSuccessMessage() {

        return driver.findElement(successMessage).getText();
    }
}
