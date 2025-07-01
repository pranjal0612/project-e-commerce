package com.ecommerce.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SearchResultsPage extends BasePage {

    private List<WebElement> productList;
    private WebElement nextPageButton;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        this.productList = driver.findElements(By.xpath("//div[contains(@class, 's-result-item')]//span[@data-component-type='s-product-image']"));
        this.nextPageButton = driver.findElement(By.xpath("//a[contains(@class, 's-pagination-next')]"));
    }

    public List<Map<String, String>> getProductDetails() {
        List<Map<String, String>> products = new ArrayList<>();
        boolean hasNextPage = true;

        while (hasNextPage) {
            for (WebElement product : productList) {
                try {
                    Map<String, String> productDetails = new HashMap<>();
                    // Product Name
                    WebElement productNameElement = product.findElement(By.xpath(".//span[contains(@class, 'a-text-normal')] | .//h2/a/span"));
                    productDetails.put("Product Name", productNameElement.getText());

                    // Price
                    WebElement priceElement = product.findElement(By.xpath(".//span[@data-a-size='xl']//span[@class='a-offscreen'] | .//span[@class='a-price']/span[@class='a-offscreen']"));
                    productDetails.put("Price", priceElement.getAttribute("textContent"));

                    // Ratings
                    try {
                        WebElement ratingsElement = product.findElement(By.xpath(".//span[@class='a-icon-alt']"));
                        productDetails.put("Ratings", ratingsElement.getAttribute("textContent"));
                    } catch (org.openqa.selenium.NoSuchElementException e) {
                        productDetails.put("Ratings", "N/A");
                    }

                    // URL
                    WebElement urlElement = product.findElement(By.xpath(".//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal'] | .//h2/a"));
                    productDetails.put("URL", urlElement.getAttribute("href"));

                    products.add(productDetails);
                } catch (org.openqa.selenium.NoSuchElementException e) {
                    System.out.println("Skipping product due to missing element: " + e.getMessage());
                }
            }

            // Check for next page
            try {
                if (nextPageButton.isDisplayed() && nextPageButton.isEnabled()) {
                    nextPageButton.click();
                    // Re-initialize elements for the new page
                    this.productList = driver.findElements(By.xpath("//div[contains(@class, 's-result-item')]//span[@data-component-type='s-product-image']"));
                    this.nextPageButton = driver.findElement(By.xpath("//a[contains(@class, 's-pagination-next')]"));
                } else {
                    hasNextPage = false;
                }
            } catch (org.openqa.selenium.NoSuchElementException e) {
                hasNextPage = false;
            }
        }
        return products;
    }

    public ProductPage clickFirstProduct() {
        if (!productList.isEmpty()) {
            productList.get(0).click();
        }
        return new ProductPage(driver);
    }
}


