package com.ecommerce.test.utilities;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class ResponsiveTestUtil {

    public static void setScreenSize(WebDriver driver, int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }

    public static void resetScreenSize(WebDriver driver) {
        driver.manage().window().maximize();
    }
}

