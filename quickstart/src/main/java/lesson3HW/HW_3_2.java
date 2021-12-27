package lesson3HW;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


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

     static void main(String[] args) throws InterruptedException {
         WebDriverManager.chromedriver().setup();
         WebDriver driver=new ChromeDriver();
         driver.get("https://spb.defo.ru");
//        setupDriverCookie();


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
 //     driver.navigate().refresh();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(.,'Сервис')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[text()='Как оплатить заказ']")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}