package lesson3HW;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Summary---------------------------------
//Оформление заявки на подбор фрезы
//---Steps----------------------------------------------Expected result-----------------------------------
//1. Перейти по ссылке http://mi-tools.ru/===Отображается страница сайта http://mi-tools.ru/
//2. В шапке сайта клик по "Инструменты"===Переход в "Каталог инструментов для деревообработки" http://mi-tools.ru/tools
//3. В каталоге клик по кнопке "Подробнее" товара "Концевые фрезы"===Переход в каталог "Концевые фрезы" http://mi-tools.ru/tools/koncevye-frezy
//4. Клик по кнопке "Подобрать фрезу===Открывается форма "Оставьте заявку на подбор иеструмента"
//5. Заполнить форму валидными данными===Все поля заполнены
//6. Клик по кнопке "Подобрать инструмент"===Заявка успешно оформлена. Открывается страница http://mi-tools.ru/thankyou?sid=31043
//--------------------------------------------------------------------------------------------------------

public class HW_3_3 {
     static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://mi-tools.ru/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(@href, '/tools')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[contains(@href, '/tools/koncevye-frezy')])[4]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(),'Подобрать фрезу')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='edit-submitted-firstname--2']")).sendKeys("KKK");
        driver.findElement(By.xpath("//input[@id='edit-submitted-phone-main']")).sendKeys("+79998885544");
        driver.findElement(By.xpath("//input[@id='edit-submitted-e-mail-second']")).sendKeys("aaa@aa.com");
        driver.findElement(By.xpath("//input[@id='edit-submitted-city--2']")).sendKeys("СПБ");
        driver.findElement(By.xpath("//textarea[@id='edit-submitted-comment--2']")).sendKeys("ААА");
        driver.findElement(By.xpath("//input[@id='edit-webform-ajax-submit-19']")).click();


        Thread.sleep(999999999);
        driver.quit();
    }
}
