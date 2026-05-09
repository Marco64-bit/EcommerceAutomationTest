package tests;

import base.BaseTest;
import com.automationexercise.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductTest extends BaseTest {
    
    @Test
    public void testSearchProduct() {
        ProductPage productPage = new ProductPage(driver);

        productPage.searchForProduct("Blue Top");

        Assert.assertTrue(productPage.isSearchResultVisible(), "Search result was not displayed");
    }
}
