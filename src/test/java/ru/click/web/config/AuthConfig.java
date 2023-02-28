package ru.click.web.config;

import org.aeonbits.owner.Config;

@Config.Sources(
        "classpath:auth.properties"
)
public interface AuthConfig extends Config{

    @Key("masterToken")
    String getMasterToken();

    @Key("user1Token")
    String getUserToken();
}
