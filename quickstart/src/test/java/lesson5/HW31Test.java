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


import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import lesson6.ChoosingCity;
import lesson6.DefoStat;
import lesson6.SalonsTab;
import lesson7.CustomLoggerNew;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;


class HW31Test {
   DefoStat  defoStat;
   ChoosingCity choosingCity;
   SalonsTab salonsTab;
   WebDriver driver;
   WebDriverWait webDriverWait;
   Actions actions;

   private final static String DEFO_BASE_URL = "https://spb.defo.ru/";


    @BeforeAll
    static void registerDrivers() {WebDriverManager.chromedriver().setup();}

     @BeforeEach
     void setupDrivers() {
         //   driver = new ChromeDriver();
         driver = new EventFiringDecorator(new CustomLoggerNew()).decorate(new ChromeDriver());
         defoStat = new DefoStat(driver);
//         salonsTab = new SalonsTab(driver);
//         choosingCity = new ChoosingCity(driver);
         driver.get(DEFO_BASE_URL);
     }

    @Test
    @Description("Тест Покупки в один клик")
    @TmsLink("123")
    @Feature("Избранное")
    void SalonsPageTest() {
        new ChoosingCity(driver)
                .choosingСityActive()
                .choosingСity_SPB();
        new SalonsTab(driver)
                .salonsTabActive()
                .salonsMapActive()
                .yandexShopAdressMapActive();



    }

//        //Выбор города
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@href, '#')])[2]")));
//        driver.findElement(By.xpath("(//a[contains(@href, '#')])[2]")).click();
//        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Санкт-Петербург')]")));
//        driver.findElement(By.xpath("//a[contains(.,'Санкт-Петербург')]")).click();
//
//      //Вкладка салоны
//       webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Салоны')]")));
//       driver.findElement(By.xpath("//a[contains(.,'Салоны')]")).click();
//       webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Карта')]")));
//       driver.findElement(By.xpath("//a[contains(text(),'Карта')]")).click();
//      Assertions.assertEquals(driver.findElement(By.xpath("//div[@class='shop-adress__map shop-adress__content']"))
//              .isDisplayed(), true);


    @AfterEach
    void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
        Iterator<LogEntry> iterator = logs.iterator();

        while (iterator.hasNext()) {
            Allure.addAttachment("Элемент лога браузера", iterator.next().getMessage());
        }
        driver.quit();
    }
}


