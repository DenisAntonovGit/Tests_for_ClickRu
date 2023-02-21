package ru.click.web.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.click.web.config.ProjectConfig;
import ru.click.web.config.WebDriverConfig;
import ru.click.web.helpers.Attach;
import ru.click.web.page.MainPageElements;

public class TestBase {

    private static WebDriverConfig config;
    private static ProjectConfig configuration;

    @BeforeAll
    static void beforeAll() {
        config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
        configuration = new ProjectConfig();
        configuration.runConfig(config);
    }

    @BeforeEach
    void beforeEach() {
        new MainPageElements().openMainPage();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}