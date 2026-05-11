package tests;

import base.BaseTest;
import com.automationexercise.pages.CategoryPage;
import com.automationexercise.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ViewCategoryProductsTest extends BaseTest {

    @Test
    public void viewWomenDressCategoryTest() {

        // Step 1: Verify home page is visible
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible(),
            "FAIL: Home page is not visible.");

        // Step 2: Click "Women" category in sidebar
        homePage.clickWomenCategory();

        // Step 3: Click "Dress" sub-category
        homePage.clickWomenSubCategory("Dress");

        // Step 4: Verify category page is visible
        CategoryPage categoryPage = new CategoryPage(driver);
        Assert.assertTrue(categoryPage.isCategoryPageVisible(),
            "FAIL: Category page not visible after clicking Women > Dress.");

        // Step 5: Verify heading contains "Women"
        Assert.assertTrue(categoryPage.headingContains("Women"),
            "FAIL: Page heading does not contain 'Women'. Actual: "
            + categoryPage.getCategoryHeadingText());

        // Step 6: Verify products are displayed
        int productCount = categoryPage.getProductCount();
        Assert.assertTrue(productCount > 0,
            "FAIL: No products found on Women > Dress category page.");

        System.out.println("PASS: Women > Dress - " + productCount + " products displayed.");
    }

    @Test
    public void viewMenTshirtsCategoryTest() {

        // Step 1: Verify home page is visible
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible(),
            "FAIL: Home page is not visible.");

        // Step 2: Click "Men" category in sidebar
        homePage.clickMenCategory();

        // Step 3: Click "Tshirts" sub-category
        homePage.clickMenSubCategory("Tshirts");

        // Step 4: Verify category page is visible
        CategoryPage categoryPage = new CategoryPage(driver);
        Assert.assertTrue(categoryPage.isCategoryPageVisible(),
            "FAIL: Category page not visible after clicking Men > Tshirts.");

        // Step 5: Verify heading contains "Men"
        Assert.assertTrue(categoryPage.headingContains("Men"),
            "FAIL: Page heading does not contain 'Men'. Actual: "
            + categoryPage.getCategoryHeadingText());

        // Step 6: Verify products are displayed
        int productCount = categoryPage.getProductCount();
        Assert.assertTrue(productCount > 0,
            "FAIL: No products found on Men > Tshirts category page.");

        System.out.println("PASS: Men > Tshirts - " + productCount + " products displayed.");
    }
}
