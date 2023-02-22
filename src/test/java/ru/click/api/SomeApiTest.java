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

//'prmt=1676466641WyfFWz8OSnO2q3;
// if=1i;
// _gcl_au=1.1.628009876.1676466645;
// last_hided_news=614;
// SeoPult=4fc1024eqOuO8WrHRnOxJVEAWuGPnHlJ'

//'prmt=1676466641WyfFWz8OSnO2q3;
// if=1i;
// _gcl_au=1.1.628009876.1676466645;
// last_hided_news=614;
// SeoPult=94675914b1Svx6FpUxFVWA1wlthbLmgd;
// pp_uid=1668813'


//Curl for autorization
//curl 'https://click.ru/User/Authorization' \
//  -H 'Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9' \
//  -H 'Accept-Language: ru,en;q=0.9' \
//  -H 'Cache-Control: no-cache' \
//  -H 'Connection: keep-alive' \
//  -H 'Content-Type: application/x-www-form-urlencoded' \
//  -H 'Cookie: prmt=1676466641WyfFWz8OSnO2q3; if=1i; _gcl_au=1.1.628009876.1676466645; last_hided_news=614; SeoPult=4bebaf21KujtXXuolopZTe2CVMoKDhOT; sessions=4bebaf21KujtXXuolopZTe2CVMoKDhOT' \
//  -H 'DNT: 1' \
//  -H 'Origin: https://click.ru' \
//  -H 'Pragma: no-cache' \
//  -H 'Referer: https://click.ru/' \
//  -H 'Sec-Fetch-Dest: document' \
//  -H 'Sec-Fetch-Mode: navigate' \
//  -H 'Sec-Fetch-Site: same-origin' \
//  -H 'Sec-Fetch-User: ?1' \
//  -H 'Upgrade-Insecure-Requests: 1' \
//  -H 'User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 YaBrowser/23.1.0.2940 Yowser/2.5 Safari/537.36' \
//  -H 'sec-ch-ua: "Not?A_Brand";v="8", "Chromium";v="108", "Yandex";v="23"' \
//  -H 'sec-ch-ua-mobile: ?0' \
//  -H 'sec-ch-ua-platform: "macOS"' \
//  --data-raw 'op=login&recaptcha_token=03AFY_a8UEjM6uwv4EIWKMYaZFQtvZW7PYRNZqUnuASU0YspPA0V9e3FPNa9_ntsGq6Ipntv_Owru9sdbv0F9EL2F-FnqJTR26ArEKD7GOJ5sq7QSG-LORAHtu01jxBhNtivVn8k-2QsmzKhSiIytjBb2v_Y0DdYfC23Gw0Li6fDlZ1B7MzK8zJElHliCnu5jpVDW_fXHcLhWfooKXDdMCmiZYVEtTrPPYIEnsfSf-c2U1f9-c8vlsUAI-ZpeJ0Bl6FnuyxY4a3nXsygikrU08iUlHgwgo84SDYUanjWn9Ga3mrYLck3fRZWLuXEwl1BMiyRYyZ3DUeCAwSUeF_BfrUMmCLotnVURxdFna_rwb7BePoiz0H1tuS4ERATEYSth0jkw3PbBfFVsr8LgpFE2-J0resOhBBjuwCyb1ZnAK96AJSJkOj7pwvGaxGyjk8nnOS3b8Byml0miACgLFYGU9iQrk_2h9ZL8Avn2oNSfyZKhFr7mKVewh8k4qDwBEYS_lAdmHA3p0fuPw7lINdMNkJT8ZUP_EsP_JLErefkxzZWzWaW2vGUAf0kWVBJtJxttw33K_U9zB8oIB&ga_client_id=&uname=Johnwickenbaum%40gmail.com&pass=johnwick111' \
//  --compressed