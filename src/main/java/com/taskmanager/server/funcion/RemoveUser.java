package com.taskmanager.server.funcion;

import com.taskmanager.Model;
import com.taskmanager.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class RemoveUser implements ClientThreadFunctions{

    @Override
    public void requestResponse(BufferedReader read, PrintWriter write, Model model) throws IOException {

        boolean existUser = false;
        write.println("enter the user ID to delete");
        Long ID = Long.parseLong(read.readLine());
        User userToDelete = model.readUser(ID);
        existUser = model.isUserExist(userToDelete.getUserName(),userToDelete.getPassword());
        if (existUser) {

            model.removeUser(ID);
            write.print("user deleted");
            model.jsonSave();
        } else {
            write.print("User is not found");
        }


    }
}
