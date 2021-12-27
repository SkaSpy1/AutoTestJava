package lesson3HW;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


//-------- Перехода на страницу "Салоны" вкладка "Карта"------//
//-------- Без COOKIES-----//
//Ещё на сайте обнаружил баг, если во всплывающем окне нажать «ДА», сайт отправит на пустую страницу.
// В варианте с куки файлом ("HW_3_2" Где уже выбран город) всплывающего окна не будет.
/// Баг пофиксили

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



public class HW_3_1 {
    public static void main(String[] args) throws InterruptedException  {
      WebDriverManager.chromedriver().setup();
      WebDriver driver=new ChromeDriver();
      driver.get("https://spb.defo.ru");
   //     registerDriver();
     //   setupDriverCookie();


        Thread.sleep(4000);
        driver.findElement(By.xpath("(//a[contains(@href, '#')])[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//b[contains(.,'Санкт-Петербург')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(.,'Салоны')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Карта')]")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}