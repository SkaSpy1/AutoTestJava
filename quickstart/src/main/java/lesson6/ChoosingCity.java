package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ChoosingCity extends DefoStat {
    public ChoosingCity(WebDriver driver) {
        super(driver);
    }

    private final static String choosingСityActiveLocatorXpath = "(//a[contains(@href, '#')])[2]";
    @FindBy(xpath = choosingСityActiveLocatorXpath)

    private WebElement choosingСityActiveXpath;

    @Step("Перейти в выбор города")

    public ChoosingCity choosingСityActive() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(choosingСityActiveLocatorXpath)));
        choosingСityActiveXpath.click();

        return this;
    }

    private final static String choosingСity_SPB_ActiveLocatorXpath = "//b[contains(.,'Санкт-Петербург')]";
    @FindBy(xpath = choosingСity_SPB_ActiveLocatorXpath)

    private WebElement choosingСity_SPB_Active;

    @Step("Выбрать город Санкт-Петербург")

    public ChoosingCity choosingСity_SPB() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(choosingСity_SPB_ActiveLocatorXpath)));
        choosingСity_SPB_Active.click();
        return this;
    }


}


//      webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[contains(@href, '#')])[2]")));
//              driver.findElement(By.xpath("(//a[contains(@href, '#')])[2]")).click();
//              webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Санкт-Петербург')]")));
//              driver.findElement(By.xpath("//a[contains(.,'Санкт-Петербург')]")).click();
