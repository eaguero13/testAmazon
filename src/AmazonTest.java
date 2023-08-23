import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "/Users/alexisaguero/Desktop/geckodriver 2");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.get("https://www.amazon.com/");
    }

    @Test
    public void testAmazonCartFlow() {
        AmazonHomePage homePage = new AmazonHomePage(driver);
        homePage.searchForProduct("iPhone 14");

        AmazonSearchResultsPage resultsPage = new AmazonSearchResultsPage(driver);
        resultsPage.sortResultsAscending();
        resultsPage.selectSecondProduct();
        resultsPage.addToCart();
        resultsPage.goToCart();

        AmazonCartPage cartPage = new AmazonCartPage(driver, wait);
        cartPage.deleteProductFromCart();
        Assert.assertTrue(cartPage.isCartEmpty());
    }

    @AfterTest
    public void tearDown() {
        //driver.quit();
    }
}
