package com.ecommerce.test.tests;

import com.ecommerce.test.pages.HomePage;
import com.ecommerce.test.utilities.ResponsiveTestUtil;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

@Slf4j
public class ResponsiveTest extends BaseTest {

    @Test
    public void testResponsiveness() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();

        ResponsiveTestUtil.setScreenSize(driver, 1366, 768);
        log.info("Testing with Desktop resolution (1366x768)");

        ResponsiveTestUtil.setScreenSize(driver, 768, 1024);
        log.info("Testing with Tablet resolution (768x1024)");

        ResponsiveTestUtil.setScreenSize(driver, 375, 667);
        log.info("Testing with Mobile resolution (375x667)");

        ResponsiveTestUtil.resetScreenSize(driver);
    }
}

