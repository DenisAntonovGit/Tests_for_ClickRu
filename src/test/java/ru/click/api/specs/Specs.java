package ru.click.api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.aeonbits.owner.ConfigFactory;
import ru.click.web.config.AuthConfig;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static ru.click.api.helper.CustomApiListener.withCustomTemplates;

public class Specs {

    static AuthConfig tokens = ConfigFactory.create(AuthConfig.class);

    public static RequestSpecification request = with()
            .contentType("application/json")
            .header("X-Auth-Token", tokens.getMasterToken())
            .baseUri("https://api.click.ru")
            .log().uri()
            .log().method()
            .filter(withCustomTemplates());

    public static RequestSpecification createRequest = with()
            .contentType(ContentType.JSON)
            .header("X-Auth-Token", tokens.getMasterToken())
            .baseUri("https://api.click.ru")
            .log().uri()
            .log().method()
            .filter(withCustomTemplates());

    public static RequestSpecification userRequest = with()
            .contentType("application/json")
            .header("X-Auth-Token", tokens.getUserToken())
            .baseUri("https://api.click.ru")
            .log().uri()
            .log().method()
            .filter(withCustomTemplates());

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .build();
}
