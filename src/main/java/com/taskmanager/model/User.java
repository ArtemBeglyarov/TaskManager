package com.taskmanager.model;


import com.taskmanager.Model;
import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private final long ID;

    private String firstName;

    private String lastName;

    private String userName;

    private String password;

    public User() {
        this.ID = Model.createID();
        this.firstName = "defaultUser";
        this.lastName = "defaultUser";
        this.userName = "defaultUser";
        this.password = "defaultUser";
    }

    public User(String firstName, String lastName, String userName, String password) {
        this.ID = Model.createID();
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
