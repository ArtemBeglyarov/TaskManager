package com.taskmanager.server.funcion;

import com.taskmanager.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class RemoveUser implements ClientThreadFunctions{

    @Override
    public void requestResponse(BufferedReader read, PrintWriter write, Model model) throws IOException {
        write.println("enter the user ID to delete");
        Long remove = Long.parseLong(read.readLine());
        model.removeUser(remove);
        write.println("user deleted");

        model.jsonSave();
    }
}
