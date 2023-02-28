package ru.click.web.config;

import org.aeonbits.owner.Config;


@Config.Sources({
        "classpath:${env}.properties"
})
public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    String getBaseUrl();

    @Key("browser")
    @DefaultValue("chrome")
    String getBrowser();

    @Key("browser_version")
    String getBrowserVersion();

    @Key("browser_size")
    String getBrowserSize();

    @Key("remoteUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String getRemoteUrl();

    @Key("isRemote")
    Boolean isRemote();
}
