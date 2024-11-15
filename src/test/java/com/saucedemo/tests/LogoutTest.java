package com.saucedemo.tests;

import com.saucedemo.base.testBase;
import org.json.simple.parser.ParseException;
import org.testng.annotations.*;

import java.io.IOException;

public class LogoutTest extends testBase {


    @BeforeClass
    public void setUp() throws IOException, ParseException {
        getData.dataReader("1");
        loginPage.loginScenarios(getData.getEmails().get(0), getData.getPasswords().get(0));
    }

    @Test
    public void Logout() {
        // Perform the logout action
        logoutPage.clickLogout();
        // Verify the user is redirected to the login page
        String expectedTitle = "Swag Labs";
        String actualTitle = driver.getTitle();
        softAssert.assertEquals(actualTitle, expectedTitle, "Logout failed");
    }

}
