package tests;

import base.BaseTest;
import com.automationexercise.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceOrderRegisterWhileCheckoutTest extends BaseTest {

    // Test Data
    private final String NAME       = "Ahmed Tester";
    private final String EMAIL      = "ahmed.test." + System.currentTimeMillis() + "@test.com";
    private final String PASSWORD   = "Test@2026";
    private final String FIRST_NAME = "Ahmed";
    private final String LAST_NAME  = "Tester";
    private final String ADDRESS    = "123 Test St, Giza";
    private final String CITY       = "Cairo";
    private final String STATE      = "Giza";
    private final String ZIPCODE    = "12345";
    private final String MOBILE     = "01012345678";

    // Fake card data (practice site - no real payment)
    private final String CARD_NAME   = "Ahmed Tester";
    private final String CARD_NUMBER = "4111111111111111";
    private final String CARD_CVV    = "123";
    private final String CARD_MONTH  = "12";
    private final String CARD_YEAR   = "2027";

    @Test
    public void placeOrderRegisterWhileCheckoutTest() {

        // Step 1: Verify home page is visible
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isHomePageVisible(),
            "FAIL: Home page is not visible.");

        // Step 2: Add a product to cart
        // Navigate directly to products page and add first product
        driver.get("https://automationexercise.com/products");
        driver.findElement(
            org.openqa.selenium.By.xpath("(//a[contains(@class,'add-to-cart')])[1]")
        ).click();

        // Click "Continue Shopping" in the modal
        try {
            Thread.sleep(1000);
            driver.findElement(
                org.openqa.selenium.By.cssSelector("button.close-modal")
            ).click();
        } catch (Exception ignored) {}

        // Step 3: Go to Cart
        homePage.clickCart();
        CartPage cartPage = new CartPage(driver);
        Assert.assertTrue(cartPage.isCartPageVisible(),
            "FAIL: Cart page is not visible.");

        // Step 4: Click Proceed To Checkout (user not logged in -> modal appears)
        cartPage.clickProceedToCheckout();

        // Step 5: Click "Register / Login" in the modal
        cartPage.clickRegisterLoginInModal();

        // Step 6: Verify we are on Signup/Login page
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isLoginUrl(),
            "FAIL: Not on login page.");

        // Step 7: Fill signup form (name + email)
        loginPage.attemptSignup(NAME, EMAIL);

        // Step 8: Verify account info form is visible
        RegisterPage registerPage = new RegisterPage(driver);
        Assert.assertTrue(registerPage.isAccountInfoFormVisible(),
            "FAIL: Account info form is not visible.");

        // Step 9: Fill full registration form
        registerPage.fillAccountDetails(
            PASSWORD, FIRST_NAME, LAST_NAME,
            ADDRESS, CITY, STATE, ZIPCODE, MOBILE
        );

        // Step 10: Create Account
        registerPage.clickCreateAccount();

        // Step 11: Verify "Account Created!"
        Assert.assertTrue(registerPage.isAccountCreated(),
            "FAIL: Account Created message not visible.");

        // Step 12: Click Continue -> back to home (now logged in)
        registerPage.clickContinue();
        Assert.assertTrue(homePage.isLoggedInAs(FIRST_NAME),
            "FAIL: User is not logged in after registration.");

        // Step 13: Go to Cart again
        homePage.clickCart();
        Assert.assertTrue(cartPage.isCartPageVisible(),
            "FAIL: Cart page not visible after registration.");

        // Step 14: Proceed to Checkout (now logged in -> goes directly to checkout)
        cartPage.clickProceedToCheckout();
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        Assert.assertTrue(checkoutPage.isCheckoutPageVisible(),
            "FAIL: Checkout page not visible.");

        // Step 15: Enter comment and Place Order
        checkoutPage.enterComment("Please deliver between 9am-5pm.");
        checkoutPage.clickPlaceOrder();

        // Step 16: Enter payment details
        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.enterPaymentDetails(
            CARD_NAME, CARD_NUMBER, CARD_CVV, CARD_MONTH, CARD_YEAR
        );

        // Step 17: Confirm payment
        paymentPage.clickPayAndConfirmOrder();

        // Step 18: Verify Order Placed!
        Assert.assertTrue(paymentPage.isOrderPlaced(),
            "FAIL: Order Placed confirmation not visible.");

        // Step 19: Cleanup - Delete test account
        homePage.clickDeleteAccount();
    }
}
