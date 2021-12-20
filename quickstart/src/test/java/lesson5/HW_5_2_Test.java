package lesson5;
// Тест не дописан. не могу победить плашку о политике конф. (даже при помощи cookie)
// Выполню позже

import io.github.bonigarcia.wdm.WebDriverManager;
import lesson6.DefoStat;
import lesson6.FormBlock;
import lesson7.CustomLoggerNew;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class HW_5_2_Test  {
     WebDriver driver;
     DefoStat defoStat;
     FormBlock formBlock;
     WebDriver eventFiringWebDriver;
    WebDriverWait  webDriverWait;
      final static String DEFO_BASE_URL = "https://www.defo.ru/";

     @BeforeAll
     static void registerDriver() {
         WebDriverManager.chromedriver().setup();
     }

     @BeforeEach
     void setupDrivers() {
         driver = new EventFiringDecorator(new CustomLoggerNew()).decorate(new ChromeDriver());
         defoStat = new DefoStat(driver);
         formBlock = new FormBlock(driver);
         driver.get(DEFO_BASE_URL);
     }

 @Test
         void instaTest() throws InterruptedException {

             webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                     ("//div[@class='cookie-popup active']")));
             driver.findElement(By.xpath("//div[@class='cookie-popup active']/div[@class='cookie-popup__close']")).click();
             driver.findElement(By.xpath("//div[@class='cookie-popup active']/div[@class='cookie-popup__close']")).click();
             driver.findElement(By.xpath("//div[@class='cookie-popup active']/div[@class='cookie-popup__close']")).click();
             webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
                     ("//footer[@class='footer']//div[@class='footer__container footer__copyright-container container']")));
             driver.findElement(By.xpath("//footer[@class='footer']//div[@class='footer__container footer__copyright-container container']/section/a[@href='https://www.instagram.com/defo_office/']")).click();


             //div[@class='cookie-popup active']
//div[@class='cookie-popup active']/div[@class='cookie-popup__close']
//footer[@class='footer']//div[@class='footer__container footer__copyright-container container']
             //footer[@class='footer']//div[@class='footer__container footer__copyright-container container']/section/a[@href='https://www.instagram.com/defo_office/']


             //         driver.switchTo().window("https://www.instagram.com/defo_office/");
             //         driver.switchTo().window("https://defo.ru/");
             //         System.out.println("Old window title: " + driver.getTitle());

         }

         @AfterEach
         void tearDown() throws InterruptedException {
             LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
             Thread.sleep(5000);
             driver.quit();
         }
     }
