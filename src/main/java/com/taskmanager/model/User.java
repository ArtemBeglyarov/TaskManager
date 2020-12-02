package com.taskmanager.model;



public class User {


    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    public User( String firstName, String lastName, String userName, String password) {

        this.id =;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }


}
