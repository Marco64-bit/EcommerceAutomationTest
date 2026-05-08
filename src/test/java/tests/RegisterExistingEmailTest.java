package tests;

import base.BaseTest;
import com.automationexercise.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterExistingEmailTest extends BaseTest {

    @Test
    public void testRegisterWithExistingEmail() {
        LoginPage loginPage = new LoginPage(driver);

        // 1. Navigate to the Login/Signup page
        loginPage.navigateToLoginPage();

        // 2. Attempt to sign up with an email that is already registered
        // Make sure to use an email you have manually registered on the site beforehand
        loginPage.attemptSignup("Marco", "marco.alreadyexists@example.com");

        // 3. Assert that the "Email Address already exists!" error is visible
        boolean isErrorDisplayed = loginPage.isExistingEmailErrorVisible();
        Assert.assertTrue(isErrorDisplayed, "The existing email error message did not appear!");
    }
}