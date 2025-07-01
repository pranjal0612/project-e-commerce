package com.ecommerce.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SearchResultsPage extends BasePage {

    private By productSelector = By.cssSelector(".a-section.a-spacing-small.a-spacing-top-small");
    private By nextPageButtonSelector = By.xpath("//a[contains(@class, 's-pagination-next')]");
    private By firstProductLinkSelector = By.cssSelector(".a-section.a-spacing-small.a-spacing-top-small a.a-link-normal.s-underline-text.s-underline-link-text.s-link-style.a-text-normal");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<Map<String, String>> getProductDetails() {
        List<Map<String, String>> products = new ArrayList<>();
        boolean hasNextPage = true;

        while (hasNextPage) {
            List<WebElement> productList = driver.findElements(productSelector);

            for (WebElement product : productList) {
                WebElement productNameElement = safeFindElement(product, By.cssSelector("h2 span"));
                if (productNameElement == null) continue;

                Map<String, String> productDetails = new HashMap<>();
                productDetails.put("Product Name", productNameElement.getText());

                WebElement priceElement = safeFindElement(product, By.cssSelector("span.a-price-whole"));
                productDetails.put("Price", priceElement != null ? priceElement.getText() : "N/A");

                WebElement ratingsElement = safeFindElement(product, By.cssSelector("i.a-icon-star-small span.a-icon-alt"));
                productDetails.put("Ratings", ratingsElement != null ? ratingsElement.getText() : "N/A");

                WebElement urlElement = safeFindElement(product, By.cssSelector("a.a-link-normal.s-underline-text.s-underline-link-text.s-link-style.a-text-normal"));
                if (urlElement == null) {
                    urlElement = safeFindElement(product, By.cssSelector("a.a-link-normal"));
                }
                productDetails.put("URL", urlElement != null ? urlElement.getAttribute("href") : "N/A");

                products.add(productDetails);
            }

            try {
                WebElement nextPageButton = driver.findElement(nextPageButtonSelector);
                if (nextPageButton.isDisplayed() && nextPageButton.isEnabled()) {
                    nextPageButton.click();

                    new WebDriverWait(driver, Duration.ofSeconds(10))
                            .until(ExpectedConditions.presenceOfElementLocated(productSelector));
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
        WebElement firstProductLink = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(firstProductLinkSelector));
        firstProductLink.click();
        return new ProductPage(driver);
    }

    private WebElement safeFindElement(WebElement parent, By by) {
        try {
            return parent.findElement(by);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return null;
        }
    }
}