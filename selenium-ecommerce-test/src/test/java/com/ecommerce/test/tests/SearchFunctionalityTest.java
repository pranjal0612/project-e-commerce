package com.ecommerce.test.tests;

import com.ecommerce.test.pages.HomePage;
import com.ecommerce.test.pages.SearchResultsPage;
import com.ecommerce.test.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class SearchFunctionalityTest extends BaseTest {

    @DataProvider(name = "searchData")
    public Object[][] searchDataProvider() {
        List<Map<String, String>> testData = ExcelUtility.getTestData("src/test/resources/testdata.xlsx", "SearchData");
        Object[][] data = new Object[testData.size()][2];
        for (int i = 0; i < testData.size(); i++) {
            data[i][0] = testData.get(i).get("Product");
            data[i][1] = testData.get(i).get("Type");
        }
        return data;
    }

    @Test(dataProvider = "searchData")
    public void testSearchFunctionality(String product, String type) {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();
        SearchResultsPage searchResultsPage = homePage.searchForProduct(product);

        if (type.equals("Valid")) {
            Assert.assertTrue(searchResultsPage.getProductDetails().size() > 0, "Search results are not displayed for valid product search.");
        } else if (type.equals("Invalid")) {
            // This assertion might need to be adjusted based on the actual "no results" message/element on the website
            // For now, we\'ll just check that no products are returned.
            Assert.assertTrue(searchResultsPage.getProductDetails().size() == 0, "Search results are displayed for invalid product search.");
        }
    }
}

