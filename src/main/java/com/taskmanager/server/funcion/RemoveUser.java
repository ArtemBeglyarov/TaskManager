package com.taskmanager.server.funcion;

import com.taskmanager.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class RemoveUser implements ClientThreadFunctions{

    @Override
    public void requestResponse(BufferedReader read, PrintWriter writ, Model model) throws IOException {
        writ.println("enter the user ID to delete");
        Long remove = Long.parseLong(read.readLine());
        model.removeUser(remove);
        writ.println("user deleted");

        model.jsonSave();
    }
}
