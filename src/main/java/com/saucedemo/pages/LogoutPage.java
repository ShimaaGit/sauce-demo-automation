package com.saucedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage {
     WebDriver driver;
     WebDriverWait wait;
    // Locators
     By menuButton = By.className("bm-burger-button"); // Menu button locator
     By logoutButton =By.xpath("//*[@data-test=\"logout-sidebar-link\"]");// Logout button in sidebar

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Clicks the logout button
    public void clickLogout() {

        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(menuButton));
        menu.click();

        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();

    }

}
