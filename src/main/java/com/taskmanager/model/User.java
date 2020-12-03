package com.taskmanager.model;


import com.taskmanager.ModelTaskManager;
import lombok.Getter;
import lombok.Setter;


public class User {
    @Getter
    private long userID;
    @Getter
    @Setter
    private String firstName;
    @Getter
    @Setter
    private String lastName;
    @Getter
    @Setter
    private String userName;
    @Getter
    @Setter
    private String password;
    public User() {
        this.userID =ModelTaskManager.toCreateID();;
        this.firstName = "defaultUser";
        this.lastName = "defaultUser";
        this.userName = "defaultUser";
        this.password = "defaultUser";
    }

    public User(String firstName, String lastName, String userName, String password) {
        this.userID = ModelTaskManager.toCreateID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User - " + userName +
                "\n" + "ID  - " + userID +
                "\n" + "First Name  - " + firstName +
                "\n" + "Last Name  - " + lastName +
                "\n" + "Password - " + password;
    }
}
