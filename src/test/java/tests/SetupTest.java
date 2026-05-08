package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SetupTest extends BaseTest {

    @Test
    public void testBrowserOpensSuccessfully() {
        // Get the title of the webpage
        String pageTitle = driver.getTitle();
        System.out.println("The page title is: " + pageTitle);

        // Assert that we are actually on the right website
        Assert.assertTrue(pageTitle.contains("Automation Exercise"), "Title did not match!");
    }
}