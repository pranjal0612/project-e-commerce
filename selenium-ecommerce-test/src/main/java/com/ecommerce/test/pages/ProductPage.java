package com.ecommerce.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePage {

    private WebElement addToCartButton;
    private WebElement productDetailsSection;
    private WebElement imageGallery;

    public ProductPage(WebDriver driver) {
        super(driver);
        this.addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        this.productDetailsSection = driver.findElement(By.id("productOverview_feature_div"));
        this.imageGallery = driver.findElement(By.id("imageBlock"));
    }

    public boolean isAddToCartButtonPresent() {
        return addToCartButton.isDisplayed();
    }

    public boolean isProductDetailsSectionPresent() {
        return productDetailsSection.isDisplayed();
    }

    public boolean isImageGalleryPresent() {
        return imageGallery.isDisplayed();
    }
}


