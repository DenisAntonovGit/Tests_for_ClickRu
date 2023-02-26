package ru.click.web.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.click.web.page.CalculationPage;

public class MainPageTest extends TestBase{


    CalculationPage calcPage = new CalculationPage();

    @Test
    @DisplayName("Проверка работы кнопки регистрации на главной странице")
    public void openRegistrationModal() {
        mainPage.checkRegistrationModal();
    }

    @Test
    @DisplayName("Проверка переключения на раздел Демо в модальном окне регистрации")
    public void switchToDemoOnRegistrationModal() {
        mainPage.switchToDemo();
    }

    @Test
    @DisplayName("Проверка переключения на раздел авторизации в модальном окне регистрации")
    public void switchToAutorizationOnRegistrationModal() {
        mainPage.switchToAutorization();
    }

//    В этом поле на сайте есть баг, некорректно рассчитывающий сумму при удалении
//    значений из полей ввода! TODO Зафиксировать в Jira
    @Test
    @DisplayName("Проверка работы калькулятора экономии на главной странице")
    public void verifyEffectiveOfClickingCalc() {
        mainPage.verifyMainPageCalc();
    }

    @Test
    @DisplayName("Проверка работы калькулятора партнёрского вознаграждения")
    public void calculatorOfIncome() {
        calcPage.openCalculationPage();
        calcPage.fillCalculatorOfIncome();
        calcPage.verifyCalculatorOfIncome();
    }

    @Test
    @DisplayName("Проверка элементов главного меню")
    public void checkHeaderMenu() {
        mainPage.checkHeaderElements();
    }

    @Test
    @DisplayName("Проверка элементов в футере страницы")
    public void checkFooterOptions() {
        mainPage.checkFooterOptions();
    }
}
