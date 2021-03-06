package com.taskmanager.server.funcion;


import com.taskmanager.Model;
import com.taskmanager.model.Project;
import com.taskmanager.model.Task;
import com.taskmanager.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.zip.ZipEntry;

public class CreateTask implements ClientThreadFunctions {

    @Override
    public void requestResponse(BufferedReader read, PrintWriter writ, Model model) throws IOException {
        writ.println("enter you name task^");
        String name = read.readLine();

        writ.println("select task status");
        writ.println("0 - Open\n" + "1 - Suspended\n" +
         "2 - Assigned\n" + "3 - DISCUSSION\n" + "4 - Closed\n^" );
        Integer taskStatus =Integer.parseInt(read.readLine());
        Task.Status status = Task.Status.values()[taskStatus];

        writ.println("select task priority");
        writ.println("0 - HIGHEST\n" + "1 - HIGH\n" +
                "2 - NORMAL\n" + "3 - LOW\n^");

        int taskPriority = Integer.parseInt(read.readLine());
        Task.Priority priority = Task.Priority.values()[taskPriority];

        writ.println("input creation date yyyy-MM-dd^");
        String tempStartDate = read.readLine();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        try {
            startDate = s.parse(tempStartDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat a = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        writ.println(a.format(startDate).toUpperCase());

        Date duoDate = null;

        writ.println("input the end date of the task yyyy-MM-dd^");
        String stringDate = read.readLine();
        SimpleDateFormat sinplDate = new SimpleDateFormat("yyyy-MM-dd");
        Date endDate = null;
        try {
            endDate = sinplDate.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat b= new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        writ.println(b.format(endDate).toUpperCase());

        writ.println("select projectID^");
        Long tempProjectID = Long.parseLong(read.readLine());
        Project project = model.readProject(tempProjectID);
        if( project ==null){
            writ.println(" ID is not vallide");
            return;
        }
        //выбор исполнителя задачи;
        Long reporterId = 0L;
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
            reporterId = tempUsersID.get(k - 1);
        }
        writ.println("select assigneeId^");
        Long tempAssigneeId = Long.parseLong(read.readLine());
        User assigneeId = model.readUser(tempAssigneeId);
        if( assigneeId ==null){
            writ.println(" ID is not vallide");
            return;
        }
        writ.println("enter description project^");
        String description = read.readLine();
        model.createTask(name,status,priority,description,startDate,duoDate,endDate,tempProjectID,
                reporterId,tempAssigneeId);

// TODO     добавить выбор id user которые находяться в проекте.
// TODO     переписать метод changestatus
// TODO     добавить фунуцию добавление задачи в проект в классе CreateProject (поробовать вызвать клсс CreateTask)


    }
}
