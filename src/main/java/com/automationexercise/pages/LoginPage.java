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
    By loginHeader = By.xpath("//h2[text()='Login to your account']");
    private By loginEmailInput = By.cssSelector("input[data-qa='login-email']");
    private By loginPasswordInput = By.cssSelector("input[data-qa='login-password']");
    private By loginSubmitButton = By.cssSelector("button[data-qa='login-button']");

    // Locators for Signup Form
    private By signupNameInput = By.cssSelector("input[data-qa='signup-name']");
    private By signupEmailInput = By.cssSelector("input[data-qa='signup-email']");
    private By signupSubmitButton = By.cssSelector("button[data-qa='signup-button']");
    private By existingEmailErrorMsg = By.xpath("//p[contains(text(), 'Email Address already exist!')]");
    private By loggedInAsText = By.xpath("//*[contains(text(), 'Logged in as')]");

    By deleteAccountBtn = By.xpath("//a[contains(text(),'Delete Account')]");
    By accountDeletedMsg = By.cssSelector("[data-qa='account-deleted']");

    public LoginPage(WebDriver driver) {
        setDriver(driver);
    }

    // --- Navigation Actions ---
    public void navigateToLoginPage() {
        getElement(signupLoginNavButton).click();
    }

    public void clickLogout() {
        getElement(logoutNavButton).click();
    }

    // --- Login Actions ---
    public void performLogin(String email, String password) {
        getElement(loginEmailInput).sendKeys(email);
        getElement(loginPasswordInput).sendKeys(password);
        getElement(loginSubmitButton).click();
    }

    // --- Signup Actions ---
    public void attemptSignup(String name, String email) {
        getElement(signupNameInput).sendKeys(name);
        getElement(signupEmailInput).sendKeys(email);
        getElement(signupSubmitButton).click();
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

    public boolean isLoginHeaderDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginHeader)).isDisplayed();
    }

    public String getLoggedInUserText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInAsText)).getText();
    }

    public void clickDeleteAccount() {
        driver.findElement(deleteAccountBtn).click();
    }

    public String getDeleteConfirmation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(accountDeletedMsg)).getText();
    }
}