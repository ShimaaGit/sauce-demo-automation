package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;

    // Locators
     By productList = By.className("inventory_item");
     By productNames = By.className("inventory_item_name");
     By productPrices = By.className("inventory_item_price");
     By addToCartButtons = By.className("btn_inventory");
     By sortDropdown = By.className("product_sort_container");

    // Constructor
    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Wait for products to load
    public void waitForProducts() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productList));
    }

    // Get product names
    public List<WebElement> getProductNames() {
        return driver.findElements(productNames);
    }

    // Get product prices
    public List<WebElement> getProductPrices() {
        return driver.findElements(productPrices);
    }

    // Select sorting option
    public void selectSortOption(String option) {
        WebElement dropdown = driver.findElement(sortDropdown);
        dropdown.click();
        driver.findElement(By.xpath("//option[text()='" + option + "']")).click();
    }

    // Check if Add to Cart button is present for each product
    public boolean CartButton() {
        return driver.findElements(addToCartButtons).size() == getProductNames().size();
    }

    // Check if products are displayed
    public boolean ProductsDisplayed() {
        return !getProductNames().isEmpty();
    }

    // Helper methods
    public List<String> ElementsNames(List<WebElement> elements) {
        return elements.stream().map(WebElement::getText).toList();
    }

    public boolean SortAscending(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) > 0) return false;
        }
        return true;
    }

    public boolean SortDescending(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).compareTo(list.get(i + 1)) < 0) return false;
        }
        return true;
    }

}

