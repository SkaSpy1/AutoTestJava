package lesson3HW;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


//Summary---------------------------------
//Отображение страницы «Как оплатить заказ»
//Steps-----------------------------------
//1. Перейти по ссылке https://spb.defo.ru/
//2. Использовать cookies: "_ct_client_global_id","d3745c9a-f8d1-57ba-9771-ee6b930405f1"
//3. В шапке клик по вкладке «Сервис»
//4. Клик в область «Как оплатить заказ»
//Expected result------------------------------
//Открывается страница https://spb.defo.ru/support/kak-oplatit-zakaz/
//--------------------------------------------------------------------------------------

public class HW_3_2 {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://spb.defo.ru");
        Cookie cookie=new Cookie("_ct_client_global_id","d3745c9a-f8d1-57ba-9771-ee6b930405f1");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(.,'Сервис')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='Как оплатить заказ']")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}