package lesson6;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class FormBlock extends DefoStat {
    public FormBlock(WebDriver driver) {
        super(driver);
    }

//    private List<WebElement> testElement;


    private final static String formActiveLocatorXpath = "//div[@class='modalform active']";
    @FindBy(xpath = formActiveLocatorXpath)

    private WebElement xpathformActive;

    @Step("Найти активный элемент")

    public FormBlock formActive() {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(formActiveLocatorXpath)));
        return this;
    }


    private final static String nameInputLocatorXpath = "//div[@class='modalform active']//form//input[@name='name']";
    @FindBy(xpath = nameInputLocatorXpath)
    private WebElement nameInput;

    @Step("Ввести имя")
    public FormBlock fillNameInput(String name) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(nameInputLocatorXpath)));
        nameInput.sendKeys(name);
        return this;
    }


    private final static String phoneInputLocatorXpath = "//div[@class='modalform active']//form//input[@name='phone']";
    @FindBy(xpath = phoneInputLocatorXpath)
    private WebElement phoneInput;

    @Step("Ввести телефон")
    public FormBlock fillPhoneInput(String phone) {
        driver.findElement(By.xpath(phoneInputLocatorXpath));
        phoneInput.sendKeys(phone);
        return this;
    }

    private final static String commentInputLocatorXpath = "//div[@class='modalform active']//form//textarea[@name='comment']";
    @FindBy(xpath = commentInputLocatorXpath)
    private WebElement commentInput;

    @Step("Ввести коммент")
    public FormBlock fillCommentInput(String comment) {
        driver.findElement(By.xpath(commentInputLocatorXpath));
        commentInput.sendKeys(comment);
        return this;
    }

    private final static String formAgreeCheckboxLocatorXpath = "//div[@class='modalform active']//label[@class='form__agree-checkbox']";
    @FindBy(xpath = formAgreeCheckboxLocatorXpath)
    private WebElement formAgreeCheckbox;

    @Step("Checkbox политики")
    public FormBlock clickFormAgreeCheckbox() {
        driver.findElement(By.xpath(formAgreeCheckboxLocatorXpath));
        formAgreeCheckbox.click();
        return this;
    }

    private final static String orderButtonLocatorXpath = "//div[@class='modalform active']//form//button[.='Заказать']";
    @FindBy(xpath = orderButtonLocatorXpath)
    private WebElement orderButton;

    @Step("Кнопка Заказать")
    public FormBlock clickOrderButton() {
        driver.findElement(By.xpath(orderButtonLocatorXpath));
        orderButton.click();
        return this;
    }

    private final static String closeFormLocatorXpath = "//div[@class='modalform active']//div";
    @FindBy(xpath = closeFormLocatorXpath)
    private WebElement closeForm;

    @Step("Закрыть форму")
    public FormBlock clickCloseForm() {
        driver.findElement(By.xpath(closeFormLocatorXpath));
        closeForm.click();
        return this;
    }


}


//       //заполнение формы
//       webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
//               (By.xpath("//div[@class='modalform active']")));
//       webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
//               (By.xpath("//div[@class='modalform active']//form//input[@name='name']")));
//       driver.findElement(By.xpath("//div[@class='modalform active']//form//input[@name='name']"))
//               .sendKeys("ИМЯ");
//       driver.findElement(By.xpath("//div[@class='modalform active']//form//input[@name='phone']"))
//               .sendKeys("999 9999999");
//       driver.findElement(By.xpath("//div[@class='modalform active']//form//textarea[@name='comment']"))
//               .sendKeys("Спам тест");
//       driver.findElement(By.xpath("//div[@class='modalform active']//label[@class='form__agree-checkbox']")).click();
//       driver.findElement(By.xpath("//div[@class='modalform active']//form//button[.='Заказать']")).click();
//       driver.findElement(By.xpath("//div[@class='modalform active']//div")).click();