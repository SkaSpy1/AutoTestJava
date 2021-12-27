package lesson5;

//Summary---------------------------------
//Оформление заказа "купить в один клик" из вкладки избраное
//Steps-----------------------------------
//1. Перейти по ссылке https://defo.ru/--- Открывается страница https://defo.ru/
//2. В поле "хиты продаж" - клик по иконке звезды на первом товаре из списка---Товар добавлен в "Избраное"
//3. В футоре - клик по иконке звезды--- Переход на страницу "Избраное"
//4. Клик по кнопке "купить в один клик" на товаре--- Открывается форма оформления заказа
//5. Заполнить форму валидными данными --- форма принемает данные
//6. Клик по "Согласен с обработкой данных" --- Установлена "галочка"
//7. Клик по кнопке "оформить заказ" --- Появление всплывающего окна "Спасибо за покупку"
//8. Клик по крестику в всплывающем окне "Спасибо за покупку"--- Закрытие всплывающего окна

//Expected result------------------------------
//Заказ оформлен, появляется всплывающее окно "Спасибо за заказ"
//--------------------------------------------------------------------------------------


import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import lesson6.DefoStat;
import lesson6.Favorite;
import lesson6.FormBlock;
import lesson7.CustomLoggerNew;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;

@Story("Defo")
public class HW51Test {
    WebDriver driver;
    DefoStat defoStat;
//    FormBlock formBlock;
//    Favorite favorite;
//   EventFiringWebDriver eventFiringWebDriver;
//    WebDriverWait webDriverWait;

    private final static String DEFO_BASE_URL = "https://www.defo.ru/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDrivers() {
        //   driver = new ChromeDriver();
        driver = new EventFiringDecorator(new CustomLoggerNew()).decorate(new ChromeDriver());
        defoStat = new DefoStat(driver);
        //     formBlock = new FormBlock(driver);
        //     favorite = new Favorite(driver);
        driver.get(DEFO_BASE_URL);
    }

    @Test
    @Description("Тест Покупки в один клик")
    @TmsLink("123")
    @Feature("Избранное")
    void BuyOnClickTest() {
        new Favorite(driver)
                .favorActive()
                .spanFavorActive()
                .spanFavorActive()
                .buttonBuyOneClick();

        new FormBlock(driver)
                .formActive()
                .fillNameInput("Имя")
                .fillPhoneInput("999 9999999")
                .fillCommentInput("Спам тест коммент ")
                .clickFormAgreeCheckbox()
                .clickOrderButton()
                .clickCloseForm();
    }

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

//       //Добавление в "Избраное"
//      webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
//              ("//article[1]//button[contains(@data-action,'favorite')]")));
//      Thread.sleep(1000);
//      driver.findElement(By.xpath("//article[1]//button[contains(@data-action,'favorite')]")).click();
//      webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
//              (By.xpath("//a[@href='/personal/favorites/']/span[@class='qount']")));
//      driver.findElement(By.xpath("//a[@href='/personal/favorites/']/span[@class='qount']")).click();
//      webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
//              (By.xpath("//button[@data-action='buyoneclick']")));
//      driver.findElement(By.xpath("//button[@data-action='buyoneclick']")).click();


//       //заполнение формы
//       webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
//               (By.xpath("//div[@class='modalform active']")));
//       webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
//               (By.xpath("//div[@class='modalform active']//form//input[@name='name']")));
//       driver.findElement(By.xpath("//div[@class='modalform active']//form//input[@name='name']"))
//               .sendKeys("ПРИВЕТ DEFO");
//       driver.findElement(By.xpath("//div[@class='modalform active']//form//input[@name='phone']"))
//               .sendKeys("999 9999999");
//       driver.findElement(By.xpath("//div[@class='modalform active']//form//textarea[@name='comment']"))
//               .sendKeys("Спам тест");
//       driver.findElement(By.xpath("//div[@class='modalform active']//label[@class='form__agree-checkbox']")).click();
//       driver.findElement(By.xpath("//div[@class='modalform active']//form//button[.='Заказать']")).click();
//       driver.findElement(By.xpath("//div[@class='modalform active']//div")).click();