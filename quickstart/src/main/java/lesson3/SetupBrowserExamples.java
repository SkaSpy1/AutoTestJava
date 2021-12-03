package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class SetupBrowserExamples {
    public static void main (String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        WebDriver driver=new ChromeDriver(options);
        // options.addArguments("--headless");
         options.addArguments("--disable-notification");
        //ниже. обход бота
        options.addArguments("user-agent=Googlebot/2.1 (=http://www.google.com/bot.html)");
        driver.get("http://google.com");
        Thread.sleep(500);
        //  driver.quit();
        ((JavascriptExecutor)driver).executeScript("widow.open()");
        List<String>tabs=new ArrayList<>(driver.getWindowHandles());
        Thread.sleep(3000);
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(3000);
        driver.quit();
    }
}
