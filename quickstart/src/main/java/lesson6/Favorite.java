package lesson6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Favorite extends DefoStat {
    public Favorite(WebDriver driver) {
        super(driver);
    }

    private final static String favoriteActiveLocatorXpath = "//article[1]//button[contains(@data-action,'favorite')]";
    @FindBy(xpath = favoriteActiveLocatorXpath)

    private WebElement xpathfavorActive;

    @Step("Найти активный элемент")

    public Favorite favorActive() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(favoriteActiveLocatorXpath)));
        xpathfavorActive.click();
        return this;
    }

    private final static String spanFavoriteActiveLocatorXpath = "//a[@href='/personal/favorites/']/span[@class='qount']";
    @FindBy(xpath = spanFavoriteActiveLocatorXpath)

    private WebElement xpathSpanfavorActive;

    @Step("Span Favorite")

    public Favorite spanFavorActive() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(spanFavoriteActiveLocatorXpath)));
        xpathSpanfavorActive.click();
        return this;
    }

    private final static String buyOneClickActiveLocatorXpath = "//button[@data-action='buyoneclick']";
    @FindBy(xpath = buyOneClickActiveLocatorXpath)

    private WebElement xpathBuyOneClick;

    @Step("Нажать 'Купить в один клик'")

    public Favorite buttonBuyOneClick() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(buyOneClickActiveLocatorXpath)));
        xpathBuyOneClick.click();
        return this;
    }


}


//    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
//            ("//article[1]//button[contains(@data-action,'favorite')]")));
//            Thread.sleep(1000);
//            driver.findElement(By.xpath("//article[1]//button[contains(@data-action,'favorite')]")).click();
//            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
//            (By.xpath("//a[@href='/personal/favorites/']/span[@class='qount']")));
//            driver.findElement(By.xpath("//a[@href='/personal/favorites/']/span[@class='qount']")).click();
//            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
//            (By.xpath("//button[@data-action='buyoneclick']")));
//            driver.findElement(By.xpath("//button[@data-action='buyoneclick']")).click();
