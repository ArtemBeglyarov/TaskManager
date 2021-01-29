package com.taskmanager.server.funcion;

import com.taskmanager.Model;
import com.taskmanager.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateUser implements ClientThreadFunctions {

    @Override
    public void requestResponse(BufferedReader read, PrintWriter write, Model model) throws IOException {


        write.println("Enter your first name");
        String firstName = read.readLine();
        write.println("Enter your last name");
        String lastName = read.readLine();
        write.println("create a user name");
        String userName = read.readLine();
        write.println("create a password");
        String password = read.readLine();

        User idUser = model.createUsers(firstName,lastName,userName,password);
        write.println(idUser.toString());
        write.flush();
        model.jsonSave();
    }
}
