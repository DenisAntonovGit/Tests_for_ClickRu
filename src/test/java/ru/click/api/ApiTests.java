package ru.click.api;

import com.github.javafaker.Faker;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Locale;
import ru.click.api.helper.ApiTestData;
import ru.click.api.models.*;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static ru.click.api.specs.Specs.*;

@Tag("API")
@Owner("antonovdenis")
public class ApiTests extends ApiTestData {

    Faker faker = new Faker(new Locale("en"));
    String groupName = faker.name().lastName();

    @Test
    @DisplayName("Запрос для получения списка всех USERS Master-аккаунта")
    @Feature("Функциональность Master-аккаунта")
    @Story("Работа с Мастер-аккаунтом")
    void getListOfUsers() {
        given(request)
                .when()
                .get(getUsersEndpoint)
                .then()
                .spec(responseSpec);
    }

    @Test
    @DisplayName("Запрос на создание нового USER")
    @Feature("Функциональность Master-аккаунта")
    @Story("Работа с Мастер-аккаунтом")
    void createUser() {
        CreateManagerBodyModel body = new CreateManagerBodyModel();
        body.setDescription("Best User");
        body.setFirstName("User");
        body.setLastName("Userov");
        body.setMiddleName("Userovich");
        CreateManagerResponseModel.UserInfo info = given(createRequest)
                .body(body)
                .when()
                .post(postUserEndpoint)
                .then()
                .spec(responseSpec)
                .extract().body().jsonPath().getObject("response", CreateManagerResponseModel.UserInfo.class);
        assertThat(info.getType()).isEqualTo("USER");
    }

    @Test
    @DisplayName("Запрос на получение инфорамции о Master-аккаунте")
    @Feature("Функциональность Master-аккаунта")
    @Story("Работа с Мастер-аккаунтом")
    void getMasterUserInfo() {
        MasterAccInfoBodyModel.MasterInfo masterInfo = given(request)
                .when()
                .get(getProfileInfoEndpoint)
                .then()
                .spec(responseSpec)
                .extract().body().jsonPath().getObject("response", MasterAccInfoBodyModel.MasterInfo.class);
        assertThat(masterInfo.getType()).isEqualTo("MASTER");
        assertThat(masterInfo.getId()).isEqualTo(1668813);
    }

    @Test
    @DisplayName("Получение списка созданных маркетинговых аккаунтов у конкретного пользователя USER №1")
    @Feature("Функциональность User-аккаунта")
    @Story("Работа с User-аккаунтом")
    void getMarketingsAccounts() {
        given(userRequest)
                .when()
                .get(getMarketingAccEndpoint)
                .then()
                .spec(responseSpec)
                .assertThat().body("response.accounts.id", hasItems(443292, 443290, 443291))
                .extract().body().asString();
    }

    @Test
    @DisplayName("Запрос на создание группы маркетинговых аккаунтов у пользователя USER №1")
    @Feature("Функциональность User-аккаунта")
    @Story("Работа с User-аккаунтом")
    void createGroupOfAccounts() {
        CreateGroupBodyModel data = new CreateGroupBodyModel();
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(443292);
        myList.add(443290);
        data.setName(groupName);
        data.setAccountIds(myList);
        CreateGroupAccountsResponseModel.GroupIDS groupIDS = given(userRequest)
                .body(data)
                .when()
                .post(postGroupCreatingEndpoint)
                .then()
                .spec(responseSpec)
                .extract().body().jsonPath().getObject("response", CreateGroupAccountsResponseModel.GroupIDS.class);
        assertThat(groupIDS.getGroupId()).isNotNull();
    }

    @Test
    @DisplayName("Запрос на создание и удаление группы маркетинговых аккаунтов у USER №1")
    @Feature("Функциональность User-аккаунта")
    @Story("Работа с User-аккаунтом")
    void DeletingGroup() {
        CreateGroupBodyModel data = new CreateGroupBodyModel();
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(443292);
        myList.add(443291);
        data.setName(groupName);
        data.setAccountIds(myList);
        CreateGroupAccountsResponseModel.GroupIDS groupIDS = given(userRequest)
                .body(data)
                .when()
                .post(postGroupCreatingEndpoint)
                .then()
                .spec(responseSpec)
                .extract().body().jsonPath().getObject("response", CreateGroupAccountsResponseModel.GroupIDS.class);
        assertThat(groupIDS.getGroupId()).isNotNull();
        int groupAccIds = groupIDS.getGroupId();
        given(userRequest)
                .when()
                .delete(deleteGroupEndpoint + groupAccIds)
                .then()
                .statusCode(200);
    }
}

