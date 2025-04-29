package org.example;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private List<User> users = new ArrayList<User>();

    public User findByEmail(String email) {
        return new User("mahshin@gmail.com", "mahshin12345");
    }

}


