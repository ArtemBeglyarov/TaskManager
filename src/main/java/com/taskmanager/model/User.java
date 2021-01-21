package com.taskmanager.model;


import com.fasterxml.jackson.annotation.*;
import com.taskmanager.Model;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonView
public class User implements Serializable {
    @JsonProperty("id")
    private  long ID;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    public User() {

    }

    public User(String firstName, String lastName, String userName, String password) {

        this.ID =Model.createID(User.class);
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }

//    public User(  long ID, String firstName, String lastName, String userName, String password) {
//        this.ID = ID;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.userName = userName;
//        this.password = password;
//    }





    @Override
    public String toString() {
        return "User - " + userName +
                "\n" + "ID  - " + ID +
                "\n" + "First Name  - " + firstName +
                "\n" + "Last Name  - " + lastName +
                "\n" + "Password - " + password;
    }
}
