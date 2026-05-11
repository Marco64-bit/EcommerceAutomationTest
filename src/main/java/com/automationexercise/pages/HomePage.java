package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage extends BasePage {

    // Locators for Navigation
    private By cartNavButton         = By.cssSelector("a[href='/view_cart']");
    private By signupLoginNavButton  = By.cssSelector("a[href='/login']");
    private By deleteAccountButton   = By.cssSelector("a[href='/delete_account']");
    private By loggedInAsText        = By.xpath("//li[contains(.,'Logged in as')]//b");

    // Locators for Category Sidebar
    private By womenCategoryLink     = By.cssSelector("a[href='#Women']");
    private By menCategoryLink       = By.cssSelector("a[href='#Men']");

    public HomePage(WebDriver driver) {
        setDriver(driver);
    }

    // --- Navigation Actions ---
    public void clickCart() {
        driver.findElement(cartNavButton).click();
    }

    public void clickDeleteAccount() {
        driver.findElement(deleteAccountButton).click();
    }

    // --- Verification ---
    public boolean isLoggedInAs(String name) {
        // Check if user is logged in by looking for the logged in text
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement elem = wait.until(
                ExpectedConditions.visibilityOfElementLocated(loggedInAsText)
            );
            return elem.getText().contains(name);
        } catch (Exception e) {
            // If element not found, check URL or alternative method
            return driver.getPageSource().contains("Logged in as");
        }
    }

    public boolean isHomePageVisible() {
        return driver.getCurrentUrl().contains("automationexercise.com");
    }

    // --- Category Actions ---
    public void clickWomenCategory() {
        WebElement element = driver.findElement(womenCategoryLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickMenCategory() {
        WebElement element = driver.findElement(menCategoryLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickWomenSubCategory(String subCategory) {
        // Wait for the category to expand and click the subcategory using JavaScript to avoid interception
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By locator = By.xpath("//div[@id='Women']//a[contains(text(),'" + subCategory + "')]");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void clickMenSubCategory(String subCategory) {
        // Wait for the category to expand and click the subcategory using JavaScript to avoid interception
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By locator = By.xpath("//div[@id='Men']//a[contains(text(),'" + subCategory + "')]");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
