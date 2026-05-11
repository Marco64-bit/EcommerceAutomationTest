package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CheckoutPage extends BasePage {

    // Locators
    private By addressDetailsHeading = By.xpath("//h2[contains(text(),'Address Details')]");
    private By commentTextarea       = By.cssSelector("textarea.form-control");
    private By placeOrderButton      = By.cssSelector("a.btn.btn-default.check_out");

    public CheckoutPage(WebDriver driver) {
        setDriver(driver);
    }

    // --- Verification ---
    public boolean isCheckoutPageVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement heading = wait.until(
            ExpectedConditions.visibilityOfElementLocated(addressDetailsHeading)
        );
        return heading.isDisplayed();
    }

    // --- Actions ---
    public void enterComment(String comment) {
        driver.findElement(commentTextarea).sendKeys(comment);
    }

    public void clickPlaceOrder() {
        driver.findElement(placeOrderButton).click();
    }
}
