package com.automationexercise.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage {

    private By contactUsButton = By.cssSelector("a[href='/contact_us']");
    private By nameInput = By.cssSelector("input[data-qa='name']");
    private By emailInput = By.cssSelector("input[data-qa='email']");
    private By subjectInput = By.cssSelector("input[data-qa='subject']");
    private By messageInput = By.cssSelector("textarea[data-qa='message']");
    private By submitButton = By.cssSelector("input[data-qa='submit-button']");
    private By successMessage = By.cssSelector(".status.alert.alert-success");

    public ContactUsPage(WebDriver driver) {
        setDriver(driver);
    }

    public void submitContactForm(String name, String email, String subject, String message) {
        driver.findElement(contactUsButton).click();
        driver.findElement(nameInput).sendKeys(name);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(subjectInput).sendKeys(subject);
        driver.findElement(messageInput).sendKeys(message);
        driver.findElement(submitButton).click();

        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public boolean isSuccessMessageVisible() {
        return driver.findElement(successMessage).isDisplayed();
    }
}
