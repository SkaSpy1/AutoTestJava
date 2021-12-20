package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DefoStat {


    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;


    public DefoStat(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);

    }
}
  // public static void cookie()  {
  //     Cookie cookie1 = new Cookie("carrotquest_hide_all_unread_popups", "true");
  //     Cookie cookie2 = new Cookie("carrotquest_hide_all_unread_popups", "true");
  //     Cookie cookie3 = new Cookie("carrotquest_session_started", "1");
  //     Cookie cookie4 = new Cookie("carrotquest_hide_all_unread_popups", "true");
  //     Cookie cookie5 = new Cookie("politika_41629", "Y");
  //     Cookie cookie6 = new Cookie("carrotquest_session", "7lidxe1hixt6nipclitadltow1nsd64f");
  //     Cookie cookie7 = new Cookie("_ct", "300000001270745122");
  //     Cookie cookie8 = new Cookie("_ct_client_global_id", "27026ac3-25f9-5831-b212-da795c5811f1");
  //     Cookie cookie9 = new Cookie("carrotquest_uid", "1071478000089826670");
  //     Cookie cookie10 = new Cookie("check_region_new", "Y");
  //     Cookie cookie11 = new Cookie("switch_region", "Y");
  //     Cookie cookie12 = new Cookie("check_region", "Y");
  //     Cookie cookie14 = new Cookie("current_domayn", "undefined");
  //     Cookie cookie15 = new Cookie("carrotquest_device_guid", "6207321d-ffb8-4f46-933d-55a7091d122c");
  //     Cookie cookie16 = new Cookie("_ct_client_global_id", "27026ac3-25f9-5831-b212-da795c5811f1");
  //     Cookie cookie17 = new Cookie("current_region", "41629");
  //     Cookie cookie18 = new Cookie("carrotquest_auth_token", "user.1071478000089826670.32033-0c1b99642a8db1aa0bd21e74fa.fe8c5d5307440853a8c89f189f5a3c89971543ca11be3382");



  //     driver.manage().addCookie(cookie1);
  //     driver.manage().addCookie(cookie2);
  //     driver.manage().addCookie(cookie3);
  //     driver.manage().addCookie(cookie4);
  //     driver.manage().addCookie(cookie5);
  //     driver.manage().addCookie(cookie6);
  //     driver.manage().addCookie(cookie7);
  //     driver.manage().addCookie(cookie8);
  //     driver.manage().addCookie(cookie9);
  //     driver.manage().addCookie(cookie10);
  //     driver.manage().addCookie(cookie11);
  //     driver.manage().addCookie(cookie12);
  //     driver.manage().addCookie(cookie14);
  //     driver.manage().addCookie(cookie15);
  //     driver.manage().addCookie(cookie16);
  //     driver.manage().addCookie(cookie17);
  //     driver.manage().addCookie(cookie18);

  //     driver.manage().getCookies();
  //     driver.navigate().refresh();
   //   }


//   public final static void registerDriver() {
//      WebDriverManager.chromedriver().setup();

//   }

//   public static void setupDriverCookie() {
//       driver = new ChromeDriver();
//       webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
//       actions = new Actions(driver);
//
//       cookie();
//   }


