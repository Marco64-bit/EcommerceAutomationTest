package tests;

import base.BaseTest;

import com.automationexercise.pages.ProductPage;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void testCart() {
        ProductPage productsPage = new ProductPage(driver);
        productsPage.goToProducts();

        productsPage.addFirstProduct();

        productsPage.clickContinue();

        productsPage.addSecondProduct();

        productsPage.clickViewCart();

    }
}