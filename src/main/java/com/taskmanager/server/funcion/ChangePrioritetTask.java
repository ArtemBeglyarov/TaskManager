package com.taskmanager.server.funcion;

import com.taskmanager.Model;
import com.taskmanager.model.Task;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ChangePrioritetTask implements ClientThreadFunctions {

    @Override
    public void requestResponse(BufferedReader read, PrintWriter writ, Model model) throws IOException {
        writ.println("enter you task^");
        Long ID = Long.parseLong(read.readLine());
        Task task = model.readTask(ID);
        writ.println("Status task" + task.getPriority());
        writ.println("выберите статус задачи");
        writ.println("0 - HIGHEST\n" + "1 - HIGH\n" +
                "2 - NORMAL\n" + "3 - LOW\n^");
        int taskPriority = Integer.parseInt(read.readLine());
        Task.Priority priority = Task.Priority.values()[taskPriority];
        model.jsonSave();
    }
}
