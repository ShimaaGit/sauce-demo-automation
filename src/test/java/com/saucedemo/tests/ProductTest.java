package com.saucedemo.tests;

import com.saucedemo.base.testBase;
import org.json.simple.parser.ParseException;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.List;

public class ProductTest extends testBase {


    @BeforeClass
    public void setUp() throws IOException, ParseException {
        getData.dataReader("1");
        loginPage.loginScenarios(getData.getEmails().get(0), getData.getPasswords().get(0));
    }

    @Test
    public void allProductsDisplayed() {
        softAssert.assertTrue(productPage.ProductsDisplayed(), "Products are not displayed.");
    }

    @Test
    public void productNamesAndPrices() {
        List<String> names = productPage.ElementsNames(productPage.getProductNames());
        List<String> prices = productPage.ElementsNames(productPage.getProductPrices());

        softAssert.assertFalse(names.isEmpty(), "Product names are empty.");
        softAssert.assertFalse(prices.isEmpty(), "Product prices are empty.");
    }

    @Test
    public void addToCartButtonDisplay() {
        softAssert.assertTrue(productPage.CartButton(), "Not all products have the Add to Cart button.");
    }

    @Test
    public void sortNamesAtoZ() {
        productPage.selectSortOption("Name (A to Z)");
        boolean Ascending = productPage.SortAscending(productPage.ElementsNames(productPage.getProductNames()));
        softAssert.assertTrue( Ascending , "Products are not sorted by name A-Z.");
    }

    @Test
    public void sortNamesZtoA() {
        productPage.selectSortOption("Name (Z to A)");
        boolean Descending = productPage.SortDescending(productPage.ElementsNames(productPage.getProductNames()));
        softAssert.assertTrue( Descending, "Products are not sorted by name Z-A.");
    }

    @Test
    public void sortPriceLowToHigh() {
        productPage.selectSortOption("Price (low to high)");
        boolean SortedAecs = productPage.SortAscending(productPage.ElementsNames(productPage.getProductPrices()));
        softAssert.assertFalse( SortedAecs , "Products are not sorted by price low to high.");
    }

    @Test
    public void sortPriceHighToLow() {
        productPage.selectSortOption("Price (high to low)");
        boolean SortedDecs = productPage.SortDescending(productPage.ElementsNames(productPage.getProductPrices()));
        softAssert.assertFalse(SortedDecs, "Products are not sorted by price high to low.");
    }


}
