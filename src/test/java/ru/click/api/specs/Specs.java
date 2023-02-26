package ru.click.api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static ru.click.api.helper.CustomApiListener.withCustomTemplates;

public class Specs {

    static String masterToken = "4e8eb3d6616c0ece9f6190c080619261";
    static String user1Token = "4d9cd97882f0c4566cfc0aa364a05db9";

    public static RequestSpecification request = with()
            .contentType("application/json")
            .header("X-Auth-Token", masterToken)
            .baseUri("https://api.click.ru")
            .log().uri()
            .log().method()
            .filter(withCustomTemplates());

    public static RequestSpecification createRequest = with()
            .contentType(ContentType.JSON)
            .header("X-Auth-Token", masterToken)
            .baseUri("https://api.click.ru")
            .log().uri()
            .log().method()
            .filter(withCustomTemplates());

    public static RequestSpecification userRequest = with()
            .contentType("application/json")
            .header("X-Auth-Token", user1Token)
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
