package stepdefinition;

import com.microsoft.playwright.Page;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import utility.AppConstants;
import utility.BaseTest;

public class LoginStepDef extends BaseTest implements AppConstants.APP_PARAMETERS {

    LoginPage loginPage;
    Page page;

    @Given("^I launch gearbox web app$")
    public void i_launch_gearbox_web_app() {
        page = initBrowser(CHROME);
        loginPage = new LoginPage(page);
        String actualTitle = loginPage.getLoginPageTitle();
        Assert.assertEquals(actualTitle, GEAR_BOX_TITLE);
    }

    @Given("^I'm on login screen$")
    public void i_m_on_login_screen() {
        String actualUrl = loginPage.getLoginPageUrl();
        Assert.assertEquals(actualUrl, EXPECTED_URL);
    }

    @When("^I enter valid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_enter_valid_and(String emailId, String password) {
        loginPage.enterEmailId(emailId);
        loginPage.enterPassword(password);
    }

    @When("^I click on login button$")
    public void i_click_on_login_button() {
        loginPage.clickOnLoginBtn();
    }

    @Then("^I should be logged in successfully$")
    public void i_should_be_logged_in_successfully() {

    }
}
