package lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Favorite {

    private SelenideElement xpathfavorActive = $(By.xpath("//article[1]//button[contains(@data-action,'favorite')]"));

    @Step("Найти активный элемент")
    public Favorite favorActive() {
        xpathfavorActive.click();
        return this;
    }

    private SelenideElement xpathSpanfavorActive = $(By.xpath("//a[@href='/personal/favorites/']/span[@class='qount']"));

    @Step("Span Favorite")
    public Favorite spanFavorActive() {
        xpathSpanfavorActive.click();
        return this;
    }


    private SelenideElement xpathBuyOneClick = $(By.xpath("//button[@data-action='buyoneclick']"));

    @Step("Нажать 'Купить в один клик'")
    public Favorite buttonBuyOneClick() {
        xpathBuyOneClick.click();
        return this;
    }

}
