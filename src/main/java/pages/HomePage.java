package pages;

import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private String url = "https://demoqa.com/";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public void navigateToElementsPage() {
        driver.get(url + "elements");
    }

    public String getTitle() {
        return driver.getTitle();
    }
}