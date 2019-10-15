package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class UserListTest {

    private static ByteArrayOutputStream byteArrayOutputStream;
    private static User userSample;
    private static User userSample2;

    @Before
    public void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));
        userSample = new User("000-0001", "pass");
        userSample2 = new User("000-0002", "pass2");
    }

    @Test
    public void testAddUser() {
        UserList.addUser(userSample);
        UserList.addUser(userSample2);
        assertEquals(UserList.userList.size(),2);
    }

}
