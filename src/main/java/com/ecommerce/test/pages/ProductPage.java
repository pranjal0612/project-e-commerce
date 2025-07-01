package com.ecommerce.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "(//input[@id='add-to-cart-button'])[2]")
    private WebElement addToCartButton;

    @FindBy(id = "productOverview_feature_div")
    private WebElement productDetailsSection;

    @FindBy(id = "imageBlock")
    private WebElement imageGallery;

    public ProductPage(WebDriver driver) {
        super(driver);
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

