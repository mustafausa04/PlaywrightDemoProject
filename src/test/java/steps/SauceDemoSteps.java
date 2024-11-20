package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SauceDemoPage;
import utils.PW;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SauceDemoSteps {

    SauceDemoPage saucepage = new SauceDemoPage();

    @Given("User is on the sauce login page")
    public void user_is_on_the_sauce_login_page() {
        PW.getPage().navigate("https://saucedemo.com");
    }
    @When("User enters a valid username and a valid password")
    public void user_enters_a_valid_username_and_a_valid_password() {
        PW.getPage().locator(saucepage.sauceUsername).fill("standard_user");
        PW.getPage().locator(saucepage.saucePassword).fill("secret_sauce");
    }
    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        PW.getPage().locator(saucepage.sauceLoginBtn).click();
    }
    @Then("User should be able to login successfully")
    public void user_should_be_able_to_login_successfully() {
        assertThat(PW.getPage().locator(saucepage.sauceHomePageProductHeader)).isVisible();
    }



    // invalid password test
    @When("User enters a valid username and a invalid password")
    public void user_enters_a_valid_username_and_a_invalid_password() {
        PW.getPage().locator(saucepage.sauceUsername).fill("standard_user");
        PW.getPage().locator(saucepage.saucePassword).fill("secret_jam");
    }
    @Then("User should not be logged in")
    public void user_should_not_be_logged_in() {
        assertThat(PW.getPage().locator(saucepage.sauceUsername)).isVisible();
    }
    @Then("Error message {string} displays")
    public void error_message_displays(String expectedMessage) {
        String actualErrorMessage = PW.getPage().locator(saucepage.sauceSadfaceErrorMessage).innerText();
        System.out.println(actualErrorMessage);
        assertThat(PW.getPage().locator(saucepage.sauceSadfaceErrorMessage)).hasText(expectedMessage);

    }
}
