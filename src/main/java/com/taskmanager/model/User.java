package com.taskmanager.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.taskmanager.Model;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonView
public class User implements Serializable  {
    @JsonProperty("id")
    private final long ID;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private final String DEFAULT_STRING = "defaultUser";


    public User() {
        this.ID = Model.createID(User.class);
        this.firstName = DEFAULT_STRING;
        this.lastName = DEFAULT_STRING;
        this.userName = DEFAULT_STRING;
        this.password = DEFAULT_STRING;
    }
    public User(String firstName, String lastName, String userName, String password) {
        this.ID = Model.createID(User.class);
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
