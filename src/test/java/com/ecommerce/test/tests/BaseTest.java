package com.ecommerce.test.tests;

import com.ecommerce.test.utilities.ConfigReader;
import com.ecommerce.test.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional("") String browser) {
        String browserName = browser.isEmpty() ? ConfigReader.getProperty("browser") : browser;
        driver = WebDriverFactory.getDriver(browserName);
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

