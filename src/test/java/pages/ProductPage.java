package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static util.MethodWait.*;

public class ProductPage extends AbstractPage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private static final By PRODUCT_ID_SPAN = By.xpath("//span[@class='pr-card-code']");
    private static final By PRODUCT_NAME = By.tagName("h1");
    private static final By PRODUCT_COST = By.xpath("//div[text()='Без клубной карты']/following-sibling::div");
    private static final By PUT_PRODUCT_IN_BUCKET_BUTTON = By.id("but_car_main");
    private static final By GO_TO_BUCKET_BUTTON = By.xpath("//a[@class='h-cart']");

    public String getProductIdFromProductPage() {
        waitPresenceOfElementLocated(driver, PRODUCT_ID_SPAN);
        System.out.println("Hello Eva");
        return driver.findElement(PRODUCT_ID_SPAN).getText().substring(5);
    }

    public String getProductNameFromProductPage() {
        waitPresenceOfElementLocated(driver, PRODUCT_NAME);
        return driver.findElement(PRODUCT_NAME).getText();
    }

    public String getProductCostFromProductPage() {
        waitPresenceOfElementLocated(driver, PRODUCT_COST);
        return driver.findElement(PRODUCT_COST).getText();
    }

    public ProductPage addProductInBucket() {
        waitElementToBeClickable(driver, PUT_PRODUCT_IN_BUCKET_BUTTON);
        driver.findElement(PUT_PRODUCT_IN_BUCKET_BUTTON).click();
        logger.info("Add product to the bucket");
        return this;
    }

    public BucketPage goToBucketPage() {
        waitElementToBeClickable(driver, GO_TO_BUCKET_BUTTON);
        driver.findElement(GO_TO_BUCKET_BUTTON).click();
        logger.info("Navigate to the bucket page");
        return new BucketPage(driver);
    }
}
