package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage extends BasePage {

    // Locators
    private By cartTable              = By.id("cart_info_table");
    private By proceedToCheckoutBtn   = By.cssSelector(".btn.btn-default.check_out");
    private By registerLoginInModal   = By.xpath("//u[text()='Register / Login']");

    public CartPage(WebDriver driver) {
        setDriver(driver);
    }

    // --- Verification ---
    public boolean isCartPageVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement table = wait.until(
            ExpectedConditions.visibilityOfElementLocated(cartTable)
        );
        return table.isDisplayed();
    }

    // --- Actions ---
    public void clickProceedToCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn)).click();
    }

    public void clickRegisterLoginInModal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(registerLoginInModal));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
