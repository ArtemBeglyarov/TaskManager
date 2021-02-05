package com.taskmanager.server.funcion;

import com.taskmanager.Model;
import com.taskmanager.model.Project;
import com.taskmanager.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateProject implements ClientThreadFunctions {
    @Override
    public void requestResponse(BufferedReader read, PrintWriter writ, Model model) throws IOException {
        writ.println("enter you name project^");
        String nameProject = read.readLine();
        Long creatorID = 0L;
        List<Long> tempUsersID = new ArrayList<>();
        int i = 1;
        for (Map.Entry<Long, User> userEntry : Model.getInstance().getUsersEntrySet()) {
            writ.println(i +
//                    " User name:" + userEntry.getValue().getUserName()+
                     " First name:" + userEntry.getValue().getFirstName()
                    + " Second name:" + userEntry.getValue().getLastName());
            tempUsersID.add(userEntry.getValue().getID());
            i++;

        }
        writ.println("Input project creator ID ^");
        int k = Integer.parseInt(read.readLine());
        if (k <= i) {
            creatorID = tempUsersID.get(k - 1);
        }
        List<Long> usersID = new ArrayList<>();
        List<Long> tasksID = new ArrayList<>();
        while (true) {
            tempUsersID = new ArrayList<>();
            i = 1;
            for (Map.Entry<Long, User> userEntry : Model.getInstance().getUsersEntrySet()) {
                writ.println(i + " User name:" + userEntry.getValue().getUserName()
                        + " First name:" + userEntry.getValue().getFirstName()
                        + " Second name:" + userEntry.getValue().getLastName());
                tempUsersID.add(userEntry.getValue().getID());
                i++;
            }
            writ.println("Введите 0 для выхода или ID пользователя для добавления в проект^");
            k = Integer.parseInt(read.readLine());
            if (k == 0) {
                break;
            }
            if (k <= i) {
                usersID.add(tempUsersID.get(k - 1));
            }
        }
        writ.println("enter description project^");
        String description = read.readLine();
        Project project = model.createProject(nameProject, usersID, tasksID, description, creatorID);
        writ.println(project.getID() + " your ID");

        model.jsonSave();
    }
}
