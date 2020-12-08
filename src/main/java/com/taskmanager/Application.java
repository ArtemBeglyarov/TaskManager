package com.taskmanager;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        ModelTaskManager controllerTaskManager = new ModelTaskManager();
        try (FileInputStream in = new FileInputStream("src/main/repository.txt")) {
            ModelTaskManager.deserializeRepository(in);

        }

//        controllerTaskManager.createUsers();
//        controllerTaskManager.createUsersDefault();
//        controllerTaskManager.createUsersDefault();
        controllerTaskManager.repository.getAllUsers();
//        View view = new View();
//        view.consoleInput();


        try (FileOutputStream out = new FileOutputStream("src/main/repository.txt")) {
            ModelTaskManager.serializeRepository(controllerTaskManager.repository, out);
        }

    }
}
