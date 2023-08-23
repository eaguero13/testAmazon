import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonHomePage {
    private WebDriver driver;

    private By searchBar = By.xpath("//input[@id='twotabsearchtextbox']");
    private By searchButton = By.cssSelector("#nav-search-submit-button");

    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchForProduct(String productName) {
        WebElement searchBarElement = driver.findElement(searchBar);
        searchBarElement.sendKeys(productName);
        driver.findElement(searchButton).click();
    }
}

