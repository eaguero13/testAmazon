import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AmazonCartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By deleteButton = By.cssSelector("input[value='Delete']");
    private By emptyCartMessage = By.xpath("//h1[normalize-space()='Your Amazon Cart is empty.']");

    public AmazonCartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void deleteProductFromCart() {
        WebElement deleteButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(deleteButton));
        deleteButtonElement.click();
    }

    public boolean isCartEmpty() {
        WebElement emptyCartMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emptyCartMessage));
        return emptyCartMessageElement.isDisplayed();
    }
}