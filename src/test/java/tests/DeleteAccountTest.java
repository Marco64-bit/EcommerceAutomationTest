package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.automationexercise.pages.LoginPage;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteAccountTest extends BaseTest {

    @Test
   public void testDeleteAccount() {
        // تشغيل المتصفح
        LoginPage loginPage = new LoginPage(driver);
            // خطوة 4 و 5: الضغط على Login والتأكد من ظهور الصفحة
        loginPage.navigateToLoginPage();

        Assert.assertTrue(loginPage.isLoginHeaderDisplayed(), "Login Header is not displayed");

        // خطوة 6 و 7: تسجيل الدخول (لازم الحساب يكون موجود فعلاً)
        loginPage.performLogin("test_user_unique@example.com", "password123");

        // خطوة 8: التأكد من الدخول بنجاح
        String userText = loginPage.getLoggedInUserText();
        Assert.assertEquals(userText, "Logged in as Test User", "User is not logged in successfully");

        // خطوة 9 و 10: حذف الحساب والتأكد من النتيجة النهائية
        loginPage.clickDeleteAccount();
        String finalMsg = loginPage.getDeleteConfirmation();

        Assert.assertEquals(finalMsg, "ACCOUNT DELETED!", "Account deletion failed");

    }
}
