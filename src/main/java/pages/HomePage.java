package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private String url = "https://demoqa.com/";
    // Locators for main cards on DemoQA homepage
    private By elementsCard = By.xpath("//h5[text()='Elements']");
    private By formsCard = By.xpath("//h5[text()='Forms']");
    private By alertsCard = By.xpath("//h5[text()='Alerts, Frame & Windows']");
    private By widgetsCard = By.xpath("//h5[text()='Widgets']");
    private By interactionsCard = By.xpath("//h5[text()='Interactions']");
    private By bookStoreCard = By.xpath("//h5[text()='Book Store Application']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void open() {
        driver.get(url);
    }

    public void navigateToElementsPage() {
        driver.get(url + "elements");
    }

    // Visibility checks
    public boolean isElementsCardVisible() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(elementsCard));
        return element.isDisplayed();
    }

    public boolean isFormsCardVisible() {
        return driver.findElement(formsCard).isDisplayed();
    }

    public boolean isAlertsCardVisible() {
        return driver.findElement(alertsCard).isDisplayed();
    }

    public boolean isWidgetsCardVisible() {
        return driver.findElement(widgetsCard).isDisplayed();
    }

    public boolean isInteractionsCardVisible() {
        return driver.findElement(interactionsCard).isDisplayed();
    }

    public boolean isBookStoreCardVisible() {
        return driver.findElement(bookStoreCard).isDisplayed();
    }


    public String getTitle() {
        return driver.getTitle();
    }
}