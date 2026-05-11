package tests;

import base.BaseTest;
import com.automationexercise.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveProductsFromCartTest extends BaseTest {

    @Test
    public void removeProductsFromCart() {

        ProductPage productPage = new ProductPage(driver);

        productPage.addProductWithQuantity(1);
        productPage.removeProductFromCart();
        Assert.assertTrue(productPage.isCartEmpty());
    }
}