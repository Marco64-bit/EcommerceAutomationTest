package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends BasePage {

    private final By productsButton = By.cssSelector("a[href='/products']");
    private final By searchInput = By.id("search_product");
    private final By searchButton = By.id("submit_search");
    private final By searchedProductsTitle = By.xpath("//h2[text()='Searched Products']");
    private final By firstProduct = By.xpath("(//div[@class='single-products'])[1]");
    private final By addToCartFirst = By.xpath("(//a[@data-product-id='1'])[2]");
    private final By continueBtn = By.xpath("//button[text()='Continue Shopping']");
    private final By secondProduct = By.xpath("(//div[@class='single-products'])[2]");
    private final By addToCartSecond = By.xpath("(//a[@data-product-id='2'])[2]");
    private final By viewCartBtn = By.xpath("//u[text()='View Cart']");
    private final WebDriverWait wait;
    private final Actions actions;

    // Cart Locators
    private By firstProductViewButton = By.xpath("(//a[contains(text(),'View Product')])[1]");
    private By quantityInput = By.id("quantity");
    private By addToCartButton = By.cssSelector(".cart");
    private By viewCartButton = By.xpath("//u[contains(text(),'View Cart')]");
    private By cartQuantity = By.cssSelector(".disabled");
    private By deleteButton = By.cssSelector(".cart_quantity_delete");
    private By emptyCartMessage = By.xpath("//b[contains(normalize-space(),'Cart is empty')]");

    public ProductPage(WebDriver driver) {
        setDriver(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    public void searchForProduct(String productName) {
        clickElement(productsButton);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput)).clear();
        getElement(searchInput).sendKeys(productName);
        clickElement(searchButton);
    }

    public boolean isSearchResultVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchedProductsTitle)).isDisplayed();
    }

    public void goToProducts() {
        clickElement(productsButton);
    }

    public void addFirstProduct() {
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(firstProduct));
        actions.moveToElement(product).perform();

        wait.until(ExpectedConditions.elementToBeClickable(addToCartFirst)).click();
    }

    public void addProductWithQuantity(int quantity) {
        driver.findElement(productsButton).click();
        driver.findElement(firstProductViewButton).click();

        driver.findElement(quantityInput).clear();
        driver.findElement(quantityInput).sendKeys(String.valueOf(quantity));

        driver.findElement(addToCartButton).click();
        driver.findElement(viewCartButton).click();
    }

    public String getCartQuantity() {
        return driver.findElement(cartQuantity).getText();
    }

    public void removeProductFromCart() {
        driver.findElement(deleteButton).click();
    }

    public boolean isCartEmpty() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMessage)).isDisplayed();
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
    }

    public void addSecondProduct() {
        WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(secondProduct));
        actions.moveToElement(product).perform();

        wait.until(ExpectedConditions.elementToBeClickable(addToCartSecond)).click();
    }

    public void clickViewCart() {
        wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn)).click();
    }


}