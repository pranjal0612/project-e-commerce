package com.ecommerce.test.tests;

import com.ecommerce.test.pages.HomePage;
import com.ecommerce.test.pages.ProductPage;
import com.ecommerce.test.pages.SearchResultsPage;
import com.ecommerce.test.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class ProductPageValidationTest extends BaseTest {

    @Test
    public void testProductPageElements() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();

        List<Map<String, String>> searchData = ExcelUtility.getTestData("src/test/resources/testdata.xlsx", "SearchData");
        String productToSearch = "";
        for (Map<String, String> data : searchData) {
            if (data.get("Type").equals("Valid")) {
                productToSearch = data.get("Product");
                break;
            }
        }

        SearchResultsPage searchResultsPage = homePage.searchForProduct(productToSearch);
        ProductPage productPage = searchResultsPage.clickFirstProduct();

        Assert.assertTrue(productPage.isAddToCartButtonPresent(), "'Add to Cart' button is not present on the product page.");
        Assert.assertTrue(productPage.isProductDetailsSectionPresent(), "Product details section is not present on the product page.");
        Assert.assertTrue(productPage.isImageGalleryPresent(), "Image gallery is not present on the product page.");
    }
}

