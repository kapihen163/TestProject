package Evernote;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class EvernoteDelet {

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

        //удаляем созданную заметку

        //с начала создаем новую заметку
        sleep(2000);
        driver.findElement(By.id("qa-HOME_WIDGET_CONTROL_Notes_2|0_0|0_42YMZ3|13")).click();

        // в правом верхнем углу открываем всплывающее меню
        driver.findElement(By.id("qa-NOTE_ACTIONS")).click();
        // ждем 3 сек и нажимаем на кнопку Удалить
        sleep(3000);
        driver.findElement(By.id("qa-ACTION_DELETE")).click();

        //заходим в корзину
        driver.findElement(By.linkText("Корзина")).click();
        // очищаем корзину
        driver.findElement(By.id("qa-SPACE_VIEW_ACTIONS_HEADER")).click();



        driver.close();
        driver.quit();


    }
}
