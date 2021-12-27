package lesson8;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FormBlock {

    private SelenideElement xpathformActive = $(By.xpath("//div[@class='modalform active']"));

    @Step("Найти активный элемент")
    public FormBlock formActive() {
        return this;
    }

    private SelenideElement nameInput = $(By.xpath("//div[@class='modalform active']//form//input[@name='name']"));

    @Step("Ввести имя")
    public FormBlock fillNameInput(String name) {
        nameInput.sendKeys(name);
        return this;
    }

    private SelenideElement phoneInput = $(By.xpath("//div[@class='modalform active']//form//input[@name='phone']"));

    @Step("Ввести телефон")
    public FormBlock fillPhoneInput(String phone) {
        phoneInput.sendKeys(phone);
        return this;
    }


    private SelenideElement commentInput = $(By.xpath("//div[@class='modalform active']//form//textarea[@name='comment']"));

    @Step("Ввести коммент")
    public FormBlock fillCommentInput(String comment) {
        commentInput.sendKeys(comment);
        return this;
    }


    private SelenideElement formAgreeCheckbox = $(By.xpath("//div[@class='modalform active']//label[@class='form__agree-checkbox']"));

    @Step("Checkbox политики")
    public FormBlock clickFormAgreeCheckbox() {
        formAgreeCheckbox.click();
        return this;
    }


    private SelenideElement orderButton = $(By.xpath("//div[@class='modalform active']//form//button[.='Заказать']"));

    @Step("Кнопка Заказать")
    public FormBlock clickOrderButton() {
        orderButton.click();
        return this;
    }


    private SelenideElement closeForm = $(By.xpath("//div[@class='modalform active']//div"));

    @Step("Закрыть форму")
    public FormBlock clickCloseForm() {
        closeForm.click();
        return this;
    }
}
