package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverSingleton;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.ProductPage;

public class DeleteProductFromBucketStepsDefinition {
    private ProductPage productPage;
    private String cosInEmptyBucket;

    @Given("^User is on bucket page with product (.*) in the bucket$")
    public void userIsOnBucketPageWithProductIdInTheBucket(String id) {
        WebDriver driver = DriverSingleton.getDriver();
        productPage = new MainPage(driver).openPage().inputProductIdInSearchInput(id).clickOnSearchButton();
    }

    @When("^User deletes product from the bucket$")
    public void userDeleteProductFromTheBucket() {
        cosInEmptyBucket = productPage.addProductInBucket().goToBucketPage().deleteProductFromBucket().getCostFromEmptyBucket();
    }

    @Then("^User sees that bucket is empty and cost is 0$")
    public void userSeeThatBucketIsEmptyAndCostIs() {
        assertEquals("Cost in empty bucket isn't 0", "0 руб. 00 коп.", cosInEmptyBucket);
    }
}
