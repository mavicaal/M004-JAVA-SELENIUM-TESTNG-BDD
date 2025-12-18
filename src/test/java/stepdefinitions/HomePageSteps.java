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
        System.out.println("I am in step definition class before getting driver");
        driver = DriverFactory.getDriver();
        System.out.println("I am in step definition after getting driver");
        homePage = new HomePage(driver);
        homePage.open();
    }

    @Then("the page title should be {string}")
    public void the_page_title_should_be(String expectedTitle) {
        Assert.assertEquals(homePage.getTitle(), expectedTitle);
        DriverFactory.quitDriver();
    }
}