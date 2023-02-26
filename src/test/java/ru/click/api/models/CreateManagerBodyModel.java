package ru.click.api.models;

import lombok.Data;

@Data
public class CreateManagerBodyModel {
    private String description;
    private String firstName;
    private String lastName;
    private String middleName;
}

//    "{\n" +
//            "  \"description\": \"BestUser\",\n" +
//            "  \"firstName\": \"User\",\n" +
//            "  \"lastName\": \"Userov\",\n" +
//            "  \"middleName\": \"Userovich\"\n" +
//            "}";

