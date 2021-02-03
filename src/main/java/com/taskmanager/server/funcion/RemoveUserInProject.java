package com.taskmanager.server.funcion;

import com.taskmanager.Model;
import com.taskmanager.model.Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class RemoveUserInProject {
    public void requestResponse(BufferedReader read, PrintWriter write, Model model) throws IOException {
        write.println("enter the project ID ");
        Long ID = Long.parseLong(read.readLine());
        Project project = model.readProject(ID);
        write.println("enter the user ID for remove in project ");
        Long uID = Long.parseLong(read.readLine());
        project.getUsersId().remove(ID);
        model.jsonSave();
    }
}
