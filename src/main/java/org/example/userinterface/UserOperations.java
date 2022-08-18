package org.example.userinterface;

import org.example.model.User;

import java.util.List;

public interface UserOperations {
    void addUser(User user);
    void deleteUser(int id);
    void updateUser(User user);
    List<User> getUsers();
    List<User> searchUser(String name);
}