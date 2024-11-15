package com.saucedemo.base;

import com.saucedemo.pages.*;
import com.saucedemo.utils.ConfigReader;
import com.saucedemo.utils.JsonReader;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class testBase {

     public WebDriver driver;
     public SoftAssert softAssert;
     public ConfigReader configReader;
     public JsonReader getData;
     public LoginPage loginPage;
     public ProductPage productPage ;
     public LogoutPage logoutPage ;
     public CheckoutPage checkoutPage;
     public AddToCartPage addToCartPage ;
     public WebDriverWait wait;

    @BeforeClass
    public void setup() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        configReader = new ConfigReader();
        getData = new JsonReader();
        softAssert = new SoftAssert();
        driver.get(configReader.getUrl("url"));
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        addToCartPage = new AddToCartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        logoutPage = new LogoutPage(driver);
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDownSuite()
    {
        driver.quit();
    }


    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
