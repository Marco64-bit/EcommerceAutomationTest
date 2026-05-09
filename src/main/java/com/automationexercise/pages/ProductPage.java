package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    private By productsButton = By.cssSelector("a[href='/products']");
    private By searchInput = By.id("search_product");
    private By searchButton = By.id("submit_search");
    private By searchedProductsTitle = By.xpath("//h2[contains(text(),'Searched Products')]");

    public ProductPage(WebDriver driver) {
        setDriver(driver);
    }

    public void searchForProduct(String productName) {
        driver.findElement(productsButton).click();
        driver.findElement(searchInput).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public boolean isSearchResultVisible() {
        return driver.findElement(searchedProductsTitle).isDisplayed();
    }
}
