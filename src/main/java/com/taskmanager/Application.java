package com.taskmanager;


public class Application {
    public static void main(String[] args) {
        ControllerTaskManager controllerTaskManager = new ControllerTaskManager();
        RepositoryTaskManager taskManagerRepository = new RepositoryTaskManager();

        controllerTaskManager.createUsersDefault();
        controllerTaskManager.createUsersDefault();
        controllerTaskManager.createUsersDefault();
        taskManagerRepository.getAllUsers();

    }

}
