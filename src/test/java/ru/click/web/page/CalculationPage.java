package ru.click.web.page;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class CalculationPage {

    public void openCalculationPage() {
        step("Открываем страницу Калькулятор партнёрского вознаграждения", () -> {
            open("https://click.ru/calc");
        });
    }

    public void fillCalculatorOfIncome() {
        step("Проверям заголовок страницы", () -> {
            $(".headline-pb").shouldHave(text("Калькулятор партнёрского вознаграждения"));
        });
        step("Вводим значения в поля Яндекс Директ, GoogleAds, ВКонтакте, Расширенный тариф, нажимаем Enter", () -> {
            $("[data-service=\"DIRECT\"]").setValue("5000");
            $("[data-service=\"ADWORDS\"]").setValue("6000");
            $("[data-service=\"VK\"]").setValue("6000");
            $("[data-service=\"ADVANCED\"]").setValue("6000").pressEnter();
        });
    }

    public void verifyCalculatorOfIncome() {
        step("Проверям что появилось окно с рассчитанной суммой заработка", () -> {
            $(".modal-v2__alert_type_success").shouldBe(Condition.visible);
        });
    }
}

