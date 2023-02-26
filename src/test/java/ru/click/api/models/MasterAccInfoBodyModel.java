package ru.click.api.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MasterAccInfoBodyModel {
    private String response;
    private MasterInfo masterInfo;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MasterInfo {
        private String type;
        private int id;

    }
}

//{
//    "response": {
//        "type": "MASTER",
//        "email": "Johnwickenbaum@gmail.com",
//        "id": 1668813,
//        "login": "Johnwickenbaum@gmail.com@b1f3c52df00cb98fe617303b064b7f29.seopult",
//        "createdAt": "2023-02-20T00:41:58+03:00",
//        "description": "",
//        "firstName": "",
//        "lastName": "",
//        "middleName": "",
//        "balance": 0
//    }
//}