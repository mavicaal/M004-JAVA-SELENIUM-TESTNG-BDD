package stepdefinitions;

import io.cucumber.java.en.*;
import pages.ElementsPage;
import utils.DriverFactory;
import org.openqa.selenium.WebDriver;

public class ElementsPageSteps {

    WebDriver driver;
    ElementsPage elementsPage;

    @Given("User navigates to the Elements page")
    public void userNavigatesToElementsPage() {
        driver = DriverFactory.getDriver();
        elementsPage = new ElementsPage(driver);
        elementsPage.navigateToElementsPage();
    }

    @Then("The Elements page components should be visible")
    public void theElementsPageComponentsShouldBeVisible() {
        elementsPage.validateElementsPage();
        DriverFactory.quitDriver();
    }
}
