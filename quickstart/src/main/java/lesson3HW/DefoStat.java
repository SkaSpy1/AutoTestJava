package lesson3HW;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DefoStat {

    public static WebDriver driver;
    public static WebDriverWait webDriverWait;
    public static Actions actions;
    public final static String DEFO_BASE_URL = "https://www.defo.ru/";
    public static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }
    public static void setupDriverCookie() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(DEFO_BASE_URL);
        cookie();
    }
    public static void setupDriver(){
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(DEFO_BASE_URL);
    }

    public static void cookie() {
        Cookie cookie1 = new Cookie("_ct_client_global_id", "d3745c9a-f8d1-57ba-9771-ee6b930405f1");
        Cookie cookie2 = new Cookie("current_region", "41629");
        Cookie cookie3 = new Cookie("check_region", "Y");
        Cookie cookie4 = new Cookie("switch_region", "Y");
        Cookie cookie5 = new Cookie("check_region_new", "Y");



        driver.manage().addCookie(cookie1);
        driver.manage().addCookie(cookie2);
        driver.manage().addCookie(cookie3);
        driver.manage().addCookie(cookie4);
        driver.manage().addCookie(cookie5);
        driver.manage().getCookies();
        driver.navigate().refresh();


    }}




