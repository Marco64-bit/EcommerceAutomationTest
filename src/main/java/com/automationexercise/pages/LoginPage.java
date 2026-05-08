package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends BasePage {

    // Locators for Top Navigation
    private By signupLoginNavButton = By.cssSelector("a[href='/login']");
    private By logoutNavButton = By.cssSelector("a[href='/logout']");

    // Locators for Login Form
    private By loginEmailInput = By.cssSelector("input[data-qa='login-email']");
    private By loginPasswordInput = By.cssSelector("input[data-qa='login-password']");
    private By loginSubmitButton = By.cssSelector("button[data-qa='login-button']");

    // Locators for Signup Form
    private By signupNameInput = By.cssSelector("input[data-qa='signup-name']");
    private By signupEmailInput = By.cssSelector("input[data-qa='signup-email']");
    private By signupSubmitButton = By.cssSelector("button[data-qa='signup-button']");
    private By existingEmailErrorMsg = By.xpath("//p[contains(text(), 'Email Address already exist!')]");

    public LoginPage(WebDriver driver) {
        setDriver(driver);
    }

    // --- Navigation Actions ---
    public void navigateToLoginPage() {
        driver.findElement(signupLoginNavButton).click();
    }

    public void clickLogout() {
        driver.findElement(logoutNavButton).click();
    }

    // --- Login Actions ---
    public void performLogin(String email, String password) {
        driver.findElement(loginEmailInput).sendKeys(email);
        driver.findElement(loginPasswordInput).sendKeys(password);
        driver.findElement(loginSubmitButton).click();
    }

    // --- Signup Actions ---
    public void attemptSignup(String name, String email) {
        driver.findElement(signupNameInput).sendKeys(name);
        driver.findElement(signupEmailInput).sendKeys(email);
        driver.findElement(signupSubmitButton).click();
    }

    // --- Verification Actions ---
    public boolean isExistingEmailErrorVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(existingEmailErrorMsg));
        return errorMsg.isDisplayed();
    }

    public boolean isLoginUrl() {
        return driver.getCurrentUrl().contains("/login");
    }
}