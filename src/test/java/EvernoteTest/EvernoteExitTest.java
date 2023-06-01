package EvernoteTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EvernoteExitTest {
    private static final String LOGIN_PAGE_URL = "https://evernote.com/intl/ru/";
    private static WebDriver driver;
    private static final String projectNameLog = "kapihen@gmail.com";
    private static final String projectPasswordLog = "KapiheN0515//";

    @BeforeAll
    static void setUpWebDriverManager() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    void myLoginEvo() {
        driver.get(LOGIN_PAGE_URL);
        assertEquals(driver.getCurrentUrl(), LOGIN_PAGE_URL);
        //Войти
        driver.findElement(By.linkText("Войти")).click();

        //Логинимся
//        driver.findElement(By.cssSelector("#username")).sendKeys("kapihen@gmail.com");
        WebElement projectNameLogEvo = driver.findElement(By.cssSelector("#username"));
        projectNameLogEvo.sendKeys(projectNameLog);
        assertEquals(projectNameLog, driver.findElement(By.cssSelector("#username")).getAttribute("value"));

        driver.findElement(By.cssSelector("#loginButton")).click();

        // driver.findElement(By.cssSelector("#password")).sendKeys("KapiheN0515//");
        WebElement projectPasswordLogEvo = driver.findElement(By.cssSelector("#password"));
        projectPasswordLogEvo.sendKeys(projectPasswordLog);
        assertEquals(projectPasswordLog, driver.findElement(By.cssSelector("#password")).getAttribute("value"));

        driver.findElement(By.cssSelector("#loginButton")).click();

        // Выходим из аккаунта
        driver.findElement(By.className("mjp8WyYQODySClV2byHt")).click();
        //нажимаем кнопку Завершить сеанс как kapihen@gmail.com
        driver.findElement(By.id("qa-ACCOUNT_DROPDOWN_LOGOUT")).click();


    }

    @AfterEach
    void closeDriver() {
        driver.close();
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
    }
}
