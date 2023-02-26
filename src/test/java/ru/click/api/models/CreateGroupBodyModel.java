package ru.click.api.models;


import lombok.Data;

import java.util.ArrayList;

@Data
public class CreateGroupBodyModel {
    public String name;
    public ArrayList<Integer> accountIds;
}


//"{\n" +
//        "  \"name\": \"NewGroup\",\n" +
//        "  \"accountIds\": [\n" +
//        "    443290, 443291\n" +
//        "  ]\n" +
//        "}";