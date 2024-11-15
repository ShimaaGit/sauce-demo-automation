package com.saucedemo.tests;

import com.saucedemo.base.testBase;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.*;
import org.testng.annotations.*;

import java.io.IOException;

public class LoginTest extends testBase {

    @Test
    public void validLogin() throws IOException, ParseException {

       getData.dataReader("1");
       loginPage.loginScenarios(getData.getEmails().get(0), getData.getPasswords().get(0));
       String expectedTitle = "Swag Labs";
       String actualTitle = driver.getTitle();
       softAssert.assertEquals(actualTitle, expectedTitle, "The title does`t match");
    }


    @Test
    public void invalidPassword() throws IOException, ParseException {
        getData.dataReader("2");
        loginPage.loginScenarios(getData.getEmails().get(0), getData.getPasswords().get(0));
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = loginPage.errorMessageElement();
        softAssert.assertEquals(actualErrorMessage, expectedErrorMessage, "invalid password.");
    }

    @Test
    public void invalidUsername() throws IOException, ParseException {
        getData.dataReader("3");
        loginPage.loginScenarios(getData.getEmails().get(0), getData.getPasswords().get(0));
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        String actualErrorMessage = loginPage.errorMessageElement();
        softAssert.assertEquals(actualErrorMessage, expectedErrorMessage, "invalid Username.");
    }

    @Test
    public void problem_user () throws IOException, ParseException {
        getData.dataReader("4");
        loginPage.loginScenarios(getData.getEmails().get(0), getData.getPasswords().get(0));
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        softAssert.assertEquals(actualTitle, expectedTitle, "The title does`t match");

    }

    @Test
    public void performance_glitch_user  () throws IOException, ParseException {
        getData.dataReader("5");
        loginPage.loginScenarios(getData.getEmails().get(0), getData.getPasswords().get(0));
        softAssert.assertTrue(isElementPresent(By.id("inventory_container")), "Performance glitch user should be logged in successfully.");

    }

    @Test
    public void visual_user  () throws IOException, ParseException {
        getData.dataReader("6");
        loginPage.loginScenarios(getData.getEmails().get(0), getData.getPasswords().get(0));
        String expectedTitle = "Products";
        String actualTitle = driver.getTitle();
        softAssert.assertEquals(actualTitle, expectedTitle, "The title does`t match");
    }

    @Test
    public void locked_out_user  () throws IOException, ParseException {
        getData.dataReader("7");
        loginPage.loginScenarios(getData.getEmails().get(0), getData.getPasswords().get(0));
        String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
        String actualErrorMessage = loginPage.errorMessagelockedout();
        softAssert.assertEquals(actualErrorMessage, expectedErrorMessage, "locked out user");

    }
}
