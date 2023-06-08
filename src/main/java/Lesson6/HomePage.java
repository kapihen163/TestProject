package Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private final WebDriver driver;

    @FindBy(linkText = "Войти")
    private WebElement loginButtonHeader;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getLoginButtonHeader() {
        return loginButtonHeader;
    }

    public AuthPage clickOnButton() {
        getLoginButtonHeader().click();
        return new AuthPage(driver);
    }
}
