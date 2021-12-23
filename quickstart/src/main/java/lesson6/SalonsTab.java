package lesson6;

import io.qameta.allure.Step;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SalonsTab extends DefoStat {
    public SalonsTab(WebDriver driver) {
        super(driver);
    }

    private final static String salonsTabActiveLocatorXpath = "//a[contains(.,'Салоны')]";
    @FindBy(xpath = salonsTabActiveLocatorXpath)

    private WebElement salonsTabActiveXpath;

    @Step("Перейти в вкладку 'Салоны'")

    public SalonsTab salonsTabActive() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(salonsTabActiveLocatorXpath)));
        salonsTabActiveXpath.click();

        return this;
    }

    private final static String salonsMapActiveLocatorXpath = "//a[contains(text(),'Карта')]";
    @FindBy(xpath = salonsMapActiveLocatorXpath)

    private WebElement salonsMapActiveXpath;

    @Step("Перейти в вкладку 'Карта'")

    public SalonsTab salonsMapActive() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(salonsMapActiveLocatorXpath)));
        salonsMapActiveXpath.click();

        return this;
    }

    private final static String yandexShopAdressMapActiveLocatorXpath = "//div[@class='shop-adress__map shop-adress__content']";
    @FindBy(xpath = yandexShopAdressMapActiveLocatorXpath)

    private WebElement yandexShopAdressActiveXpath;

    @Step("Отображение салонов на Yandex Map")

    public SalonsTab yandexShopAdressMapActive() {

        yandexShopAdressActiveXpath.isDisplayed();
        return this;
    }


}


//       webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Салоны')]")));
//       driver.findElement(By.xpath("//a[contains(.,'Салоны')]")).click();
//       webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Карта')]")));
//       driver.findElement(By.xpath("//a[contains(text(),'Карта')]")).click();
//       Assertions.assertEquals(driver.findElement(By.xpath("//div[@class='shop-adress__map shop-adress__content']"))
//               .isDisplayed(), true);