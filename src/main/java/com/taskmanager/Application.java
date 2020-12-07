package com.taskmanager;


import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Application {
    public static void main(String[] args) {
        ModelTaskManager controllerTaskManager = new ModelTaskManager();
//        controllerTaskManager.createUsersDefault();
//        controllerTaskManager.createUsersDefault();
//        controllerTaskManager.createUsersDefault();
//        controllerTaskManager.repository.getAllUsers();
        View view = new View();
        view.consoleInput();


        try (FileOutputStream out = new FileOutputStream("repository.txt");
             FileInputStream in = new FileInputStream("buildings.txt")) {

            ModelTaskManager.serializeRepository(controllerTaskManager.repository, out);
            Building bui = Buildings.deserializeBuilding(in);

        }

    }
