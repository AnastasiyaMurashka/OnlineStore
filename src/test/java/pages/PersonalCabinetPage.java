package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static util.MethodWait.*;

public class PersonalCabinetPage extends AbstractPage {

    public PersonalCabinetPage(WebDriver driver) {
        super(driver);
    }

    public static final By PERSONAL_CABINET_TITLE = By.tagName("h1");

    public String getTextFromPersonalCabinetTitle() {
        waitPresenceOfElementLocated(driver, PERSONAL_CABINET_TITLE);
        return driver.findElement(PERSONAL_CABINET_TITLE).getText();
    }
}
