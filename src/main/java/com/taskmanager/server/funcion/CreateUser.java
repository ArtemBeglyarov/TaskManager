package com.taskmanager.server.funcion;

import com.taskmanager.Model;
import com.taskmanager.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateUser implements ClientThreadFunctions {
    Model model = Model.getInstance();

    @Override
    public void requestResponse(BufferedReader read, PrintWriter writ) throws IOException {



        writ.println("Enter your first name");
        String firstName = read.readLine();
        writ.println("Enter your last name");
        String lastName = read.readLine();
        writ.println("create a user name");
        String userName = read.readLine();
        writ.println("create a password");
        String password = read.readLine();

        User idUser = model.createUsers(firstName,lastName,userName,password);
        writ.println(idUser.getID() + " your ID ");
        model.jsonSave();
    }
}
