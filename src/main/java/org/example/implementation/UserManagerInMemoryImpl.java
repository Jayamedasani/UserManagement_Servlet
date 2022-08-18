package org.example.implementation;

import org.example.userinterface.UserOperations;
import org.example.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserManagerInMemoryImpl implements UserOperations {
    private List<User> userList=new ArrayList<>();

    @Override
    public void addUser(User newUser) {
        User existingUser = getUserDetails(newUser.getId());
        if (existingUser != null) {
            System.out.println("User with given ID is already available enter new ID");
            return;
        } else {
            userList.add(newUser);
            System.out.println("User Added to list!");
        }
    }
    @Override
    public void deleteUser(int id) {
        if (userList.isEmpty()) {
            System.out.println("Users List is empty can't delete from list");
        } else {
            User existingUser = getUserDetails(id);
            if (existingUser == null) {
                System.out.println("User with given ID is not available can't delete");
            } else {
                userList.remove(existingUser);
                System.out.println("User removed from list!");
            }
        }
    }
    @Override
    public List<User> searchUser(String userName) {
        List<User> searchList=new ArrayList<>();
        ArrayList<String> nameList = new ArrayList<>();
        for (User user : userList) {
            nameList.add(user.getName());
        }
        if (nameList.contains(userName)) {
            for (User user : userList) {
                if (user.getName() .equals(userName) ){
                    searchList.add(user);
                }
            }
            return searchList;
        } else {
            System.out.println("User with given name is Not available");
        }
        return searchList;
    }
    @Override
    public  List<User> getUsers() {
        if (userList.isEmpty()) {
            System.out.println("No Users are available");
        }
        return userList;
    }
    @Override
    public  void updateUser(User userDetails) {
        User existingUser = getUserDetails(userDetails.getId());
        if (existingUser == null) {
            System.out.println("User with given details is not available can't Update");
        } else {
            existingUser.setName(userDetails.getName());
            existingUser.setCity(userDetails.getCity());
            System.out.println("User Details are updated!");
        }
    }

    private User getUserDetails(int id) {
        for (User user :userList) {
            if (Objects.equals(user.getId(), id)) {
                return user;
            }
        }
        return null;
    }
}
