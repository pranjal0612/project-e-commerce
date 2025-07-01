package com.ecommerce.test.pages;

import com.ecommerce.test.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
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

