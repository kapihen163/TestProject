package Lesson6;

import org.openqa.selenium.WebDriver;

public class Registration extends BaseView {
    public Registration(WebDriver driver) {
        super(driver);
    }

    public void logIn() {
        HomePage homePage = new HomePage(getDriver());
        homePage.clickOnButton();

        AuthPage authPage = new AuthPage(getDriver());
        authPage
                .clickLoginButton()
                .enterLogin(Values.STUDENT_LOGIN)
                .clickLoginButton()
                .enterPassword(Values.STUDENT_PASSWORD)
                .clickLoginButton();
    }
}
