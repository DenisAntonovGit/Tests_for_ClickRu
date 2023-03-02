package ru.click.web.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.click.web.page.CalculationPage;

@Tag("WEB UI")
@Owner("antonovdenis")
public class MainPageTest extends TestBase{


    CalculationPage calcPage = new CalculationPage();

    @Test
    @DisplayName("Проверка работы кнопки регистрации на главной странице")
    @Feature("Модальное окно регистрации")
    @Story("Навигация по главной странице")
    public void openRegistrationModal() {
        mainPage.checkRegistrationModal();
    }

    @Test
    @DisplayName("Проверка переключения на раздел Демо в модальном окне регистрации")
    @Feature("Модальное окно регистрации")
    @Story("Навигация по главной странице")
    public void switchToDemoOnRegistrationModal() {
        mainPage.switchToDemo();
    }

    @Test
    @DisplayName("Проверка переключения на раздел авторизации в модальном окне регистрации")
    @Feature("Модальное окно регистрации")
    @Story("Навигация по главной странице")
    public void switchToAutorizationOnRegistrationModal() {
        mainPage.switchToAutorization();
    }

//    В этом поле на сайте есть баг, некорректно рассчитывающий сумму при удалении
//    значений из полей ввода! TODO Зафиксировать в Jira
    @Test
    @DisplayName("Проверка работы калькулятора экономии на главной странице")
    @Feature("Калькулятор экономии на главное странице")
    @Story("Работа с калькулятором на главной странице")
    public void verifyEffectiveOfClickingCalc() {
        mainPage.verifyMainPageCalc();
    }

    @Test
    @DisplayName("Проверка работы калькулятора партнёрского вознаграждения")
    @Feature("Калькулятор парнтнёрского вознаграждения")
    @Story("Работа с калькулятором партнёрского вознаграждения")
    public void calculatorOfIncome() {
        calcPage.openCalculationPage();
        calcPage.fillCalculatorOfIncome();
        calcPage.verifyCalculatorOfIncome();
    }

    @Test
    @DisplayName("Проверка элементов главного меню")
    @Feature("Главное меню")
    @Story("Навигация по главной странице")
    public void checkHeaderMenu() {
        mainPage.checkHeaderElements();
    }

    @Test
    @DisplayName("Проверка элементов в футере страницы")
    @Feature("Меню в футэре страницы")
    @Story("Навигация по главной странице")
    public void checkFooterOptions() {
        mainPage.checkFooterOptions();
    }
}
