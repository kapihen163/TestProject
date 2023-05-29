package Evernote;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class EvernoteRegistration {

    private static final String LOGIN_PAGE_URL = "https://evernote.com/intl/ru/";

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
//        options.addArguments("--headless");
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get(LOGIN_PAGE_URL);

        //Войти
        sleep(5000);
        driver.findElement(By.linkText("Войти")).click();

        //Логинимся

        sleep(2000);
        driver.findElement(By.cssSelector("#username")).sendKeys("kapihen@gmail.com");

        sleep(5000);
        driver.findElement(By.cssSelector("#loginButton")).click();

        sleep(2000);
        driver.findElement(By.cssSelector("#password")).sendKeys("KapiheN0515//");

        sleep(5000);
        driver.findElement(By.cssSelector("#loginButton")).click();


        System.out.println("Авторизация прошла успешно");
        driver.close();
        driver.quit();
    }
}



