package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DiaryTest {  public static void main(String[] args) throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.get("https://diary.ru/user/login");
    WebElement loginFild=driver.findElement(By.xpath("//input[@id='loginform-username']"));
    loginFild.sendKeys("TestUser001");
    WebElement passwordFild=driver.findElement(By.xpath("//input[@id='loginform-password']"));
    passwordFild.sendKeys("m9X0yVI4yy");
  //   driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
 //   driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
  //  Thread.sleep(50000);
  //  driver.switchTo().parentFrame();
  //  driver.findElement(By.id("login_btn")).click();
    Cookie cookie= new Cookie("_identity_","52a501d485f6f55f333cc8278c01ba83f5f61015f2e4f0e00278c42aa5bcbe12a%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3560209%2C%22Sc9MboTdrygW8Rexi-9fVmnnYAYRuHMQ%22%2C2592000%5D%22%3B%7D");
    driver.manage().addCookie(cookie);
    driver.navigate().refresh();
    Thread.sleep(2000);
    String postTitle="test123123";
    driver.findElement(By.xpath("//a[@title='Новая запись']")).click();
    driver.findElement(By.id("postTitle")).sendKeys(postTitle);
    Thread.sleep(2000);
    WebDriverWait webDriverWaite=new WebDriverWait(driver, 10 );

  //  webDriverWaite.until(ExpectedCondition.u));    //ждём появление элемента
    driver.switchTo().frame(driver.findElement(By.id("message_ifr")));
    driver.findElement(By.id("tinymce")).sendKeys(postTitle);
    driver.switchTo().parentFrame();
    driver.findElement(By.id("rewrite")).click();

   driver.findElement(By.xpath(String.format("//a[text()='%s']/following-sibling::span//span[@class='i-cross']", postTitle))).click();

    Thread.sleep(50009);
    driver.quit();
 }
}
//https://diary.ru/user/login
//TestUser001
//m9X0yVI4yy
//giper83427@simdpi.com

//  xpath=//input[@id='loginform-username']  //id="loginform-username"
//  xpath=//input[@id='loginform-password']  //id="loginform-password"
//   //iframe[@title="reCAPTCHA"]
//    //div[@class="recaptcha-checkbox-border"]    xpath=//span[@id='recaptcha-anchor']/div
//  xpath=//form[@id='login-form']/button
// class="i-menu-newpost"
// 52a501d485f6f55f333cc8278c01ba83f5f61015f2e4f0e00278c42aa5bcbe12a%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3560209%2C%22Sc9MboTdrygW8Rexi-9fVmnnYAYRuHMQ%22%2C2592000%5D%22%3B%7D