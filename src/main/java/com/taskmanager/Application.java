package com.taskmanager;


import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {

        Model controller = new Model();
//
//        try (FileInputStream in = new FileInputStream("src/main/repository.txt")) {
//            controller.repositoryTask = Model.deserializeRepository(in);
//        }

        controller.repositoryTask = controller.jsonLoad();

//        controller.createUsers();
//        controller.repositoryTask.removeUser(2222);
        controller.repositoryTask.getAllUsers();
        controller.jsonSave(controller.repositoryTask);



//        View view = new View();
//        view.consoleInput();


//        try (FileOutputStream out = new FileOutputStream("src/main/repository.txt")) {
//            Model.serializeRepository(controller.repositoryTask, out);
//        }

    }
}
