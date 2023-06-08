package Lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class MainPageTest extends AbstractTest {

    @Test
    void Evernote1RegistrationTest() {
        Registration registration = new Registration(getWebDriver());
        registration.logIn();

        Assertions.assertTrue(getWebDriver().getCurrentUrl().contains("https://www.evernote.com/client/web?"));
    }

    @Test
    void Evernote2CreateTest() {
        Registration registration = new Registration(getWebDriver());
        registration.logIn();

        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        CreatePage createPage = new CreatePage(getWebDriver());
        createPage
                .clickCreateButton();
        Assertions.assertTrue(getWebDriver().getCurrentUrl().contains("https://www.evernote.com/client/web?_sourcePage"));
    }

    @Test
    void Evernote3DeletTest() {
        Registration registration = new Registration(getWebDriver());
        registration.logIn();

        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        DeletPage deletPage = new DeletPage(getWebDriver());
        deletPage
                .clickCreateNote()
                .clickOpenWindow()
                .clickDeletButton()
                .clickBasketButton()
                .clickClearBasketButton();
        Assertions.assertTrue(getWebDriver().getCurrentUrl().contains("Корзина пуста"));
    }

    @Test
    void Evernote4ExitTest() {

        Registration registration = new Registration(getWebDriver());
        registration.logIn();

        webDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        ExitPage exitPage = new ExitPage(getWebDriver());
        exitPage
                .clickAccountMailElement()
                .clickExitAccount();
        Assertions.assertTrue(true, "Вы вышли из Evernote.");
    }
}
