package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TextBoxPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private By fullNameInput = By.id("userName");
    private By emailInput = By.id("userEmail");
    private By currentAddressInput = By.id("currentAddress");
    private By permanentAddressInput = By.id("permanentAddress");
    private By submitButton = By.id("submit");
    private By output = By.id("output");
    private By header = By.cssSelector("h1.text-center");


    public TextBoxPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Actions

    public void navigateToTextBoxPage() {
        driver.get(driver.getCurrentUrl() + "text-box");
    }

    public void enterFullName(String fullName) {
        driver.findElement(fullNameInput).sendKeys(fullName);
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);
    }

    public void enterCurrentAddress(String currentAddress) {
        driver.findElement(currentAddressInput).sendKeys(currentAddress);
    }

    public void enterPermanentAddress(String permanentAddress) {
        driver.findElement(permanentAddressInput).sendKeys(permanentAddress);
    }

    public void clickSubmit() {
        wait.until(driver -> driver.findElement(submitButton).isDisplayed());
        driver.findElement(submitButton).click();
    }

    public String getOutputText() {
        WebElement outputElement = driver.findElement(output);
        return outputElement.isDisplayed() ? outputElement.getText() : "";
    }

    public boolean areAllElementsVisible() {
        WebElement headerElement = driver.findElement(header);
        wait.until(driver -> headerElement.isDisplayed() && headerElement.getText().contains("Text Box"));
        return driver.findElement(fullNameInput).isDisplayed() &&
                driver.findElement(emailInput).isDisplayed() &&
                driver.findElement(currentAddressInput).isDisplayed() &&
                driver.findElement(permanentAddressInput).isDisplayed() &&
                driver.findElement(submitButton).isDisplayed();
    }

}
