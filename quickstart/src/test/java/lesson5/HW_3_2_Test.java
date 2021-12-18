package lesson5;
////В прошлом ДЗ на сайте был баг с присваиванием локации пользователю.
/// После моего баг репорта админам сайта, всё починили, и добавили 4(!!!) дополнительные проверки по cookie

//Summary---------------------------------
//Отображение страницы «Как оплатить заказ» с вариантами оплаты.
//Steps-----------------------------------
//1. Перейти по ссылке https://spb.defo.ru/
//2. Использовать cookies:
//("_ct_client_global_id", "04bc7b01-089e-534c-a1a9-30c5ddb532d9");
//("current_region", "41629");
//("check_region", "Y");
//("switch_region", "Y");
//("check_region_new", "Y");
//3. В шапке клик по вкладке «Сервис»
//4. Клик в область «Как оплатить заказ»  --- Отображение страницы «Как оплатить заказ» с вариантами оплаты.
//Expected result------------------------------
//Открывается страница https://spb.defo.ru/support/kak-oplatit-zakaz/ с вариантами оплаты.
//--------------------------------------------------------------------------------------

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static lesson5.DefoStat.*;

public class HW_3_2_Test {
//   WebDriver driver;
//   WebDriverWait webDriverWait;
//  Actions actions;
//    private final static String DEFO_BASE_URL = "https://www.defo.ru/";
    @BeforeAll
    static void registerDrivers() {
        registerDriver();
    }

    @BeforeEach
    void setupDriver() {
        setupDriverCookie();
//      driver = new ChromeDriver();
//      webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
//      actions = new Actions(driver);
//      driver.get(DEFO_BASE_URL);
//      cookie();
    }

    @Test
    void PayPageTest() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Сервис')]")));
        driver.findElement(By.xpath("//a[contains(.,'Сервис')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Как оплатить заказ']")));
        driver.findElement(By.xpath("//div[text()='Как оплатить заказ']")).click();
        Assertions.assertTrue(driver.findElement(By.xpath("//ul[@class='howto-pay__list']"))
                .isDisplayed());


    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    // void cookie() {
    //     Cookie cookie = new Cookie("_ct_client_global_id", "d3745c9a-f8d1-57ba-9771-ee6b930405f1");
    //     Cookie cookie2 = new Cookie("current_region", "41629");
    //     Cookie cookie3 = new Cookie("check_region", "Y");
    //     Cookie cookie4 = new Cookie("switch_region", "Y");
    //     Cookie cookie5 = new Cookie("check_region_new", "Y");

    //     driver.manage().addCookie(cookie);
    //     driver.manage().addCookie(cookie2);
    //     driver.manage().addCookie(cookie3);
    //     driver.manage().addCookie(cookie4);
    //     driver.manage().addCookie(cookie5);
    //     driver.manage().getCookies();
    //     driver.navigate().refresh();

}
