package ru.click.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class MainPage {

    private final SelenideElement header = $(".main-navbar__section_left"),
                                  footer = $(".footer"),
                                  regModal = $("#auth-tabs"),
                                  clickCounter = $("#clicksNum"),
                                  costCounter = $("#costNum"),
                                  fraudCounter = $("#fraudNum"),
                                  economyAmount = $(".calculator-meaning-text");

    private final String economyAmountString = "Экономия:\n" + "50 000\n" + "₽";


    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://click.ru");
    }

    static void clickRegButton() {
        step("Нажимаем на кнопку Регистрация", () -> {
            $(".header-auth").find(byText("Регистрация")).click();
        });
    }

    public void checkRegistrationModal() {
        clickRegButton();
        step("Проверям заголовки модального окна Регистрация", () -> {
            regModal.shouldHave(
                    text("Вход"),
                    text("Регистрация"),
                    text("Демо"));
        });
    }

    public void switchToDemo() {
        clickRegButton();
        step("В модальном окне Регистрация, нажимаем на кнопку Демо", () -> {
            regModal.find(byText("Демо")).click();
        });
        step("Проверям наличие кнопки Войти в Демо-аккаунт", () -> {
            $("#auth-content-tab-demo").shouldHave(text("Войти в Демо-акккаунт"));
        });
    }

    public void switchToAutorization() {
        clickRegButton();
        step("В модальном окне Регистрация, нажимаем на кнопку Вход", () -> {
            regModal.find(byText("Вход")).click();
        });
        step("Провреям наличие кнопки Войти в систему", () -> {
            $("#login-btn").shouldHave(Condition.value("Войти в систему"));
        });
    }

    public void verifyMainPageCalc() {
        step("Заполняем поля для расчета", () -> {
            clickCounter.setValue("5000");
            costCounter.setValue("100");
            fraudCounter.setValue("10");
        });
        step("Проверям значение в окне с результатом", () -> {
            economyAmount.shouldHave(text(economyAmountString));
        });
    }

    public void checkHeaderElements() {
        step("Проверям наличие разделов главного меню", () -> {
            header.shouldHave(
                    text("Возможности"),
                    text("Маркетплейс"),
                    text("Обучение"),
                    text("Помощь"),
                    text("Блог"));
        });
    }

    public void checkFooterOptions() {
        step("Проверям наличие разделов в футере страницы", () -> {
            footer.shouldHave(
                    text("Обучение"),
                    text("Блог Click.ru"),
                    text("Кешбэк"),
                    text("Справка"),
                    text("О компании"),
                    text("Поддержка"));
        });
    }
}
