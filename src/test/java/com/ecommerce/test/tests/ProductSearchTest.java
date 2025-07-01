package com.ecommerce.test.tests;

import com.ecommerce.test.pages.HomePage;
import com.ecommerce.test.pages.SearchResultsPage;
import com.ecommerce.test.utilities.CsvUtility;
import com.ecommerce.test.utilities.ExcelUtility;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;

public class ProductSearchTest extends BaseTest {

    @Test
    public void testProductSearchAndExtractDetails() {
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
        List<Map<String, String>> productDetails = searchResultsPage.getProductDetails();

        System.out.println("\n--- Extracted Product Details ---");
        for (Map<String, String> product : productDetails) {
            System.out.println("Product Name: " + product.get("Product Name"));
            System.out.println("Price: " + product.get("Price"));
            System.out.println("Ratings: " + product.get("Ratings"));
            System.out.println("URL: " + product.get("URL"));
            System.out.println("-----------------------------------");
        }

        CsvUtility.writeToCsv("reports/product_details.csv", productDetails);
        System.out.println("Product details saved to reports/product_details.csv");
    }
}

