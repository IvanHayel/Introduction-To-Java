package com.epam.introduction.tasks.task_3.model.user;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "users")
public class Users {
    private List<User> users;

    public Users() {
        users = new ArrayList<>();
    }

    public List<User> getUsers() {
        return users;
    }

    @XmlElement(name = "user")
    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        if (user != null) {
            users.add(user);
        }
    }

    public boolean contains(User user) {
        return users.contains(user);
    }

    public boolean isLoginExist(String login) {
        for (User user : users) {
            if (login.equals(user.getLogin())) {
                return true;
            }
        }
        return false;
    }

    public User get(String login) {
        for (User user : users) {
            if (login.equals(user.getLogin())) {
                return user;
            }
        }
        return null;
    }
}