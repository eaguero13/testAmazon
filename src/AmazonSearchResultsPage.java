import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;;

import java.time.Instant;

public class AmazonSearchResultsPage {
    private WebDriver driver;

    private By sortDropdown = By.cssSelector(".a-dropdown-prompt");
    private By sortAscendingOption = By.cssSelector("#s-result-sort-select_1");
    private By secondProduct = By.cssSelector("div[class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_2'] span[class='a-size-medium a-color-base a-text-normal']");
    private By addToCartButton = By.xpath("//input[@id='add-to-cart-button']");
    private By cartButton = By.xpath("//span[@class='nav-cart-icon nav-sprite']");


    public AmazonSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sortResultsAscending() {
        driver.findElement(sortDropdown).click();
        driver.findElement(sortAscendingOption).click();
    }

    public void selectSecondProduct() {
        driver.findElement(secondProduct).click();
    }
    public void addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement addToCartElement = wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        driver.findElement(addToCartButton).click();
    }
    public void goToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement cartButtonElement = wait.until(ExpectedConditions.elementToBeClickable(cartButton));
        cartButtonElement.click();
    }
}
