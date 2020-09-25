package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.DriverSingleton;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import pages.BucketPage;
import pages.MainPage;
import pages.ProductPage;

public class CheckProductDataStepsDefinition {
    private ProductPage productPage;
    private BucketPage bucketPage;
    private String productName;
    private String productCost;

    @Given("^User is on product page with (.*)$")
    public void userIsOnProductPageWithId(String id) {
        WebDriver driver = DriverSingleton.getDriver();
        productPage = new MainPage(driver).openPage().inputProductIdInSearchInput(id).clickOnSearchButton();

    }

    @When("^User adds product in bucket$")
    public void userAddProductInBucket() {
        productName = productPage.getProductNameFromProductPage();
        productCost = productPage.getProductCostFromProductPage();
        productPage.addProductInBucket();
    }

    @And("^User goes to the bucket$")
    public void userGoToTheBucket() {
        bucketPage = productPage.goToBucketPage();
    }

    @Then("^User sees that name in bucket is the same with name from product page$")
    public void userSeeThatNameAndCostInBucketAreTheSameWithNameAndCostFromProductPage() {
        assertEquals("Product name in bucket is different with product name from product page"
                , bucketPage.getNameFromBucket(), productName);
    }

    @Then("^User sees that cost in bucket is the same with cost from product page$")
    public void userSeeThatCostInBucketIsTheSameWithCostFromProductPage() {
        assertEquals("Product cost in bucket is different with product cost from product page",
                bucketPage.getCostFromBucket(), productCost);
    }
}
