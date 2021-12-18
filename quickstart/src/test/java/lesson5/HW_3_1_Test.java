package lesson5;

//-------- Перехода на страницу "Салоны" вкладка "Карта"------//
//-------- Без COOKIES-----//
//Ещё на сайте обнаружил баг, если во всплывающем окне нажать «ДА», сайт отправит на пустую страницу.
// В варианте с куки файлом ("HW_3_2" Где уже выбран город) всплывающего окна не будет.

//Summary----------------------------
//Перехода на страницу "Салоны" вкладка "Карта"
//Steps------------------------------
//1. Перейти по ссылке https://spb.defo.ru/
//2. Во всплывающем окне "ВАШ ГОРОД - ?" клик по "ВЫБРАТЬ ДРУГОЙ"
//3  Выбрать город "Санкт-Петербург"
//4. В шапке клик по вкладке «Салоны»
//5. Клик по вкладке «КАРТА»
//Expected result----------------------
//Открывается страница https://spb.defo.ru/salons/ с элементами yandex map


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static lesson5.DefoStat.*;

public class HW_3_1_Test {
//    WebDriver driver;
 //   WebDriverWait webDriverWait;
  //  Actions actions;
 //   private final static String DEFO_BASE_URL = "https://www.defo.ru/";

    @BeforeAll
    static void registerDrivers() {
        registerDriver();
    }

    @BeforeEach
    void setupDrivers() {
        setupDriver();
//    void setupDriver() {
//        driver = new ChromeDriver();
//        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        actions = new Actions(driver);
//        driver.get(DEFO_BASE_URL);
//    }
    }
    @Test
    void SalonsPageTest() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@href, '#')])[2]")));
        driver.findElement(By.xpath("(//a[contains(@href, '#')])[2]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Санкт-Петербург')]")));
        driver.findElement(By.xpath("//a[contains(.,'Санкт-Петербург')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Салоны')]")));
        driver.findElement(By.xpath("//a[contains(.,'Салоны')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Карта')]")));
        driver.findElement(By.xpath("//a[contains(text(),'Карта')]")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//div[@class='shop-adress__map shop-adress__content']"))
                .isDisplayed(), true);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
