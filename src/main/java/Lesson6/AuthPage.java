package Lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthPage extends BaseView {
    @FindBy(id = "username")
    private WebElement inputLoginField;
    @FindBy(id = "password")
    private WebElement inputPasswordField;
    @FindBy(id = "loginButton")
    private WebElement loginButton;

    private final String login = "kapihen@gmail.com";
    private final String password = "KapiheN0515//";

    public AuthPage(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Enter login {login}")
    public AuthPage enterLogin(String login) {
        inputLoginField.sendKeys(login);
        return this;
    }

    @Step(value = "Enter password {password}")
    public AuthPage enterPassword(String password) {
        inputPasswordField.sendKeys(password);
        return this;
    }

    @Step(value = "Click login button")
    public AuthPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}
