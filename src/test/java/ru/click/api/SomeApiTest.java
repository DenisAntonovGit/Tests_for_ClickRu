package ru.click.api;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class SomeApiTest {

    String baseUri = "https://click.ru";
    String authEndpoint = "/User/Authorization";
    String reCaptchaToken = "03AFY_a8W7r4pV9FkioVFtMt-ysDPPyPDzmDKCksNWov64JhvDt1N-1xrv95VQxwPFlnnLUySfbcxPKZIxOhpKAmNo8NBCb54TohgS-rBzOE8fO1CCAemTP5yMzOLbVf4oMBS_INgtC_WQ6C0zILMg2gxAH_025k1Zhonsok9SbZGtPt9celMb-NnNMlWgc95ePvGdaavXPUfyu2P4qb5sSJlOmsW7ryrJoo6QcaVyl6bYcrMsZeSKfE8lQgxpLvj6E3U4qDxQnUXD_hHjjGsvVBiC2vLfZ01E26T5qEpd1PUHpLlqGc8wOySS8QhmRTQYGxn_xMDlSsZul6ohC4Uc6AJHi5HnzE2paJPG9bn2B8OdBxgTRmUwxD9EuIaKiteqPQ3seEPUe5f8A24gQyAqMyKwl31R5fCQIzBCHuYUL8ZJgCOuj35CuIhacACLmbkfJ2ef_GNpQC8q3IjMq6oR7G5LuUzljyfGCeKRyZkw4oS6JnmHTdNV8jco-0AVm3ojEVb_18aPSKblXiDJFkw2lxNeSR05u1SogMulId_tfaAkNuPNYdPM7Zv-MDiEKyMpa9BuLYdwuZoa";

    @Test
    void checkWdHubWithAuthStatus() {
        String authCookie =
                given()
                    .contentType("application/x-www-form-urlencoded")
                    .formParam("uname", "Johnwickenbaum@gmail.com")
                    .formParam("pass", "johnwick111")
//                    .formParam("recaptcha_token", reCaptchaToken)
                    .baseUri(baseUri)
                    .log().uri()
                    .when()
                    .post(authEndpoint)
                    .then()
                    .log().all()
                    .statusCode(302)
                    .extract()
                    .cookie("sessions");
        System.out.println(authCookie);

//                open("https://static.click.ru/themes/default/_img_click/logo/logo_click.svg");
//                getWebDriver().manage().addCookie(new Cookie("sessions", authCookie));
//                open("");
//                $("#right-top-menu-uname").shouldHave(text("Johnwickenbaum@gmail.com"));
    }
}
