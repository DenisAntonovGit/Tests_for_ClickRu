package ru.click.web.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.click.web.config.ProjectConfig;
import ru.click.web.config.WebDriverConfig;
import ru.click.web.helpers.Attach;
import ru.click.web.page.MainPage;

public class TestBase {

    protected final MainPage mainPage = new MainPage();
    private static WebDriverConfig config;
    private static ProjectConfig configuration;

    @BeforeAll
    static void beforeAll() {
        config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
        configuration = new ProjectConfig();
        configuration.runConfig(config);
        Configuration.pageLoadStrategy = "eager";
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        mainPage.openMainPage();
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}