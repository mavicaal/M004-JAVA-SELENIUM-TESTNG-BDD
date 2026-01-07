package stepdefinitions;

import io.cucumber.java.en.*;
import net.datafaker.Faker;
import org.openqa.selenium.WebDriver;
import pages.TextBoxPage;
import utils.DriverFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TextBoxPageSteps {

    private WebDriver driver;
    private TextBoxPage textBoxPage;
    private String fullName;
    private String email;
    private String currentAddress;
    private String permanentAddress;

    @Given("User navigates to the Text Box page")
    public void iNavigateToTheTextBoxPage() {
        driver = DriverFactory.getDriver();
        textBoxPage = new TextBoxPage(driver);
        textBoxPage.navigateToTextBoxPage();
    }

    @When("User fills valid data in the Text Box fields")
    public void usersFillsTheFormWithRandomValidData() {
        Faker faker = new Faker();
        fullName = faker.name().fullName();
        email = faker.internet().emailAddress();
        currentAddress = faker.address().streetAddress();
        permanentAddress = faker.address().secondaryAddress();

        textBoxPage.enterFullName(fullName);
        textBoxPage.enterEmail(email);
        textBoxPage.enterCurrentAddress(currentAddress);
        textBoxPage.enterPermanentAddress(permanentAddress);
    }

    @When("User submits the valid data")
    public void userSubmitsValidData() {
        textBoxPage.clickSubmit();
    }

    @Then("Submitted data is displayed correctly")
    public void submitted_data_is_displayed_correctly() {
        String outputText = textBoxPage.getOutputText();
        assertTrue(outputText.contains(fullName));
        assertTrue(outputText.contains(email));
        assertTrue(outputText.contains(currentAddress));
        assertTrue(outputText.contains(permanentAddress));
        DriverFactory.quitDriver();
    }

    @Then("Text Box fields are visible")
    public void textBoxFieldsAreVisible() {
        assertTrue(textBoxPage.areAllElementsVisible());
        DriverFactory.quitDriver();
    }



}
