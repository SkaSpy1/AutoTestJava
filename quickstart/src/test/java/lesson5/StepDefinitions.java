package lesson5;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lesson8.Favorite;
import lesson8.FormBlock;


import static com.codeborne.selenide.Selenide.open;

public class StepDefinitions {


    @Given("Пользователь находится на главной странице")
    public void userHomePage() {
        open("https://www.defo.ru/");
        new Favorite()
                .favorActive()
                .spanFavorActive()
                .buttonBuyOneClick();


    }

    @When("Открывается форма заказа")
    public void clicRandomeProduct() {
        new FormBlock()
                .formActive();
    }

    @And("Заполнение формы")
    public void addingProductToFavorites() {
        new FormBlock()
                .fillNameInput("ыфвф")
                .fillPhoneInput("999 9999999")
                .fillCommentInput("аафываа")
                .clickFormAgreeCheckbox()
                .clickOrderButton();
    }

    @Then("Закрытие формы")
    public void productAddedToFavorites() {
        new FormBlock()
                .clickCloseForm();
    }
}
