package com.taskmanager.server.funcion;

import com.taskmanager.Model;
import com.taskmanager.model.Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class AddUserInProject implements ClientThreadFunctions{
    @Override
    public void requestResponse(BufferedReader read, PrintWriter write, Model model) throws IOException {
        write.println("enter the project ID^");
        Long projectID = Long.parseLong(read.readLine());
        Project project = model.readProject(projectID);
        write.println("enter the user ID for add in project^");
        Long userID = Long.parseLong(read.readLine());
        project.getUsersId().add(userID);
        model.jsonSave();

    }
}
