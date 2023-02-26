package ru.click.api;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import ru.click.api.models.CreateGroupBodyModel;
import ru.click.api.models.CreateManagerBodyModel;
import ru.click.api.models.CreateManagerResponseModel;
import ru.click.api.models.MasterAccInfoBodyModel;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;
import static ru.click.api.specs.Specs.*;


public class SomeApiTest {

    String getUsersEndpoint = "/V0/users";
    String postUserEndpoint = "/V0/users";
    String getProfileInfoEndpoint = "/V0/user";
    String getMarketingAccEndpoint = "/V0/accounts";
    String postGroupCreatingEndpoint = "/V0/accounts/groups";
    String deleteGroupEndpoint = "/V0/accounts/groups/";

    @Test
    void getListOfUsers() {
        given(request)
                .when()
                .get(getUsersEndpoint)
                .then()
                .spec(responseSpec);
    }

    @Test
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
                .log().all()
                .statusCode(200)
                .extract().body().jsonPath().getObject("response", CreateManagerResponseModel.UserInfo.class);
        assertThat(info.getType()).isEqualTo("USER");
    }

    @Test
    void getMasterUserInfo() {
        MasterAccInfoBodyModel.MasterInfo masterInfo = given(request)
                .when()
                .get(getProfileInfoEndpoint)
                .then()
                .log().all()
                .statusCode(200)
                .extract().body().jsonPath().getObject("response", MasterAccInfoBodyModel.MasterInfo.class);
        assertThat(masterInfo.getType()).isEqualTo("MASTER");
        assertThat(masterInfo.getId()).isEqualTo(1668813);
    }

    @Test
    void getMarketingsAccounts() {
        String arrayOfAccounts = given(userRequest)
                .when()
                .get(getMarketingAccEndpoint)
                .then()
                .log().all()
                .assertThat().body("response.accounts.id", hasItems(443292, 443290, 443291))
                .statusCode(200)
                .extract().body().asString();
        System.out.println(arrayOfAccounts);
    }

    @Test
    void createGroupOfAccounts() {
        CreateGroupBodyModel data = new CreateGroupBodyModel();
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(443292);
        myList.add(443290);
        data.setName("NewGroup");
        data.setAccountIds(myList);
        given(userRequest)
                .body(data)
                .when()
                .post(postGroupCreatingEndpoint)
                .then()
                .log().all()
                .statusCode(200)
                .extract().body();
    }
    //{
    //    "response": {
    //        "groupId": 17145
    //    }
    //}
    @Test
    void deleteGroup() {
        given(userRequest)
                .when()
                .delete(deleteGroupEndpoint + "17145")
                .then()
                .statusCode(200);
    }
}



