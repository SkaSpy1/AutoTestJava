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


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static lesson5.DefoStat.*;

public class HW_5_1_Test {


    @BeforeAll
    static void registerDrivers() {
        registerDriver();

    }

    @BeforeEach
    void setupDrivers() {
        setupDriver();
    }

    @Test
    void BuyOnClickTest() {


        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                ("//article[1]//button[contains(@data-action,'favorite')]")));
        driver.findElement(By.xpath("//article[1]//button[contains(@data-action,'favorite')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//a[@href='/personal/favorites/']/span[@class='qount']")));
        driver.findElement(By.xpath("//a[@href='/personal/favorites/']/span[@class='qount']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//button[@data-action='buyoneclick']")));
        driver.findElement(By.xpath("//button[@data-action='buyoneclick']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class='modalform active']")));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class='modalform active']//form//input[@name='name']")));
        driver.findElement(By.xpath("//div[@class='modalform active']//form//input[@name='name']"))
                .sendKeys("ПРИВЕТ DEFO");
        driver.findElement(By.xpath("//div[@class='modalform active']//form//input[@name='phone']"))
                .sendKeys("999 9999999");
        driver.findElement(By.xpath("//div[@class='modalform active']//form//textarea[@name='comment']"))
                .sendKeys("Спам тест");
        driver.findElement(By.xpath("//div[@class='modalform active']//label[@class='form__agree-checkbox']")).click();
        driver.findElement(By.xpath("//div[@class='modalform active']//form//button[.='Заказать']")).click();
        driver.findElement(By.xpath("//div[@class='modalform active']//div")).click();


    }

    @AfterEach
    void
    tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}

