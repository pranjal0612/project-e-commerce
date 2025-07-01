package com.ecommerce.test.tests;

import com.ecommerce.test.pages.HomePage;
import com.ecommerce.test.pages.SearchResultsPage;
import com.ecommerce.test.utilities.CsvUtility;
import com.ecommerce.test.utilities.ExcelUtility;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

@Slf4j
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

        CsvUtility.writeToCsv("reports/product_details.csv", productDetails);
        log.info("Product details saved to reports/product_details.csv");
    }
}

