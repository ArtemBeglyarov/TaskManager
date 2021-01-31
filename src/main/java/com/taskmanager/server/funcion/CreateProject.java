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

public class CreateProject implements ClientThreadFunctions{
    public void requestResponse(BufferedReader read, PrintWriter writ, Model model) throws IOException{
        writ.println("enter you name project");
        String nameProject = read.readLine();
        Long creatorID = 0L;
        writ.println("Введите номер создателя проекта");
        List<Long> tempUsersID = new ArrayList<>();
        int i = 1;
        for (Map.Entry< Long, User > userEntry : Model.getInstance().getUsersEntrySet()){
            writ.println(i + " userName:" + userEntry.getValue().getUserName()
                    + " firstName:" + userEntry.getValue().getFirstName()
                    + " secondName:" + userEntry.getValue().getLastName());
            tempUsersID.add(userEntry.getValue().getID());
            i++;
        }
        int k = read.read();//вероятно может не работать.
        if ( k <= i){
            creatorID = tempUsersID.get(k-1);
        }
        List<Long> usersID = new ArrayList<>();
        List<Long> tasksID = new ArrayList<>();
        while (true){
            writ.println("Введите 0 для выхода или номер пользователя для добавления в проект");
            tempUsersID = new ArrayList<>();
            i = 1;
            for (Map.Entry< Long, User > userEntry : Model.getInstance().getUsersEntrySet()){
                writ.println(i + " userName:" + userEntry.getValue().getUserName()
                        + " firstName:" + userEntry.getValue().getFirstName()
                        + " secondName:" + userEntry.getValue().getLastName());
                tempUsersID.add(userEntry.getValue().getID());
                i++;
            }
            k = read.read();
            if (k == 0){
                break;
            }
            if ( k <= i){
                usersID.add(tempUsersID.get(k-1));
            }
        }
        writ.println("enter description project");
        String description = read.readLine();

        Project project = model.createProject(nameProject,usersID,tasksID,description,creatorID);
        writ.println(project.getID() + " your ID ");

        model.jsonSave();
    }
}
