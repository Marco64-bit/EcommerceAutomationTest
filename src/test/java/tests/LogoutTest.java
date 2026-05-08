package tests;

import base.BaseTest;
import com.automationexercise.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void testUserLogout() {
        LoginPage loginPage = new LoginPage(driver);

        // 1. Navigate to the Login page
        loginPage.navigateToLoginPage();

        // 2. Log in with valid credentials
        // You must manually create this account on the site first for the test to work
        loginPage.performLogin("valid.account@example.com", "SecretPassword123!");

        // 3. Click the Logout button in the top navigation bar
        loginPage.clickLogout();

        // 4. Assert that the user is redirected back to the login page
        boolean isBackOnLoginPage = loginPage.isLoginUrl();
        Assert.assertTrue(isBackOnLoginPage, "User was not redirected to the login page after logging out!");
    }
}