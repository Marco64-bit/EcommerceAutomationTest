package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegisterPage extends BasePage {

    // Locators for Account Info Form
    private By accountInfoHeading   = By.xpath("//b[text()='Enter Account Information']");
    private By titleMrRadio         = By.id("id_gender1");
    private By passwordInput        = By.id("password");
    private By dayDropdown          = By.id("days");
    private By monthDropdown        = By.id("months");
    private By yearDropdown         = By.id("years");

    // Locators for Address Info
    private By firstNameInput       = By.id("first_name");
    private By lastNameInput        = By.id("last_name");
    private By address1Input        = By.id("address1");
    private By countryDropdown      = By.id("country");
    private By stateInput           = By.id("state");
    private By cityInput            = By.id("city");
    private By zipcodeInput         = By.id("zipcode");
    private By mobileInput          = By.id("mobile_number");

    // Locators for Submit & Confirmation
    private By createAccountButton  = By.cssSelector("button[data-qa='create-account']");
    private By accountCreatedHeading = By.xpath("//b[text()='Account Created!']");
    private By continueButton       = By.cssSelector("a[data-qa='continue-button']");

    public RegisterPage(WebDriver driver) {
        setDriver(driver);
    }

    // --- Verification ---
    public boolean isAccountInfoFormVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement heading = wait.until(
            ExpectedConditions.visibilityOfElementLocated(accountInfoHeading)
        );
        return heading.isDisplayed();
    }

    public boolean isAccountCreated() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement heading = wait.until(
            ExpectedConditions.visibilityOfElementLocated(accountCreatedHeading)
        );
        return heading.isDisplayed();
    }

    // --- Actions ---
    public void fillAccountDetails(String password, String firstName, String lastName,
                                   String address, String city, String state,
                                   String zipcode, String mobile) {
        driver.findElement(titleMrRadio).click();
        driver.findElement(passwordInput).sendKeys(password);

        new Select(driver.findElement(dayDropdown)).selectByValue("10");
        new Select(driver.findElement(monthDropdown)).selectByValue("5");
        new Select(driver.findElement(yearDropdown)).selectByValue("2000");

        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(address1Input).sendKeys(address);

        Select countrySelect = new Select(driver.findElement(countryDropdown));
        // Try to select Egypt, if not found select United States
        try {
            countrySelect.selectByVisibleText("Egypt");
        } catch (Exception e) {
            countrySelect.selectByVisibleText("United States");
        }

        driver.findElement(stateInput).sendKeys(state);
        driver.findElement(cityInput).sendKeys(city);
        driver.findElement(zipcodeInput).sendKeys(zipcode);
        driver.findElement(mobileInput).sendKeys(mobile);
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountButton).click();
    }

    public void clickContinue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }
}
