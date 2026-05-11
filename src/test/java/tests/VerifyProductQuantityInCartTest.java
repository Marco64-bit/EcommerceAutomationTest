package tests;

import base.BaseTest;
import com.automationexercise.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyProductQuantityInCartTest extends BaseTest {

    @Test
    public void verifyProductQuantityInCart() {

        ProductPage productPage = new ProductPage(driver);

        productPage.addProductWithQuantity(4);

        Assert.assertEquals(productPage.getCartQuantity(), "4");
    }
}