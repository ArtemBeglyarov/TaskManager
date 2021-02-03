package com.taskmanager.server.funcion;


import com.taskmanager.Model;
import com.taskmanager.model.Task;
import jdk.internal.org.jline.utils.Status;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CreateTask implements ClientThreadFunctions {

    @Override
    public void requestResponse(BufferedReader read, PrintWriter writ, Model model) throws IOException {
        writ.println("enter you name task");
        String name = read.readLine();

        writ.println("выберите статус задачи");
        writ.println("0 - Open\n" + "1 - Suspended\n" +
         "2 - Assigned\n" + "3 - DISCUSSION\n " + "4 - Closed\n " );
        int i = read.read();
        Task.Status status = Task.Status.values()[i];
        writ.println("0 - HIGHEST\n" + "1 - HIGH\n" +
                "2 - NORMAL\n" + "3 - LOW\n ");
        int k = read.read();
        Task.Priority priority = Task.Priority.values()[k];

        writ.println("выберите дату создания задачи");
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

        writ.println("выберите дату окончания задачи");
        String stringDate = read.readLine();
        SimpleDateFormat sinplDate = new SimpleDateFormat("yyyy-MM-dd");
        Date endDate = null;
        try {
            endDate = sinplDate.parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        writ.println(sinplDate.format(endDate).toUpperCase());


        writ.println("enter description project");
        String description = read.readLine();
        Task task = model.createTask();


    }
}
