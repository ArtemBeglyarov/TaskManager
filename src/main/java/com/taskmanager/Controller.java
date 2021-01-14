package com.taskmanager;

import com.taskmanager.model.Project;
import com.taskmanager.model.Task;

import java.util.List;

public class Controller {
    private static Controller instance;
    Model model = Model.getInstance();

    Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }


    public void addTaskInProject(long projectID, long taskID){
        //TODO проверка на уникальность таска
       Project project = Model.getInstance().readProject(projectID);
       project.getTasksId().add(taskID);

    }
    public void deleteTaskInProject(long projectID, long taskID){
        Project project = Model.getInstance().readProject(projectID);
        int index = project.getTasksId().indexOf(taskID);
        if(index != -1){
            project.getTasksId().remove(index);
            Model.getInstance().deleteTask(taskID);
        }
    }

}
