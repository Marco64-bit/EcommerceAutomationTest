package tests;

import base.BaseTest;
import com.automationexercise.pages.ContactUsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest extends BaseTest {

    @Test
    public void testContactUsForm() {
        ContactUsPage contactUsPage = new ContactUsPage(driver);

        contactUsPage.submitContactForm(
                "Mazen",
                "mazen@test.com",
                "Testing Contact Form",
                "This is a selenium automation test"
        );

        Assert.assertTrue(contactUsPage.isSuccessMessageVisible(), "Success message was not displayed");
    }
}
