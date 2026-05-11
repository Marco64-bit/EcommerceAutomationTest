package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class CategoryPage extends BasePage {

    // Locators
    private By categoryHeading = By.cssSelector("h2.title");
    private By productItems    = By.cssSelector(".product-image-wrapper");

    public CategoryPage(WebDriver driver) {
        setDriver(driver);
    }

    // --- Verification ---
    public boolean isCategoryPageVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement heading = wait.until(
            ExpectedConditions.visibilityOfElementLocated(categoryHeading)
        );
        return heading.isDisplayed();
    }

    public String getCategoryHeadingText() {
        return driver.findElement(categoryHeading).getText();
    }

    public boolean headingContains(String keyword) {
        return getCategoryHeadingText().toUpperCase().contains(keyword.toUpperCase());
    }

    public int getProductCount() {
        List<WebElement> products = driver.findElements(productItems);
        return products.size();
    }
}
