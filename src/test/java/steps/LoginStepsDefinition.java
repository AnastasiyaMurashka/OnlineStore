package steps;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverSingleton;
import models.User;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.PersonalCabinetPage;
import services.UserBuilder;

public class LoginStepsDefinition {

    private MainPage mainPage;
    private User user;
    private WebDriver driver = DriverSingleton.getDriver();

    @Given("^User is on login form$")
    public void userIsOnLoginForm() {
        mainPage = new MainPage(driver);
        mainPage.openPage().clickOnLoginSpan().clickOnPersonalCabinetReference();
    }

    @Given("^User has valid credentials$")
    public void userHasValidCredentials() {
        user = UserBuilder.getUserWithValidCredentials();
    }

    @When("^User inputs name$")
    public void userInputName() {
        mainPage.inputName(user.getName());
    }

    @And("^User inputs password$")
    public void userInputPassword() {
        mainPage.inputPassword(user.getPassword());
    }

    @And("^User clicks on login button$")
    public void userClickOnLoginButton() {
        mainPage.clickOnLoginButton();
    }

    @Then("^User verify that login with correct name and password is successfully and User on 'Personal cabinet' page$")
    public void userVerifyThatLoginWithCorrectNameAndPasswordIsSuccessfullyAndUserOnPersonalCabinetPage() {
        assertEquals("User with valid credentials can't manage personal cabinet", "Личный кабинет"
                , new PersonalCabinetPage(driver).getTextFromPersonalCabinetTitle());
    }

    @Given("^User doesn't has valid credentials$")
    public void userDoesntHasValidCredentials() {
        user = UserBuilder.getUserWithoutValidCredentials();
    }

    @When("^User inputs (.*) name$")
    public void userInputNameName(String name) {
        mainPage.inputName(name);
    }

    @And("^User inputs (.*) password$")
    public void userInputPasswordPassword(String password) {
        mainPage.inputPassword(password);
    }

    @Then("^User verify that login with incorrect name and password isn't successfully and User on remind login or password page$")
    public void userVerifyThatLoginWithIncorrectNameAndPasswordIsnTSuccessfullyAndUserOnRemindLoginOrPasswordPage() {
        assertEquals("User with invalid credentials doesn't manage remind page", "Забыли пароль?"
                , new PersonalCabinetPage(driver).getTextFromPersonalCabinetTitle());
    }

    @After
    public void closeBrowser() {
        DriverSingleton.closeDriver();
    }
}
