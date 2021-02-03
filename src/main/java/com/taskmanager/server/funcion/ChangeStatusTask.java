package com.taskmanager.server.funcion;

import com.taskmanager.Model;
import com.taskmanager.model.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ChangeStatusTask implements ClientThreadFunctions {
    @Override
    public void requestResponse(BufferedReader read, PrintWriter writ, Model model) throws IOException {
        writ.println("enter you task");
        Long ID = Long.parseLong(read.readLine());
        Task task = model.readTask(ID);
        writ.println("Status task" + task.getStatus());
        writ.println("выберите статус задачи");
        writ.println("0 - Open\n" + "1 - Suspended\n" +
                "2 - Assigned\n" + "3 - DISCUSSION\n " + "4 - Closed\n " );
        int i = read.read();
        Task.Status status = Task.Status.values()[i];
        model.jsonSave();
    }

}
