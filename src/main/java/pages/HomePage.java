package pages;

import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private String url = "https://demoqa.com/";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        System.out.println("trying to navigate to " + url);
        driver.navigate().to(url);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}