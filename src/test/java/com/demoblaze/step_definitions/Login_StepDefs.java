package com.demoblaze.step_definitions;

import com.demoblaze.pages.LoginPage;
import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.ConfigReader;
import com.demoblaze.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigReader.get("url"));

    }

    @When("user clicks on the login menu")
    public void user_clicks_on_the_login_menu() {
        loginPage.loginMenu.click();
    }

    @When("user enters valid credentials and clicks on the login button")
    public void user_enters_valid_credentials_and_clicks_on_the_login_button() {
        loginPage.login();

    }

    @Then("Then verify that user cann see username")
    public void then_verify_that_user_cann_see_username() {
        BrowserUtils.waitForVisibility(loginPage.nameOfUser,3);
        String actaul = loginPage.nameOfUser.getText();
        Assert.assertTrue(actaul.contains(ConfigReader.get("username")));


    }
}