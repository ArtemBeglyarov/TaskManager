package com.taskmanager;


public class Application {
    public static void main(String[] args) {
        ModelTaskManager controllerTaskManager = new ModelTaskManager();
//        controllerTaskManager.createUsersDefault();
//        controllerTaskManager.createUsersDefault();
//        controllerTaskManager.createUsersDefault();
//        controllerTaskManager.repository.getAllUsers();
        View view = new View();
        view.consoleInput();

    }

}
