package com.taskmanager.model;


import com.taskmanager.ModelTaskManager;
import lombok.Data;

@Data
public class User {
     private final long ID;

    private String firstName;

    private String lastName;

    private String userName;

    private String password;

    public User() {
        this.ID = ModelTaskManager.createID();
        this.firstName = "defaultUser";
        this.lastName = "defaultUser";
        this.userName = "defaultUser";
        this.password = "defaultUser";
    }

    public User(String firstName, String lastName, String userName, String password) {
        this.ID = ModelTaskManager.createID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User - " + userName +
                "\n" + "ID  - " + ID +
                "\n" + "First Name  - " + firstName +
                "\n" + "Last Name  - " + lastName +
                "\n" + "Password - " + password;
    }
}
