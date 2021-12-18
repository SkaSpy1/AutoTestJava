package lesson5;
// Тест не дописан. не могу победить плашку о политике конф. (даже при помощи cookie)
// Выполню позже

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static lesson5.DefoStat.*;


public class HW_5_2_Test {


    @BeforeAll
    static void registerDrivers() {
        registerDriver();

    }

    @BeforeEach
    void setupDrivers() {
        setupDriverCookie();
    }

        @Test
        public void someSimpleTest() {
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
    void
    tearDown() throws InterruptedException {
        Thread.sleep(500000);
        driver.quit();
    }
    }
