package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.DriverFactory;
import org.testng.Assert;

public class HomePageSteps {
    WebDriver driver;
    HomePage homePage;

    @Given("I open the DemoQA home page")
    public void i_open_the_demoqa_home_page() {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        homePage.open();
    }

    @Then("the page title should be {string}")
    public void the_page_title_should_be(String expectedTitle) {
        Assert.assertEquals(homePage.getTitle(), expectedTitle);
        DriverFactory.quitDriver();
    }

    @Then("The home page elements should be visible")
    public void the_home_page_elements_should_be_visible() {
        Assert.assertTrue(homePage.isElementsCardVisible());
        Assert.assertTrue(homePage.isAlertsCardVisible());
        Assert.assertTrue(homePage.isFormsCardVisible());
        Assert.assertTrue(homePage.isBookStoreCardVisible());
        Assert.assertTrue(homePage.isWidgetsCardVisible());
        Assert.assertTrue(homePage.isInteractionsCardVisible());
        DriverFactory.quitDriver();
    }
}