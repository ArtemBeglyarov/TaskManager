package com.taskmanager;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {

        Model controller = new Model();

        try (FileInputStream in = new FileInputStream("src/main/repository.txt")) {
            controller.repositoryTask = Model.deserializeRepository(in);
        }


//        controller.createUsers();
//        controller.repositoryTask.removeUser(2222);
        controller.repositoryTask.getAllUsers();


//        View view = new View();
//        view.consoleInput();


//        try (FileOutputStream out = new FileOutputStream("src/main/repository.txt")) {
//            Model.serializeRepository(controller.repositoryTask, out);
//        }

    }
}
