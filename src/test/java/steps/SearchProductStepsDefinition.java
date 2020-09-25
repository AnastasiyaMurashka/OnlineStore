package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverSingleton;

import static org.junit.Assert.assertEquals;

import pages.MainPage;
import pages.ProductPage;

public class SearchProductStepsDefinition {

    private MainPage mainPage = new MainPage(DriverSingleton.getDriver());

    @Given("^User is on main page$")
    public void userIsOnMainPage() {
        mainPage.openPage();
    }

    @When("^User inputs product (.*) ID$")
    public void userInputProductIdID(String id) {
        mainPage.inputProductIdInSearchInput(id);
    }

    @And("^User clicks search button$")
    public void userClickSearchButton() {
        mainPage.clickOnSearchButton();
    }

    @Then("^User is on product page which the same product (.*) ID$")
    public void userIsOnProductPageWhichTheSameProductID(String id) {
        assertEquals("ID product search gives product page with different ID",
                id, new ProductPage(DriverSingleton.getDriver()).getProductIdFromProductPage());
    }
}
