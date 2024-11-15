package com.saucedemo.pages;

import org.openqa.selenium.*;

public class LoginPage {

    WebDriver driver;

    By emailField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");
    By errorMessageinvalid = By.cssSelector("h3[data-test='error']");
    By errorMessagelockedout= By.xpath("//h3[@data-test='error']");


    public LoginPage (WebDriver driver) { this.driver = driver;}

    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String errorMessageElement() {
        return driver.findElement(errorMessageinvalid).getText();
    }

    public String errorMessagelockedout() {
        return driver.findElement(errorMessagelockedout).getText();
    }

    public void loginScenarios(String email, String password) {
        this.setEmailField(email);
        this.setPasswordField(password);
        this.clickLoginButton();
    }

}
