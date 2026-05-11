package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PaymentPage extends BasePage {

    // Locators
    private By nameOnCardInput    = By.cssSelector("input[data-qa='name-on-card']");
    private By cardNumberInput    = By.cssSelector("input[data-qa='card-number']");
    private By cvvInput           = By.cssSelector("input[data-qa='cvc']");
    private By expiryMonthInput   = By.cssSelector("input[data-qa='expiry-month']");
    private By expiryYearInput    = By.cssSelector("input[data-qa='expiry-year']");
    private By payConfirmButton   = By.cssSelector("#submit");
    private By orderPlacedHeading = By.xpath("//b[text()='Order Placed!']");

    public PaymentPage(WebDriver driver) {
        setDriver(driver);
    }

    // --- Actions ---
    public void enterPaymentDetails(String name, String cardNumber,
                                    String cvv, String month, String year) {
        driver.findElement(nameOnCardInput).sendKeys(name);
        driver.findElement(cardNumberInput).sendKeys(cardNumber);
        driver.findElement(cvvInput).sendKeys(cvv);
        driver.findElement(expiryMonthInput).sendKeys(month);
        driver.findElement(expiryYearInput).sendKeys(year);
    }

    public void clickPayAndConfirmOrder() {
        driver.findElement(payConfirmButton).click();
    }

    // --- Verification ---
    public boolean isOrderPlaced() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement heading = wait.until(
            ExpectedConditions.visibilityOfElementLocated(orderPlacedHeading)
        );
        return heading.isDisplayed();
    }
}
