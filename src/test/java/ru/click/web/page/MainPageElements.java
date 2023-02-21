package ru.click.web.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class MainPageElements {

    private final SelenideElement header = $(".main-navbar__section_left"),
                                  footer = $(".footer"),
                                  regModal = $("#auth-tabs");

    public void openMainPage() {
        step("Открываем главную страницу", () -> {
            open("https://click.ru");
        });
    }

    static void clickRegButton() {
        step("Нажимаем на кнопку Регистрация", () -> {
            $(".header-auth").find(byText("Регистрация")).click();
        });
    }

    public void checkRegistrationModal() {
        clickRegButton();
        step("Проверям заголовки модального окна Регистрация", () -> {
            regModal.shouldHave(text("Вход"));
            regModal.shouldHave(text("Регистрация"));
            regModal.shouldHave(text("Демо"));
        });
    }

    public void switchToDemo() {
        clickRegButton();
        step("В модальном окне Регистрация, нажимаем на кнопку Демо", () -> {
            $("#auth-tabs").find(byText("Демо")).click();
        });
        step("Проверям наличие кнопки Войти в Демо-аккаунт", () -> {
            $("#auth-content-tab-demo").shouldHave(text("Войти в Демо-акккаунт"));
        });
    }

    public void switchToAutorization() {
        clickRegButton();
        step("В модальном окне Регистрация, нажимаем на кнопку Вход", () -> {
            $("#auth-tabs").find(byText("Вход")).click();
        });
        step("Провреям наличие кнопки Войти в систему", () -> {
            $("#login-btn").shouldHave(Condition.value("Войти в систему"));
        });
    }

    public void verifyMainPageCalc() {
        step("Заполняем поля для расчета", () -> {
            $("#clicksNum").setValue("5000");
            $("#costNum").setValue("100");
            $("#fraudNum").setValue("10");
        });
        step("Проверям значение в окне с результатом", () -> {
            $(".calculator-meaning-text").shouldHave(text("Экономия:\n" + "50 000\n" + "₽"));
        });
    }

    public void checkHeaderElements() {
        step("Проверям наличие разделов главного меню", () -> {
            header.shouldHave(text("Возможности"));
            header.shouldHave(text("Маркетплейс"));
            header.shouldHave(text("Обучение"));
            header.shouldHave(text("Помощь"));
            header.shouldHave(text("Блог"));
        });
    }

    public void checkFooterOptions() {
        step("Проверям наличие разделов в футере страницы", () -> {
            footer.shouldHave(text("Обучение"));
            footer.shouldHave(text("Блог Click.ru"));
            footer.shouldHave(text("Кешбэк"));
            footer.shouldHave(text("Справка"));
            footer.shouldHave(text("О компании"));
            footer.shouldHave(text("Поддержка"));
        });
    }
}
