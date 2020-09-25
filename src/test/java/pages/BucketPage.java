package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static util.MethodWait.*;

public class BucketPage extends AbstractPage {

    public BucketPage(WebDriver driver) {
        super(driver);
    }

    private static final By PRODUCT_NAME_FROM_BUCKET = By.xpath("//div[@class='cart-item-product-title']//a");
    private static final By PRODUCT_COST_FROM_BUCKET = By.xpath("//div[@class='cart-item-price']");
    private static final By COST_FROM_EMPTY_BUCKET = By.xpath("//span[@class='total-clubcard-price summa_car1']");
    private static final By DELETE_PRODUCT_FROM_BUCKET = By.xpath("//a[@class='delItem cart-item-remove']");

    public String getNameFromBucket() {
        waitPresenceOfAllElementsLocated(driver, PRODUCT_NAME_FROM_BUCKET);
        return driver.findElements(PRODUCT_NAME_FROM_BUCKET).get(1).getText();
    }

    public String getCostFromBucket() {
        waitPresenceOfAllElementsLocated(driver, PRODUCT_COST_FROM_BUCKET);
        return driver.findElements(PRODUCT_COST_FROM_BUCKET).get(2).getText();
    }

    public String getCostFromEmptyBucket() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='cart-item flex valign-center']")));
        return driver.findElement(COST_FROM_EMPTY_BUCKET).getText();
    }

    public BucketPage deleteProductFromBucket() {
        waitPresenceOfElementLocated(driver, DELETE_PRODUCT_FROM_BUCKET);
        driver.findElement(DELETE_PRODUCT_FROM_BUCKET).click();
        logger.info("Delete product from the bucket");
        return this;
    }
}
