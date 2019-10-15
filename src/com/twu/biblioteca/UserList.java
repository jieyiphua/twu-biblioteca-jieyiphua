package com.twu.biblioteca;

import java.util.ArrayList;

public class UserList {

    public static ArrayList<User> userList = new ArrayList<User>();

    public static void originalUserList() {
        User user1 = new User("000-0001", "pass");
        User user2 = new User("000-0002", "pass2");
        UserList.addUser(user1);
        UserList.addUser(user2);
    }

    public static void addUser(User user) {
        userList.add(user);
    }

    public static User getUser(String inputLibraryNumber) {
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).libraryNumber == inputLibraryNumber) {
                return userList.get(i);
            }
        }
        return null;
    }
}
