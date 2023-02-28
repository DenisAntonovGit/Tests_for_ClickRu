package ru.click.web.config;

import org.aeonbits.owner.Config;


@Config.Sources({
        "classpath:${env}.properties"
})
public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    String getBaseUrl();

    @Key("browser")
    String getBrowser();

    @Key("browser_version")
    String getBrowserVersion();

    @Key("browser_size")
    String getBrowserSize();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("isRemote")
    Boolean isRemote();
}
