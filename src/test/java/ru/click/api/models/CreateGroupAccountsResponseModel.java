package ru.click.api.models;

import lombok.Data;

@Data
public class CreateGroupAccountsResponseModel {
    public String response;
    public GroupIDS groupIDS;

    @Data
    public static class GroupIDS{
        private int groupId;
    }
}

//{
//        "response": {
//        "groupId": 17137
//        }
//        }