package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static util.MethodWait.*;

public class MainPage extends AbstractPage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private static final By LOGIN_SPAN = By.xpath("//ul[@class='b-user_tools  ']");
    private static final By LOGIN_PERSONAL_CABINET_REFERENCE = By.xpath("//a[contains(text(),'Войти')]");
    private static final By LOGIN_INPUT = By.name("login");
    private static final By NAME_INPUT = By.name("pwd");
    private static final By LOGIN_BUTTON = By.xpath("//button[text()='Войти в личный кабинет']");
    private static final By SEARCH_INPUT = By.xpath("//input[@name='q']");
    private static final By SEARCH_BUTTON = By.xpath("//input[@class='button_search']");

    public MainPage openPage() {
        driver.get("https://www.777555.by/");
        driver.manage().window().maximize();
        logger.info("Main page has been opened");
        return this;
    }

    public MainPage clickOnLoginSpan() {
        waitPresenceOfElementLocated(driver, LOGIN_SPAN);
        driver.findElement(LOGIN_SPAN).click();
        logger.info("Click on login span");
        return this;
    }

    public MainPage clickOnPersonalCabinetReference() {
        waitElementToBeClickable(driver, LOGIN_PERSONAL_CABINET_REFERENCE);
        driver.findElement(LOGIN_PERSONAL_CABINET_REFERENCE).click();
        logger.info("Click on personal cabinet reference");
        return this;
    }

    public MainPage inputName(String name) {
        waitPresenceOfElementLocated(driver, LOGIN_INPUT);
        driver.findElement(LOGIN_INPUT).sendKeys(name);
        logger.info("Input login");
        return this;
    }

    public MainPage inputPassword(String password) {
        waitPresenceOfElementLocated(driver, NAME_INPUT);
        driver.findElement(NAME_INPUT).sendKeys(password);
        logger.info("Input password");
        return this;
    }

    public PersonalCabinetPage clickOnLoginButton() {
        waitPresenceOfElementLocated(driver, LOGIN_BUTTON);
        driver.findElement(LOGIN_BUTTON).click();
        logger.info("Click on login button");
        return new PersonalCabinetPage(driver);
    }

    public MainPage inputProductIdInSearchInput(String productId) {
        waitPresenceOfElementLocated(driver, SEARCH_INPUT);
        logger.info("Input product ID in search field");
        driver.findElement(SEARCH_INPUT).sendKeys(productId);
        return this;
    }

    public ProductPage clickOnSearchButton() {
        waitElementToBeClickable(driver, SEARCH_BUTTON);
        driver.findElement(SEARCH_BUTTON).click();
        logger.info("Click on search button");
        return new ProductPage(driver);
    }
}
