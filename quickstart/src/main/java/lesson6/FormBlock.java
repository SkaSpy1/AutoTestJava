package lesson6;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FormBlock extends DefoStat {
    public FormBlock(WebDriver driver) {
        super(driver);
    }


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
    @FindBy(xpath = nameInputLocatorXpath )
    private WebElement nameInput;
    @Step("Ввести имя")
    public FormBlock fillNameInput(String name) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(nameInputLocatorXpath)));
        nameInput.sendKeys(name);
        return this;
    }



    private final static String phoneInputLocatorXpath = "//div[@class='modalform active']//form//input[@name='phone']";
    @FindBy(xpath = phoneInputLocatorXpath )
    private WebElement phoneInput;

    public FormBlock fillPhoneInput(String phone) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(phoneInputLocatorXpath)));
        phoneInput.sendKeys(phone);
        return this;
    }

    private final static String commentInputLocatorXpath = "//div[@class='modalform active']//form//textarea[@name='comment']";
    @FindBy(xpath = commentInputLocatorXpath )
    private WebElement commentInput;

    public FormBlock fillCommentInput(String comment) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(commentInputLocatorXpath)));
        commentInput.sendKeys(comment);
        return this;
    }



}






//       //заполнение формы
//       webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
//               (By.xpath("//div[@class='modalform active']")));
//       webDriverWait.until(ExpectedConditions.visibilityOfElementLocated
//               (By.xpath("//div[@class='modalform active']//form//input[@name='name']")));
//       driver.findElement(By.xpath("//div[@class='modalform active']//form//input[@name='name']"))
//               .sendKeys("ПРИВЕТ DEFO");
//       driver.findElement(By.xpath("//div[@class='modalform active']//form//input[@name='phone']"))
//               .sendKeys("999 9999999");
//       driver.findElement(By.xpath("//div[@class='modalform active']//form//textarea[@name='comment']"))
//               .sendKeys("Спам тест");
//       driver.findElement(By.xpath("//div[@class='modalform active']//label[@class='form__agree-checkbox']")).click();
//       driver.findElement(By.xpath("//div[@class='modalform active']//form//button[.='Заказать']")).click();
//       driver.findElement(By.xpath("//div[@class='modalform active']//div")).click();