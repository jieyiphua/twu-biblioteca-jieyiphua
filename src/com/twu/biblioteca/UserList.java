package com.twu.biblioteca;

import java.util.ArrayList;

public class UserList {

    public static ArrayList<User> userList = new ArrayList<User>();

    public static void originalUserList() {
        User user1 = new User("000-0001", "pass");
        User user2 = new User("000-0002", "pass2");
    }

    public static void addUser(User user) {
        userList.add(user);
    }

}
