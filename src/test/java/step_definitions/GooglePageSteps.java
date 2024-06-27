package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.GoogleHomePage;
import utilities.Driver;

public class GooglePageSteps {
    private WebDriver driver = Driver.getDriverInstance();
    private GoogleHomePage googleHomePage = new GoogleHomePage(Driver.getDriverInstance());

    @Given("I open Google Search page")
    public void iOpenGoogleSearchPage() {
        driver.get("https://www.google.com/");
    }

    @When("I enter search term as {string}")
    public void iEnterSearchTermAs(String searchTerm) {
        googleHomePage.inputTextArea.sendKeys(searchTerm);
    }

    @And("I hit enter key")
    public void iHitEnterKey() {
        googleHomePage.inputTextArea.sendKeys(Keys.ENTER);
    }

    @Then("I should see Google Search results")
    public void iShouldSeeGoogleSearchResults() {
        Assert.assertTrue(googleHomePage.searchResultsTab.isDisplayed());
    }
}
