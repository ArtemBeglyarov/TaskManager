package com.taskmanager.server.funcion;

import com.taskmanager.Model;
import com.taskmanager.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class UserInformation implements ClientThreadFunctions{
    @Override
    public void requestResponse(BufferedReader read, PrintWriter write, Model model) throws IOException {
        boolean existUser = false;
        write.println("enter the user ID^");

        Long ID = Long.parseLong(read.readLine().trim());
        User userInformation = model.readUser(ID);
        existUser = model.isUserExist(userInformation.getUserName(), userInformation.getPassword());
        if (existUser) {
            write.println("User information: "+userInformation.toString());

        } else {
            write.println("User is not found");
        }
    }
}
