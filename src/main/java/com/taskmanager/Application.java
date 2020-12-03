package com.taskmanager;

import com.taskmanager.model.User;

public class Application {
    public static void main(String[] args) {
        ControllerTaskManager controllerTaskManager = new ControllerTaskManager();
        TaskManagerRepository taskManagerRepository = new TaskManagerRepository();

        controllerTaskManager.createUsersDefault();
        controllerTaskManager.createUsersDefault();
        controllerTaskManager.createUsersDefault();
        controllerTaskManager.createUsersDefault();


        taskManagerRepository.getAllUsers();

    }

}
