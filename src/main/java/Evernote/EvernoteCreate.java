package Evernote;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class EvernoteCreate {
    private static final String LOGIN_PAGE_URL = "https://evernote.com/intl/ru/";

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");
        options.addArguments("disable-popup-blocking");
        options.addArguments("--incognito");
//        options.addArguments("--headless");
        options.addArguments("start-maximized");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get(LOGIN_PAGE_URL);

        //Войти
        sleep(2000);
        driver.findElement(By.linkText("Войти")).click();

        //Логинимся

        sleep(2000);
        driver.findElement(By.cssSelector("#username")).sendKeys("kapihen@gmail.com");

        sleep(2000);
        driver.findElement(By.cssSelector("#loginButton")).click();

        sleep(2000);
        driver.findElement(By.cssSelector("#password")).sendKeys("KapiheN0515//");

        sleep(2000);
        driver.findElement(By.cssSelector("#loginButton")).click();


        System.out.println("Авторизация прошла успешно");

        // Добавляем новую заметку
        // Нажимаем кнопку "Новая заметка"

        sleep(2000);
        driver.findElement(By.id("qa-HOME_WIDGET_CONTROL_Notes_2|0_0|0_42YMZ3|13")).click();

        sleep(2000);
        //driver.findElement(By.id("en-note")).click();
        driver.findElement(By.xpath("xpath=//en-note/div")).click();
        //driver.findElement(By.cssSelector("#en-note")).click();
        driver.findElement(By.xpath("xpath=//en-note/div")).sendKeys("Я учусь");


//        sleep(2000);
//        driver.findElement(By.cssSelector("Ncwq8C9J471sPnkD9Zxv > FRFCJTQW7QQuwwHRg02f")).click();


        driver.close();
        driver.quit();
    }

}
