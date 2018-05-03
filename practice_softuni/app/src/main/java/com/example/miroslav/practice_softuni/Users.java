package com.example.miroslav.practice_softuni;

import java.util.ArrayList;

public class Users {

    private String username;
    private String family;

    public Users(String username, String family) {
        this.username = username;
        this.family = family;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public static ArrayList<Users> createNewUsersList(int userNumbers){
        ArrayList<Users> users = new ArrayList<>();

        for (int i = 0; i < userNumbers; i++) {
            users.add(new Users("kiro ", "pesho"));
        }
        return users;
    }
}
