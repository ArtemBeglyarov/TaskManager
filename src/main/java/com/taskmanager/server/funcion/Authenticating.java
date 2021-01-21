package com.taskmanager.server.funcion;

import com.taskmanager.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Authenticating implements ClientThreadFunctions {
    Repository repository = Repository.getInstance();

    @Override
    public void requestResponse(BufferedReader read, PrintWriter writ) throws IOException {

        writ.println("input Username");
        String username = read.readLine();
        writ.println("input password");
        String pass = read.readLine();
        if (repository.getAllUsers(username, pass) == 0) {
            writ.println("Incorrect username or password");

        } else {
            writ.println("Welcome");
        }


    }
}
