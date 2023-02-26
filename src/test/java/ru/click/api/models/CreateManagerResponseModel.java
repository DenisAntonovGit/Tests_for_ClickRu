package ru.click.api.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateManagerResponseModel {
    private String response;
    private UserInfo userInfo;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UserInfo {
        private String type;
    }
}

//{
//        "response": {
//        "id": 1670134,
//        "login": "click1668813_1677331479863",
//        "type": "USER",
//        "createdAt": "2023-02-25T16:24:39+03:00",
//        "description": "User №4",
//        "firstName": "User",
//        "lastName": "",
//        "middleName": "Userovich",
//        "balance": 0
//        }
//        }
