package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class ElementsPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final Duration TIMEOUT = Duration.ofSeconds(5);
    private static final List<String> EXPECTED_ITEMS = Arrays.asList(
            "Text Box",
            "Check Box",
            "Radio Button",
            "Web Tables",
            "Buttons",
            "Links",
            "Broken Links - Images",
            "Upload and Download",
            "Dynamic Properties"
    );

    public ElementsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, TIMEOUT);
    }

    private By leftPanelItemLocator(String text) {
        return By.xpath("//div[contains(@class,'left-pannel')]//span[normalize-space() = '" + text + "']");
    }

    public void navigateToElementsPage() {
        driver.get(driver.getCurrentUrl() + "elements");
    }

    // Returns a list of missing/hidden items (empty if all present)
    public List<String> findMissingItems() {
        List<String> missing = new ArrayList<>();
        for (String item : EXPECTED_ITEMS) {
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(leftPanelItemLocator(item)));
            } catch (TimeoutException e) {
                missing.add(item);
            }
        }
        return missing;
    }

    // Returns true if all expected left-panel elements exist and are visible
    public boolean validateElementsPage() {
        return findMissingItems().isEmpty();
    }
}
