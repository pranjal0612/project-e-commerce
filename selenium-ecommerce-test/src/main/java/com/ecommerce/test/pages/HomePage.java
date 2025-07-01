package com.ecommerce.test.pages;

import com.ecommerce.test.utilities.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage extends BasePage {

    private WebElement searchBox;
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
        this.searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-search-submit-button")));
    }

    public void navigateToHomePage() {
        driver.get(ConfigReader.getProperty("base.url"));
    }

    public SearchResultsPage searchForProduct(String productName) {
        searchBox.sendKeys(productName);
        searchButton.click();
        return new SearchResultsPage(driver);
    }
}


