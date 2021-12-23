package lesson5;
//Summary---------------------------------
//Оформление заявки на подбор фрезы
//---Steps----------------------------------------------Expected result-----------------------------------
//1. Перейти по ссылке http://mi-tools.ru/===Отображается страница сайта http://mi-tools.ru/
//2. В шапке сайта клик по "Инструменты"===Переход в "Каталог инструментов для деревообработки" http://mi-tools.ru/tools
//3. В каталоге клик по кнопке "Подробнее" товара "Концевые фрезы"===Переход в каталог "Концевые фрезы" http://mi-tools.ru/tools/koncevye-frezy
//4. Клик по кнопке "Подобрать фрезу===Открывается форма "Оставьте заявку на подбор иеструмента"
//5. Заполнить форму валидными данными===Все поля заполнены
//6. Клик по кнопке "Подобрать инструмент"===Заявка успешно оформлена. Открывается страница http://mi-tools.ru/thankyou?sid=31043
//--------------------------------------------------------------------------------------------------------

//      public static void main(String[] args) throws InterruptedException {
//      WebDriverManager.chromedriver().setup();
//      WebDriver driver = new ChromeDriver();
//      driver.get("http://mi-tools.ru/");
//      Thread.sleep(1000);
//      driver.findElement(By.xpath("//a[contains(@href, '/tools')]")).click();
//      Thread.sleep(2000);
//      driver.findElement(By.xpath("(//a[contains(@href, '/tools/koncevye-frezy')])[4]")).click();
//      Thread.sleep(2000);
//      driver.findElement(By.xpath("//a[contains(text(),'Подобрать фрезу')]")).click();
//      Thread.sleep(1000);
//      driver.findElement(By.xpath("//input[@id='edit-submitted-firstname--2']")).sendKeys("KKK");
//      driver.findElement(By.xpath("//input[@id='edit-submitted-phone-main']")).sendKeys("+79998885544");
//      driver.findElement(By.xpath("//input[@id='edit-submitted-e-mail-second']")).sendKeys("aaa@aa.com");
//      driver.findElement(By.xpath("//input[@id='edit-submitted-city--2']")).sendKeys("СПБ");
//      driver.findElement(By.xpath("//textarea[@id='edit-submitted-comment--2']")).sendKeys("ААА");
//      driver.findElement(By.xpath("//input[@id='edit-webform-ajax-submit-19']")).click();

//      Thread.sleep(50000);
//      driver.quit();

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HW33Test {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final static String MITOOLS_BASE_URL = "http://mi-tools.ru/";


    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(MITOOLS_BASE_URL);

    }

    @Test
    void ApplicationForSelectionTest() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href, '/tools')]")));
        driver.findElement(By.xpath("//a[contains(@href, '/tools')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@href, '/tools/koncevye-frezy')])[4]")));
        driver.findElement(By.xpath("(//a[contains(@href, '/tools/koncevye-frezy')])[4]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Подобрать фрезу')]")));
        driver.findElement(By.xpath("//a[contains(text(),'Подобрать фрезу')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='edit-submitted-firstname--2']")));
        driver.findElement(By.xpath("//input[@id='edit-submitted-firstname--2']")).sendKeys("KKK");
        driver.findElement(By.xpath("//input[@id='edit-submitted-phone-main']")).sendKeys("+79998885544");
        driver.findElement(By.xpath("//input[@id='edit-submitted-e-mail-second']")).sendKeys("aaa@aa.com");
        driver.findElement(By.xpath("//input[@id='edit-submitted-city--2']")).sendKeys("SPB");
        driver.findElement(By.xpath("//textarea[@id='edit-submitted-comment--2']")).sendKeys("Поднимите зарплату рабочим");
        driver.findElement(By.xpath("//input[@id='edit-webform-ajax-submit-19']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));
        Assertions.assertTrue(driver.findElement(By.id("content"))
                .isDisplayed());


    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }


}

