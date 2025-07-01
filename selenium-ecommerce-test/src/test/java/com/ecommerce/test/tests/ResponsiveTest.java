package com.ecommerce.test.tests;

import com.ecommerce.test.pages.HomePage;
import com.ecommerce.test.utilities.ResponsiveTestUtil;
import org.testng.annotations.Test;

public class ResponsiveTest extends BaseTest {

    @Test
    public void testResponsiveness() {
        HomePage homePage = new HomePage(driver);
        homePage.navigateToHomePage();

        // Test desktop size
        ResponsiveTestUtil.setScreenSize(driver, 1366, 768);
        System.out.println("Testing with Desktop resolution (1366x768)");
        // Add assertions here to validate layout for desktop

        // Test tablet size
        ResponsiveTestUtil.setScreenSize(driver, 768, 1024);
        System.out.println("Testing with Tablet resolution (768x1024)");
        // Add assertions here to validate layout for tablet

        // Test mobile size
        ResponsiveTestUtil.setScreenSize(driver, 375, 667);
        System.out.println("Testing with Mobile resolution (375x667)");
        // Add assertions here to validate layout for mobile

        ResponsiveTestUtil.resetScreenSize(driver);
    }
}

